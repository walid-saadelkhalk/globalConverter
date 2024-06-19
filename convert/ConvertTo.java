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
        return new String(hexChars);
    }
}
