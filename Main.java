import java.util.Scanner;
import text.Text;
import convert.ConvertTo;

public class Main {

    public static void main(String[] args) {
        Text text = new Text();
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter your choice (1 for Encrypt, 2 for Convert Text): ");
        int userChoice = inputScanner.nextInt();
        
        if (userChoice == 1) {
            text.getChoice(userChoice);
        } else if (userChoice == 2) {
            String inputText = text.getText();
            ConvertTo converter = new ConvertTo();
            System.out.println("Choose the encoding: 1 for Hexadecimal, 2 for Binary, 3 for Octal, 4 for Decimal");
            int encodingChoice = inputScanner.nextInt();
            converter.convertAndPrint(inputText, encodingChoice);
        } else {
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }

        inputScanner.close();
    }
}
