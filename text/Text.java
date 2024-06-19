package text;

public class Text {
    java.util.Scanner input = new java.util.Scanner(System.in);

    
    public String getText() {
        String text;
        while (true) {
            System.out.println("Enter the text you want to convert: ");
            text = input.nextLine();
            if (isValidText(text)) {
                break;
            } else {
                System.out.println("Invalid text. Enter the text you want to convert again : ");
            }
        }
        return text;
    }

    private boolean isValidText(String text) {
        return text.matches("[a-zA-Z0-9]+");
    }
}
