package Package1;

import java.util.ArrayList;

public class Table implements Element,Observable {

    private String _tableName;
    private String _oldValue;
    private ArrayList<Observer> obsList = new ArrayList<Observer>();
    public String get_tableName() {
        return _tableName;
    }

    public void set_tableName(String _tableName) {
        this._tableName = _tableName;
    }

    public Table(String tableName){
        _tableName = tableName;
        obsList.add(DocumentManager.getInstance().getFirstObserver());
    }

    @Override
    public void print() {
        System.out.println("Table name: "+get_tableName());
    }

    @Override
    public void Accept(BookStatistics bookStatistics) {
        bookStatistics.Visit(this);
    }
    public void setNewValue (String newValue) {
    	this._oldValue = this._tableName;
    	this._tableName = newValue;
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
    		obs.update(this._oldValue,this._tableName);
    	}
    }
    
}
