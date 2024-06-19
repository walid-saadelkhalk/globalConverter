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
                encryptor.encryptAndConvert(inputText, shift);
            } else if (userChoice == 2) {
                System.out.println("Enter the text you want to convert: ");
                String inputText = text.getText();
                System.out.println("Choose the encoding: 1 for Hexadecimal, 2 for Binary, 3 for Octal, 4 for Decimal");
                int encodingChoice = inputScanner.nextInt();
                converter.convertAndPrint(inputText, encodingChoice);

                System.out.println("Do you want to revert the conversion? (yes/no)");
                inputScanner.nextLine(); // Consume newline left-over
                String revertChoice = inputScanner.nextLine();
                if (revertChoice.equalsIgnoreCase("yes")) {
                    reverter.revertAndPrint(inputText, encodingChoice);
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
