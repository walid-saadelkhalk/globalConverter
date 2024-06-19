package convert;

public class ConvertTo {

<<<<<<< HEAD
    public String toHexadecimal(String input) {
        StringBuilder hexString = new StringBuilder();
=======
    public String toBase(String input, int base) {
        /*
         * StringBuilder is a mutable sequence of characters. 
         * It can modify the sequence of characters in the string without creating a new string.
         */
        StringBuilder baseString = new StringBuilder();
>>>>>>> dev
        for (char c : input.toCharArray()) {
            baseString.append(intToBase((int) c, base));
        }
        return baseString.toString();
    }

<<<<<<< HEAD
    private String intToHex(int num) {
        char[] hexChars = new char[2];
        for (int i = 1; i >= 0; i--) {
            int digit = num & 0xF;
=======
    // Convert an integer to a string 
    private String intToBase(int num, int base) {
        /*Check if the base is between 2 and 36
         * The base can't be less than 2 because we need at least two characters to represent a number.
         * The base can't be more than 36 because we only have 26 letters in the alphabet.
        */
        if (base < 2 || base > 36) {
            throw new IllegalArgumentException("Base must be between 2 and 36");
        }

        StringBuilder baseChars = new StringBuilder();
        while (num > 0) {
            int digit = num % base;
>>>>>>> dev
            if (digit < 10) {
                baseChars.append((char) ('0' + digit));
            } else {
                baseChars.append((char) ('A' + digit - 10));
            }
<<<<<<< HEAD
            num >>= 4;
=======
            num /= base;
>>>>>>> dev
        }

        // We add zero padding to make sure the result is at least 2 or 3 characters long
        while (baseChars.length() < (base == 16 ? 2 : 3)) {
            baseChars.append('0');
        }

        // Reverse the string to get the correct result
        return baseChars.reverse().toString();
    }

}
