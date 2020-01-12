package Package1;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Image implements Element, Observable {
    private String _imageName;
    private String _oldValue;
    ArrayList<Observer> obsList = new ArrayList<Observer>();
    
    public String get_imageName() {
        return _imageName;
    }

    public void set_imageName(String _imageName) {
        this._imageName = _imageName;
    }

    public Image(String imageName){
        _imageName = imageName;
        this.obsList.add(DocumentManager.getInstance().getFirstObserver());
        
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception ex){
            System.out.println(ex);
        }

    }
    
    @Override
    public void print() {
        System.out.println("Image name: "+get_imageName());
    }

    @Override
    public void Accept(BookStatistics bookStatistics) {
        bookStatistics.Visit(this);
    }
    public void setNewValue(String newValue){
    	this._oldValue = _imageName;
    	this._imageName = newValue;
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
    	for(Observer ob : obsList) {
    		ob.update(this._oldValue, this._imageName);
    	}
    	
    }
    }

