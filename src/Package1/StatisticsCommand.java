package Package1;

public class StatisticsCommand implements Command {

	public void execute() {
		Book myBook = DocumentManager.getInstance().getBook();
		BookStatistics stats = new BookStatistics();
		for(Element x : myBook.get_content())
		{
			if(x instanceof Section)
				x.Accept(stats);
		}
		stats.PrintStatistics();
	}
}
