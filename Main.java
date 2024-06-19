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
            String hexResult = converter.toHexadecimal(inputText);
            System.out.println("Hexadecimal: " + hexResult);
        }
    }
}
