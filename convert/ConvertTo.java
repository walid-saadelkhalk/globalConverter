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
         * The base can't be less than 2 because we need at least two characters to represent a number.
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

        // Add zero padding to make sure the result is at least 8 characters long for binary
        int requiredLength = (base == 2) ? 8 : (base == 16 ? 2 : 3);
        while (baseChars.length() < requiredLength) {
            baseChars.append('0');
        }

        return baseChars.reverse().toString();
    }

    public String convertAndPrint(String inputText, int choice) {
        String result = "";
        switch (choice) {
            case 1:
                result = toBase(inputText, 16);
                System.out.println("\nHexadecimal: " + result);
                break;
            case 2:
                result = toBase(inputText, 2);
                System.out.println("\n" + inputText + " in binary is : " + result);
                break;
            case 3:
                result = toBase(inputText, 8);
                System.out.println("\nOctal: " + result);
                break;
            case 4:
                result = toBase(inputText, 10);
                System.out.println("\nDecimal: " + result);
                break;
            default:
                result = null;
                System.out.println("\nInvalid choice. Please enter a number between 1, 2, 3, 4.");
                break;
        }
        return result;
    }
}
