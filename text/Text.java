package text;

import java.util.Scanner;
import encrypt.Encrypt;


/*
 * Text class is responsible for getting the text input from the user.
 * It validates the input text and returns it to the caller.
 * The input text should contain only alphabets, digits, spaces, and some special characters.
 */
public class Text {
    private Scanner inputScanner;
    private Encrypt encryptor;

    public Text(Encrypt encryptor) {
        this.inputScanner = new Scanner(System.in);
        this.encryptor = encryptor;
    }

    public String getText() {
        while (true) {
            String inputText = inputScanner.nextLine();
            if (isValidText(inputText)) {
                return inputText;
            } else {
                System.out.println("Invalid text. Enter the text you want to convert again: ");
            }
        }
    }

    private boolean isValidText(String text) {
        return text.matches("[a-zA-Z0-9 ,.']+");
    }
}
