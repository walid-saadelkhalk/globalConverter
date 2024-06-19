import convert.ConvertTo;
import encrypt.Encrypt;
import text.Text;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Text text = new Text();
        ConvertTo converter = new ConvertTo();
        Encrypt encryptor = new Encrypt();
        Scanner input = new Scanner(System.in);

        String inputText = text.getText();

        if (encryptor.askForEncryption()) {
            int shift = encryptor.getShiftValue();
            inputText = encryptor.encryptText(inputText, shift);
            System.out.println("Encrypted text: " + inputText);
        }

        System.out.println("Enter the base for conversion (2 for binary, 8 for octal, 10 for decimal, 16 for hexadecimal): ");
        int base = input.nextInt();

        String baseResult = converter.toBase(inputText, base);

        System.out.println("Converted text in base " + base + ": " + baseResult);
    }
}
