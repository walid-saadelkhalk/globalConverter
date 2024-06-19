import java.util.Scanner;
import text.Text;
import convert.ConvertTo;
import convert.ReverseTo;
import encrypt.Encrypt;

public class Main {

    public static void main(String[] args) {
        Encrypt encryptor = new Encrypt();
        Text text = new Text(encryptor);
        ConvertTo converter = new ConvertTo();
        ReverseTo reverter = new ReverseTo();
        Scanner inputScanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your choice (1 for Encrypt, 2 for Convert Text, 3 to Quit): ");
            int userChoice = inputScanner.nextInt();
            inputScanner.nextLine();  // Consume newline left-over

            if (userChoice == 1) {
                System.out.println("Enter the text you want to encrypt: ");
                String inputText = text.getText();
                int shift = encryptor.getShiftValue();
                String encryptedText = encryptor.encryptAndConvert(inputText, shift);
                System.out.println("Encrypted and Converted text: " + encryptedText);

                // Ask if user wants to convert the encrypted text
                System.out.println("Do you want to convert the encrypted text to a different base? (yes/no): ");
                String convertResponse = inputScanner.nextLine();
                if (convertResponse.equalsIgnoreCase("yes")) {
                    System.out.println("Choose the encoding: 1 for Hexadecimal, 2 for Binary, 3 for Octal, 4 for Decimal");
                    int encodingChoice = inputScanner.nextInt();
                    inputScanner.nextLine(); // Consume newline left-over
                    String convertedText = converter.convertAndPrint(encryptedText, encodingChoice);
                    System.out.println("Converted text in base " + encodingChoice + ": " + convertedText);

                    // Ask if user wants to revert the conversion
                    System.out.println("Do you want to revert the conversion? (yes/no)");
                    String revertChoice = inputScanner.nextLine();
                    if (revertChoice.equalsIgnoreCase("yes")) {
                        String revertedText = reverter.revert(encryptedText, encodingChoice);
                        System.out.println("Original Text: " + revertedText);
                    } else {
                        System.out.println("Not reverting the conversion.");
                    }
                }

            } else if (userChoice == 2) {
                System.out.println("Enter the text you want to convert: ");
                String inputText = text.getText();
                System.out.println("Choose the encoding: 1 for Hexadecimal, 2 for Binary, 3 for Octal, 4 for Decimal");
                int encodingChoice = inputScanner.nextInt();
                inputScanner.nextLine(); // Consume newline left-over
                String convertedText = converter.convertAndPrint(inputText, encodingChoice);

                // Ask if user wants to revert the conversion
                System.out.println("Do you want to revert the conversion? (yes/no)");
                String revertChoice = inputScanner.nextLine();
                if (revertChoice.equalsIgnoreCase("yes")) {
                    String revertedText = reverter.revert(convertedText, encodingChoice);
                    System.out.println("Original Text: " + revertedText);
                } else {
                    System.out.println("Not reverting the conversion.");
                }

            } else if (userChoice == 3) {
                System.out.println("Quitting...");
                break;

            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }

        inputScanner.close();
    }
}
