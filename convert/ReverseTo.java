package convert;

public class ReverseTo {

    public String fromBase(String input, int base) {
        StringBuilder result = new StringBuilder();
        int length = (base == 2) ? 8 : ((base == 16) ? 2 : 3);
        for (int i = 0; i < input.length(); i += length) {
            String part = input.substring(i, Math.min(i + length, input.length()));
            result.append((char) baseToInt(part, base));
        }
        return result.toString();
    }

    private int baseToInt(String input, int base) {
        int num = 0;
        for (char c : input.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = num * base + (c - '0');
            } else if (c >= 'A' && c <= 'Z') {
                num = num * base + (c - 'A' + 10);
            } else if (c >= 'a' && c <= 'z') {
                num = num * base + (c - 'a' + 10);
            } else {
                throw new IllegalArgumentException("Invalid character in input: " + c);
            }
        }
        return num;
    }

    public void revertAndPrint(String inputText, int choice) {
        switch (choice) {
            case 1:
                System.out.println("Original Text from Hexadecimal: " + fromBase(inputText, 16));
                break;
            case 2:
                System.out.println("Original Text from Binary: " + fromBase(inputText, 2));
                break;
            case 3:
                System.out.println("Original Text from Octal: " + fromBase(inputText, 8));
                break;
            case 4:
                System.out.println("Original Text from Decimal: " + fromBase(inputText, 10));
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                break;
        }
    }
}
