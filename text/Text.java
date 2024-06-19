package text;

import java.util.Scanner;

public class Text {
    private Scanner scanner = new Scanner(System.in);

    public String getText() {
        System.out.println("Enter the text you want to convert: ");
        return scanner.nextLine();
    }

    public void getChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Encrypting...");
                break;
            case 2:
                String text = getText();
                // Use the text for something, e.g., print it
                System.out.println("You entered: " + text);
                break;
            default:
                System.out.println("Invalid choice. Please enter 1 or 2.");
                break;
        }
    }
}
