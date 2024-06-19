package text;

import java.util.Scanner;

public class Text {
    private Scanner scanner = new Scanner(System.in);

    public String getText() {
        System.out.println("Enter the text you want to convert: ");
        return scanner.nextLine();
    }

    public void getChoice(int choice) {
        String text = getText();
        System.out.println("You entered: " + text);
    }
}
