package Package1;

public class OpenCommand implements Command{
	public String filepath;
	public OpenCommand (String path) {
		filepath = path;
	}
	public void execute() {
		Builder jsonBuilder = new JSONBuilder(filepath);
		jsonBuilder.Build();
		Element myBook = jsonBuilder.GetResult();
		DocumentManager.getInstance().getBook().AddContent(myBook);
	}
	
}
