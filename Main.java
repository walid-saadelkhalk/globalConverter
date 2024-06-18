import convert.ConvertTo;

public class Main {

    public static void main (String[] args) {
        
        text.Text text = new text.Text();
        ConvertTo converter = new ConvertTo();

        String inputText = text.getText();

        String hexResult = converter.toHexadecimal(inputText);

        System.out.println("Hexadecimal: " + hexResult);

    }
}