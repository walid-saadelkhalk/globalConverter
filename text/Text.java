package text;

import java.util.Scanner;
import encrypt.Encrypt;
import convert.ConvertTo;

public class Text {
    private Scanner scanner = new Scanner(System.in);
    private Encrypt encryptor;

    public Text(Encrypt encryptor) {
        this.encryptor = encryptor;
    }

    public String getText() {
        return scanner.nextLine();
    }

    public void getChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Enter the text you want to encrypt: ");
                String inputText = getText();
                System.out.println("Enter the shift value for Caesar cipher: ");
                int shift = encryptor.getShiftValue();
                String encryptedText = encryptor.encryptText(inputText, shift);
                System.out.println("Encrypted text: " + encryptedText);
                
                // Ask if the user wants to convert the encrypted text
                System.out.println("Do you want to convert the encrypted text to a different base? (yes/no): ");
                String convertResponse = scanner.nextLine();
                if (convertResponse.equalsIgnoreCase("yes")) {
                    int encodingChoice;
                    do {
                        System.out.println("Choose the encoding: 1 for Hexadecimal, 2 for Binary, 3 for Octal, 4 for Decimal");
                        encodingChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline left-over
                        if (encodingChoice < 1 || encodingChoice > 4) {
                            System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                        }
                    } while (encodingChoice < 1 || encodingChoice > 4);

                    ConvertTo converter = new ConvertTo();
                    String baseResult = converter.toBase(encryptedText, encodingChoice);
                    System.out.println("Converted text in base " + encodingChoice + ": " + baseResult);
                }
                break;
            default:
                System.out.println("Invalid choice for encryption. Please enter 1.");
                break;
        }
    }
}
