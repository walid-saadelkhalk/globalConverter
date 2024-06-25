/*
 * This file is the entry point of the program.
 * It creates an instance of the App class and runs the program.
 * The App class provides the user with options to encrypt, convert text, and quit the application.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("\nWELCOME TO ASCII FOR NOOB!");
        System.out.println("You can learn about ASCII by converting text to different bases, encrypting text, and reversing the conversion.");
        App app = new App();
        app.run();
    }
}
