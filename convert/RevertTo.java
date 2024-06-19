package convert;

public class RevertTo {

    public String fromHexadecimal(String input) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i += 2) {
            String str = input.substring(i, i + 2);
            int decimal = hexToInt(str);
            output.append((char) decimal);
        }

        return output.toString();
    }

    public String fromOctal(String input) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i += 3) {
            String str = input.substring(i, i + 3);
            int decimal = octalToInt(str);
            output.append((char) decimal);
        }

        return output.toString();
    }

    public String fromBinary(String input) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i += 8) {
            String str = input.substring(i, i + 8);
            int decimal = binaryToInt(str);
            output.append((char) decimal);
        }

        return output.toString();
    }

    private int hexToInt(String hex) {
        int decimal = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            int hexValue;
            if (hexChar >= '0' && hexChar <= '9') {
                hexValue = hexChar - '0';
            } else if (hexChar >= 'A' && hexChar <= 'F') {
                hexValue = hexChar - 'A' + 10;
            } else {
                hexValue = hexChar - 'a' + 10;
            }
            decimal = decimal * 16 + hexValue;
        }
        return decimal;
    }

    private int octalToInt(String octal) {
        int decimal = 0;
        for (int i = 0; i < octal.length(); i++) {
            char octalChar = octal.charAt(i);
            int octalValue = octalChar - '0';
            decimal = decimal * 8 + octalValue;
        }
        return decimal;
    }

    private int binaryToInt(String binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            char binaryChar = binary.charAt(i);
            int binaryValue = binaryChar - '0';
            decimal = decimal * 2 + binaryValue;
        }
        return decimal;
    }
}

