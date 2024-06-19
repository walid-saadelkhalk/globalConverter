import java.util.Scanner;
import text.Text;
import convert.ConvertTo;
import convert.ReverseTo;
import encrypt.Encrypt;

public class App {
    private Encrypt encryptor;
    private Text text;
    private ConvertTo converter;
    private ReverseTo reverter;
    private Scanner inputScanner;

    public App() {
        this.encryptor = new Encrypt();
        this.text = new Text(encryptor);
        this.converter = new ConvertTo();
        this.reverter = new ReverseTo();
        this.inputScanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\nWhat do you want to do?\n1 for Encrypt \n2 for Convert Text \n3 to Quit");
            int userChoice = getUserChoice(3);

            System.out.println("You chose: " + userChoice + "\n");

            if (userChoice == 1) {
                handleEncryption();
            } else if (userChoice == 2) {
                handleConversion();
            } else if (userChoice == 3) {
                System.out.println("Quitting...");
                break;
            }
        }

        inputScanner.close();
    }

    private void handleEncryption() {
        System.out.println("Enter the text you want to encrypt: ");
        String inputText = text.getText();
        int shift = encryptor.getShiftValue();
        String encryptedText = encryptor.encryptAndConvert(inputText, shift);
        System.out.println("Encrypted and Converted text: " + encryptedText);

        if (askYesNo("\nDo you want to convert the encrypted text to a different base? (yes/no): ")) {
            int encodingChoice = getEncodingChoice();
            String convertedText = converter.convertAndPrint(encryptedText, encodingChoice);

            if (askYesNo("\nDo you want to revert the conversion? (yes/no)")) {
                String revertedText = reverter.revert(convertedText, encodingChoice);
                System.out.println("Original Text: " + revertedText);

                if (askYesNo("\nDo you want to decrypt the original text? (yes/no)")) {
                    String decryptedText = encryptor.decryptAndConvert(revertedText, shift);
                    System.out.println("Decrypted text: " + decryptedText);
                } else {
                    System.out.println("Not decrypting the original text.");
                }
            } else {
                System.out.println("Not reverting the conversion.");
            }
        } else {
            System.out.println("Not converting the encrypted text.");
        }
    }

    private void handleConversion() {
        System.out.println("Enter the text you want to convert: ");
        String inputText = text.getText();
        int encodingChoice = getEncodingChoice();
        String convertedText = converter.convertAndPrint(inputText, encodingChoice);

        if (askYesNo("\nDo you want to revert the conversion? (yes/no)")) {
            String revertedText = reverter.revert(convertedText, encodingChoice);
            System.out.println("Original Text: " + revertedText);
        } else {
            System.out.println("Not reverting the conversion.");
        }
    }

    private int getUserChoice(int maxChoice) {
        int choice = -1;
        while (true) {
            try {
                choice = inputScanner.nextInt();
                inputScanner.nextLine(); // Consume newline left-over
                if (choice > 0 && choice <= maxChoice) {
                    return choice;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and " + maxChoice + ".");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and " + maxChoice + ".");
                inputScanner.next(); // Consume the invalid input
            }
        }
    }

    private int getEncodingChoice() {
        int encodingChoice = -1;
        while (true) {
            System.out.println("\nChoose the encoding: \n1 for Hexadecimal \n2 for Binary \n3 for Octal \n4 for Decimal");
            encodingChoice = getUserChoice(4);
            if (encodingChoice > 0 && encodingChoice <= 4) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
        return encodingChoice;
    }

    private boolean askYesNo(String question) {
        System.out.println(question);
        while (true) {
            String choice = inputScanner.nextLine().trim().toLowerCase();
            if (choice.equals("yes") || choice.equals("y")) {
                return true;
            } else if (choice.equals("no") || choice.equals("n")) {
                return false;
            } else {
                System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
            }
        }
    }
}
