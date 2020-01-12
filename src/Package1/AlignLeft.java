package Package1;

public class AlignLeft implements AlignStrategy {
    @Override
    public void Print(String text) {
        System.out.println(text+"+++++");
    }
}
