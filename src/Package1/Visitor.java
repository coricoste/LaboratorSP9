package Package1;

public interface Visitor {
    void Visit(Image image);
    void Visit(ImageProxy imageProxy);
    void Visit(Paragraph paragraph);
    void Visit(Table table);
}
