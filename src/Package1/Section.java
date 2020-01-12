package Package1;

import java.util.ArrayList;

public class Section implements Element, Observable {
	private String _oldValue;
	private ArrayList<Observer> obsList = new ArrayList<Observer>();
    private String _sectionTitle;
    public ArrayList<Element> content;

    public Section(String title){
        this._sectionTitle = title;
        content = new ArrayList<Element>();
        obsList.add(DocumentManager.getInstance().getFirstObserver());
    }

    public int AddElement(Element element){
        content.add(element);
        return content.indexOf(element);
    }

    public void RemoveElement(Element element){
        content.remove(element);
    }

    public Element GetElement(int indexOfElement){
        return content.get(indexOfElement);
    }

    public String get_sectionTitle() {
        return _sectionTitle;
    }

    public void set_sectionTitle(String _sectionTitle) {
        this._sectionTitle = _sectionTitle;
    }

    public ArrayList<Element> getContent() {
        return content;
    }

    public void setContent(ArrayList<Element> content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println();
        System.out.println("Title: "+get_sectionTitle());

        //for(var element:content){
          //  element.print();
        //}
    }

    @Override
    public void Accept(BookStatistics bookStatistics) {
        for(Element element:content){
            element.Accept(bookStatistics);
        }
    }
    public void setNewValue (String newValue) {
    	this._oldValue = this._sectionTitle;
    	this._sectionTitle = newValue;
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
    	for(Observer obs : obsList) {
    		obs.update(this._oldValue,this._sectionTitle);
    	}
    }
    
}
