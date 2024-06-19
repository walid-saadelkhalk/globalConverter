package encrypt;

import java.util.Scanner;
import convert.ConvertTo;

public class Encrypt {
    private Scanner input = new Scanner(System.in);
    private ConvertTo converter = new ConvertTo();

    public int getShiftValue() {
        System.out.println("Enter the shift value for Caesar cipher: ");
        return input.nextInt();
    }

    public String encryptAndConvert(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + shift) % 26 + base);
            }
            encrypted.append(c);
        }
        String encryptedText = encrypted.toString();

        return encryptedText;
    }

    public String decryptAndConvert(String text, int shift) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base - shift + 26) % 26 + base); // Decryption formula
            }
            decrypted.append(c);
        }
        String decryptedText = decrypted.toString();

        return decryptedText;
    }
}
