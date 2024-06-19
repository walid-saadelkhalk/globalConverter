package convert;

public class ConvertTo {

    public String toHexadecimal(String input) {
        StringBuilder hexString = new StringBuilder();
        for (char c : input.toCharArray()) {
            baseString.append(intToBase((int) c, base));
        }
        return baseString.toString();
    }

    private String intToHex(int num) {
        char[] hexChars = new char[2];
        for (int i = 1; i >= 0; i--) {
            int digit = num & 0xF;
            if (digit < 10) {
                baseChars.append((char) ('0' + digit));
            } else {
                baseChars.append((char) ('A' + digit - 10));
            }
            num >>= 4;
        }

        while (baseChars.length() < (base == 16 ? 2 : 3)) {
            baseChars.append('0');
        }

        return baseChars.reverse().toString();
    }

    public void convertAndPrint(String inputText, int choice) {
        switch (choice) {
            case 16:
                System.out.println("Hexadecimal: " + toBase(inputText, 16));
                break;
            case 2:
                System.out.println("Binary: " + toBase(inputText, 2));
                break;
            case 8:
                System.out.println("Octal: " + toBase(inputText, 8));
                break;
            case 10:
                System.out.println("Decimal: " + toBase(inputText, 10));
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 2, 8, 10, 16.");
                break;
        }
    }
}
