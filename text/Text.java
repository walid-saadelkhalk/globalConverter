package text;

public class Text {
    java.util.Scanner input = new java.util.Scanner(System.in);

    public String getText() {
        System.out.println("Enter the text you want to convert: ");
        return input.nextLine();
    }
}
