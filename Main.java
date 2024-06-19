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
            System.out.println("\nWhat do you want to do?\n1 for Encrypt \n2 for Convert Text \n3 to Quit");
            int userChoice = getUserChoice(inputScanner, 3);

            System.out.println("You chose: " + userChoice + "\n");

            if (userChoice == 1) {
                System.out.println("Enter the text you want to encrypt: ");
                String inputText = text.getText();
                int shift = encryptor.getShiftValue();
                String encryptedText = encryptor.encryptAndConvert(inputText, shift);
                System.out.println("Encrypted and Converted text: " + encryptedText);

                System.out.println("\nDo you want to convert the encrypted text to a different base? (yes/no): ");
                String convertResponse = inputScanner.nextLine();
                if (convertResponse.equalsIgnoreCase("yes")) {
                    boolean validEncodingChoice = false;
                    while (!validEncodingChoice) {
                        System.out.println("\nChoose the encoding: \n1 for Hexadecimal \n2 for Binary \n3 for Octal \n4 for Decimal");
                        int encodingChoice = getUserChoice(inputScanner, 4);
                        String convertedText = converter.convertAndPrint(encryptedText, encodingChoice);

                        if (convertedText != null && !convertedText.isEmpty()) {
                            validEncodingChoice = true;

                            System.out.println("\nDo you want to revert the conversion? (yes/no)");
                            String revertChoice = inputScanner.nextLine();
                            if (revertChoice.equalsIgnoreCase("yes")) {
                                String revertedText = reverter.revert(convertedText, encodingChoice);
                                System.out.println("Original Text: " + revertedText);

                                System.out.println("\nDo you want to decrypt the original text? (yes/no)");
                                String decryptChoice = inputScanner.nextLine();
                                if (decryptChoice.equalsIgnoreCase("yes")) {
                                    String decryptedText = encryptor.decryptAndConvert(revertedText, shift);
                                    System.out.println("Decrypted text: " + decryptedText);
                                } else {
                                    System.out.println("Not decrypting the original text.");
                                }
                            } else {
                                System.out.println("Not reverting the conversion.");
                            }
                        }
                    }
                } else {
                    System.out.println("Not converting the encrypted text.");
                }

            } else if (userChoice == 2) {
                System.out.println("Enter the text you want to convert: ");
                String inputText = text.getText();
                boolean validEncodingChoice = false;

                while (!validEncodingChoice) {
                    System.out.println("\nChoose the encoding: \n1 for Hexadecimal \n2 for Binary \n3 for Octal \n4 for Decimal");
                    int encodingChoice = getUserChoice(inputScanner, 4);
                    String convertedText = converter.convertAndPrint(inputText, encodingChoice);

                    if (convertedText != null && !convertedText.isEmpty()) {
                        validEncodingChoice = true;

                        System.out.println("\nDo you want to revert the conversion? (yes/no)");
                        String revertChoice = inputScanner.nextLine();
                        if (revertChoice.equalsIgnoreCase("yes")) {
                            String revertedText = reverter.revert(convertedText, encodingChoice);
                            System.out.println("Original Text: " + revertedText);
                        } else {
                            System.out.println("Not reverting the conversion.");
                        }
                    }
                }

            } else if (userChoice == 3) {
                System.out.println("Quitting...");
                break;
            }
        }

        inputScanner.close();
    }

    private static int getUserChoice(Scanner inputScanner, int maxChoice) {
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
}
