package text;

import java.util.Scanner;

public class Text {
    private Scanner scanner = new Scanner(System.in);


    public String getText() {
<<<<<<< HEAD
        String text;
        while (true) {
            
            text = scanner.nextLine();
            if (isValidText(text)) {
                break;
            } else {
                System.out.println("Invalid text. Enter the text you want to convert again : ");
            }
        }
        return text;
=======
        System.out.println("Enter the text you want to convert: ");
        return input.nextLine();
    }

    public boolean askForEncryption() {
        System.out.println("Do you want to encrypt the text before converting to hexadecimal? (yes/no): ");
        String response = input.nextLine();
        return response.equalsIgnoreCase("yes");
    }

    public int getShiftValue() {
        return input.nextInt();
>>>>>>> 60f6114 ([CREATED] created class Encrypt.java that encrypt our string input before convert it into hexa)
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
                        System.out.println("Choose the encoding: 16 for Hexadecimal, 2 for Binary, 8 for Octal, 10 for Decimal");
                        encodingChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline left-over
                        if (encodingChoice < 2 || encodingChoice > 16) {
                            System.out.println("Invalid choice. Please enter a number between 2, 8, 10 and 16.");
                        }
                    } while (encodingChoice < 2 || encodingChoice > 16);

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
