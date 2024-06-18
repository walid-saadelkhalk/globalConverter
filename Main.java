import convert.ConvertTo;
import encrypt.Encrypt;

public class Main {

    public static void main(String[] args) {

        text.Text text = new text.Text();
        ConvertTo converter = new ConvertTo();
        Encrypt encryptor = new Encrypt();

        String inputText = text.getText();

        if (text.askForEncryption()) {
            System.out.println("Enter the shift value for Caesar cipher: ");
            int shift = text.getShiftValue();
            inputText = encryptor.encryptText(inputText, shift);
        }

        String hexResult = converter.toHexadecimal(inputText);

        System.out.println("Hexadecimal: " + hexResult);
    }
}
