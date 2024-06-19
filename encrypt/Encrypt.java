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

        // Ask if the user wants to convert the encrypted text
        System.out.println("Do you want to convert the encrypted text to a different base? (yes/no): ");
        input.nextLine(); // Consume newline left-over
        String convertResponse = input.nextLine();
        if (convertResponse.equalsIgnoreCase("yes")) {
            int encodingChoice;
            do {
                System.out.println("Choose the encoding: 1 for Hexadecimal, 2 for Binary, 3 for Octal, 4 for Decimal");
                encodingChoice = input.nextInt();
                input.nextLine(); // Consume newline left-over
                if (encodingChoice < 1 || encodingChoice > 4) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } while (encodingChoice < 1 || encodingChoice > 4);

            String convertedText = converter.convertAndPrint(encryptedText, encodingChoice);
            return convertedText;
        } else {
            System.out.println("Not converting the encrypted text.");
            System.out.println("Encrypted text: " + encryptedText);
            return encryptedText;
        }
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

        // Ask if the user wants to convert the decrypted text
        System.out.println("Do you want to convert the decrypted text to a different base? (yes/no): ");
        input.nextLine(); // Consume newline left-over
        String convertResponse = input.nextLine();
        if (convertResponse.equalsIgnoreCase("yes")) {
            int encodingChoice;
            do {
                System.out.println("Choose the encoding: 1 for Hexadecimal, 2 for Binary, 3 for Octal, 4 for Decimal");
                encodingChoice = input.nextInt();
                input.nextLine(); // Consume newline left-over
                if (encodingChoice < 1 || encodingChoice > 4) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } while (encodingChoice < 1 || encodingChoice > 4);

            String convertedText = converter.convertAndPrint(decryptedText, encodingChoice);
            return convertedText;
        } else {
            System.out.println("Not converting the decrypted text.");
            System.out.println("Decrypted text: " + decryptedText);
            return decryptedText;
        }
    }
}
