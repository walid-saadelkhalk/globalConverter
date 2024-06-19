package text;

import java.util.Scanner;

public class Text {
    private Scanner scanner = new Scanner(System.in);


    public String getText() {
        String text;
        while (true) {
            System.out.println("Enter the text you want to convert: ");
            text = scanner.nextLine();
            if (isValidText(text)) {
                break;
            } else {
                System.out.println("Invalid text. Enter the text you want to convert again : ");
            }
        }
        return text;
    }

    public void getChoice(int choice) {
        String text = getText();
        System.out.println("You entered: " + text);
    }


    private boolean isValidText(String text) {
        return text.matches("[a-zA-Z0-9]+");
    }
}
