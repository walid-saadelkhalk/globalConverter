package encrypt;

import java.util.Scanner;
import convert.ConvertTo;

public class Encrypt {
    private Scanner input = new Scanner(System.in);
    private ConvertTo converter = new ConvertTo();

    public int getShiftValue() {
        int shift = -1;
        while (true) {
            try {
                System.out.println("\nEnter the shift value for Caesar cipher: ");
                shift = input.nextInt();
                input.nextLine(); // Consume newline left-over
                return shift;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer value for the shift.");
                input.next(); // Consume the invalid input
            }
        }
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
        return encrypted.toString();
    }

    public String decryptAndConvert(String text, int shift) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base - shift + 26) % 26 + base);
            }
            decrypted.append(c);
        }
        return decrypted.toString();
    }
}
