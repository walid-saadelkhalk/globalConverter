package text;

import java.util.Scanner;
import encrypt.Encrypt;

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
        // Autoriser les lettres, chiffres, espaces, points, virgules et apostrophes
        return text.matches("[a-zA-Z0-9 ,.']+");
    }
}
