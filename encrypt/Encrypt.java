package encrypt;

import java.util.Scanner;

public class Encrypt {
    private Scanner input = new Scanner(System.in);

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
            // Laisser les caractères spéciaux inchangés
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
            // Laisser les caractères spéciaux inchangés
            decrypted.append(c);
        }
        return decrypted.toString();
    }
}
