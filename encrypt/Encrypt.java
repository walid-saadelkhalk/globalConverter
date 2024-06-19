package encrypt;

import java.util.Scanner;

public class Encrypt {
    private Scanner input = new Scanner(System.in);

    public boolean askForEncryption() {
        System.out.println("Do you want to encrypt the text before converting to hexadecimal? (yes/no): ");
        String response = input.nextLine();
        return response.equalsIgnoreCase("yes");
    }

    public int getShiftValue() {
        System.out.println("Enter the shift value: ");
        return input.nextInt();
    }

    public String encryptText(String text, int shift) {
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
