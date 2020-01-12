package Package1;

public class MainClass {

    public static void main(String[] args) {

    	Section cap1 = new Section("Capitol1");
    	Paragraph p1 = new Paragraph("Paragraph1");
    	cap1.AddElement(p1);
    	Paragraph p2 = new Paragraph("Paragraph2");
    	cap1.AddElement(p2);
    	Paragraph p3 = new Paragraph("Paragraph3");
    	cap1.AddElement(p3);
    	Paragraph p4 = new Paragraph("Paragraph4");
    	cap1.AddElement(p4);
    	cap1.AddElement(new ImageProxy("ImageOne"));
    	cap1.AddElement(new Image("ImageTwo"));
    	cap1.AddElement(new Paragraph("text text text"));
    	cap1.AddElement(new Table("Table 1"));
    	FirstObserver firstObserver = new FirstObserver();
    	SecondObserver secondObserver = new SecondObserver();
    	cap1.addObserver(firstObserver);
    	cap1.addObserver(secondObserver);
    	p1.addObserver(firstObserver);
    	p1.addObserver(secondObserver);
    	p2.addObserver(firstObserver);
    	cap1.setNewValue("CHAPTER1");
    	p1.setNewValue("PARAGRAPH2");
    	p2.setNewValue("PARAGRAPH3");
//    	cap1.removeObserver(firstObserver);
    	cap1.setNewValue("CHAPTER1.1");
    }

}
