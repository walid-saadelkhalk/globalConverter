package text;

import java.util.Scanner;
import encrypt.Encrypt;

public class Text {
    private Scanner scanner = new Scanner(System.in);
    private Encrypt encryptor;

    public Text(Encrypt encryptor) {
        this.encryptor = encryptor;
    }

    public String getText() {
        return scanner.nextLine();
    }
}
