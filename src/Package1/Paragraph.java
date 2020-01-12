package Package1;

import java.util.ArrayList;

public class Paragraph implements Element, Observable{
    private String _paragraphName;
    private AlignStrategy _strategy;
    private String _oldValue;
    private ArrayList<Observer> obsList = new ArrayList<Observer>();
    public String get_paragraphName() {
        return _paragraphName;
    }

    public void set_paragraphName(String _paragraphName) {
        this._paragraphName = _paragraphName;
    }

    public Paragraph(String paragraphName){
        _paragraphName = paragraphName;
        obsList.add(DocumentManager.getInstance().getFirstObserver());
    }

    @Override
    public void print() {
        System.out.println("Paragraph name: "+get_paragraphName());
        if(_strategy == null){
            System.out.println(_paragraphName);
        }else{
            _strategy.Print(_paragraphName);
        }
    }

    public void SetStrategy(AlignStrategy Strategy){
        _strategy = Strategy;
    }

    @Override
    public void Accept(BookStatistics bookStatistics) {
        bookStatistics.Visit(this);
    }
    public void setNewValue(String newValue) {
    	this._oldValue = _paragraphName;
    	this._paragraphName = newValue;
    	this.notifyObservers();
    }
    
    public void addObserver(Observer ob) {
    	this.obsList.add(ob);
    }
    
    public void removeObserver(Observer ob) {
    	int indexObs = this.obsList.indexOf(ob);
    	this.obsList.remove(indexObs);
    }
    
    public void notifyObservers() {
    	for(Observer obs : this.obsList) {
    		obs.update(this._oldValue,this._paragraphName);
    	}
    }
}
