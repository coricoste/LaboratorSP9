package Package1;

public class AlignRight implements AlignStrategy {

    @Override
    public void Print(String text) {
        System.out.println("+++++"+text);
    }
}
