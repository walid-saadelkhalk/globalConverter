package encrypt;

import java.util.Scanner;

public class Encrypt {
    private Scanner input = new Scanner(System.in);

    public int getShiftValue() {
        return input.nextInt();
    }

    public String encryptText(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + shift) % 26 + base);
            }
            encrypted.append(c);
        }
        return encrypted.toString();
    }
}
