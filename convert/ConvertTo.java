package convert;

public class ConvertTo {

    public String toBase(String input, int base) {
        StringBuilder baseString = new StringBuilder();
        for (char c : input.toCharArray()) {
            baseString.append(intToBase((int) c, base));
        }
        return baseString.toString();
    }

    private String intToBase(int num, int base) {
        /*
         * Check if the base is between 2 and 36.
         * The base can't be less than 2 becasue we need at least two characters to represent a number.
         * The base can't be more than 36 because we only have 26 letters in the alphabet.
        */
        if (base < 2 || base > 36) {
            throw new IllegalArgumentException("Base must be between 2 and 36");
        }

        StringBuilder baseChars = new StringBuilder();
        while (num > 0) {
            int digit = num % base;
            if (digit < 10) {
                baseChars.append((char) ('0' + digit));
            } else {
                baseChars.append((char) ('A' + digit - 10));
            }
            num /= base;
        }

        while (baseChars.length() < (base == 16 ? 2 : 3)) {
            baseChars.append('0');
        }

        return baseChars.reverse().toString();
    }

    public String convertAndPrint(String inputText, int choice) {
        String result = "";
        switch (choice) {
            case 1:
                result = toBase(inputText, 16);
                System.out.println("Hexadecimal: " + result);
                break;
            case 2:
                result = toBase(inputText, 2);
                System.out.println("Binary: " + result);
                break;
            case 3:
                result = toBase(inputText, 8);
                System.out.println("Octal: " + result);
                break;
            case 4:
                result = toBase(inputText, 10);
                System.out.println("Decimal: " + result);
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 2, 8, 10, 16.");
                break;
        }
        return result;
    }
}
