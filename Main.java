import convert.ConvertTo;
import encrypt.Encrypt;
import text.Text;

public class Main {

    public static void main(String[] args) {

        Text text = new Text();
        ConvertTo converter = new ConvertTo();
        Encrypt encryptor = new Encrypt();

        String inputText = text.getText();

        if (encryptor.askForEncryption()) {
            int shift = encryptor.getShiftValue();
            inputText = encryptor.encryptText(inputText, shift);
            System.out.println("Encrypted text: " + inputText);
        } else {
                // haxadecimal
        String hexResult = converter.toBase(inputText, 16);
        System.out.println("Hexadecimal: " + hexResult);
        }
        // binary
        String binaryResult = converter.toBase(inputText, 2);
        System.out.println("Binary: " + binaryResult);

        // octal
        String octalResult = converter.toBase(inputText, 8);
        System.out.println("Octal: " + octalResult);

        // decimal
        String decimalResult = converter.toBase(inputText, 10);
        System.out.println("Decimal: " + decimalResult);

        

    }
}
