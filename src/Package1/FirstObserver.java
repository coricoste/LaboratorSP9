package Package1;

public class FirstObserver implements Observer {
	public FirstObserver() {}
	
	public void update(String oldValue, String newValue) {
		System.out.println("Old value: " + oldValue + " was updated to: " + newValue);
	}

}
