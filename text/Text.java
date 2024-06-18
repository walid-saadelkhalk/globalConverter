package text;

public class Text {
    java.util.Scanner input = new java.util.Scanner(System.in);

    public String getText() {
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
    }
}
