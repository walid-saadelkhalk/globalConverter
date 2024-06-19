import convert.ConvertTo;

public class Main {

    public static void main (String[] args) {
        
        text.Text text = new text.Text();
        ConvertTo converter = new ConvertTo();

        String inputText = text.getText();


        // haxadecimal
        String hexResult = converter.toBase(inputText, 16);
        System.out.println("Hexadecimal: " + hexResult);

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