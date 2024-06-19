import java.util.Scanner;
import text.Text;
import convert.ConvertTo;
import encrypt.Encrypt;

public class Main {

    public static void main(String[] args) {
        Encrypt encryptor = new Encrypt();
        Text text = new Text(encryptor);
        ConvertTo converter = new ConvertTo();
        Scanner inputScanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your choice (1 for Encrypt, 2 for Convert Text, 3 to Quit): ");
            int userChoice = inputScanner.nextInt();
            inputScanner.nextLine();  // Consume newline left-over

            if (userChoice == 1) {
                text.getChoice(userChoice);
            } else if (userChoice == 2) {
                System.out.println("Enter the text you want to convert: ");
                String inputText = text.getText();
                System.out.println("Choose the encoding: 16 for Hexadecimal, 2 for Binary, 8 for Octal, 10 for Decimal");
                int encodingChoice = inputScanner.nextInt();
                String baseResult = converter.toBase(inputText, encodingChoice);
                System.out.println("Converted text in base " + encodingChoice + ": " + baseResult);
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
