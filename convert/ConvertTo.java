package convert;


public class ConvertTo {
    
    public String toHexadecimal(String input) {

        /* StringBuilder is a mutable sequence of characters. 
        Better than String for concatenation.
        Modify the object without creating a new one.
        */

        StringBuilder hexString = new StringBuilder();
        for (char c : input.toCharArray()) {
            hexString.append(intToHex((int) c));
        }
        return hexString.toString();
    }
    
    private String intToHex(int num) {
        char[] hexChars = new char[2];
        for (int i = 1; i >= 0; i--) {
            int digit = num & 0xF;  
            if (digit < 10) {
                hexChars[i] = (char) ('0' + digit);
            } else {
                hexChars[i] = (char) ('A' + digit - 10);
            }
            num >>= 4; 
        }
        return new String(hexChars);
    }
}
