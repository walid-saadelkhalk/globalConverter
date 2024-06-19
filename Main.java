import java.util.Scanner;
import text.Text;
import convert.ConvertTo;
import convert.ReverseTo;

public class Main {

    public static void main(String[] args) {
        Text text = new Text();
        ConvertTo converter = new ConvertTo();
        ReverseTo reverter = new ReverseTo();
        Scanner inputScanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your choice (1 for Encrypt, 2 for Convert Text, 3 to Quit): ");
            int userChoice = inputScanner.nextInt();

            if (userChoice == 1) {
                text.getChoice(userChoice);
            } else if (userChoice == 2) {
                String inputText = text.getText();
                System.out.println("Choose the encoding: 1 for Hexadecimal, 2 for Binary, 3 for Octal, 4 for Decimal");
                int encodingChoice = inputScanner.nextInt();
                String convertedText = converter.convertAndPrint(inputText, encodingChoice);

                System.out.println("Do you want to revert the conversion? (yes/no)");
                String revertChoice = inputScanner.next();
                if (revertChoice.equalsIgnoreCase("yes")) {
                    reverter.revertAndPrint(convertedText, encodingChoice);
                } else {
                    System.out.println("Not reverting the conversion.");
                }
            } else if (userChoice == 3) {
                System.out.println("Quitting...");
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                inputScanner.nextLine();
            }
        }

        inputScanner.close();
    }
}
