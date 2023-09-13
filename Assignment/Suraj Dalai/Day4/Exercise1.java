package Day4;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input text, length, and character
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();
        System.out.print("Enter the length: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter the character: ");
        char paddingChar = scanner.nextLine().charAt(0);

        // Stretch the text
        String stretchedText = stretchString(text, length, paddingChar);

        // Display the stretched text
        System.out.println(stretchedText);

        scanner.close();
    }

    // Function to stretch the string with padding characters
    public static String stretchString(String text, int length, char paddingChar) {
        if (text.length() >= length) {
            return text; // No need to stretch if the text is longer or equal to the desired length
        }

        int paddingLength = length - text.length();
        int leftPaddingLength = paddingLength / 2;
        int rightPaddingLength = paddingLength - leftPaddingLength;

        // Padding on the left side
        String leftPadding = repeatCharacter(paddingChar, leftPaddingLength);

        // Padding on the right side
        String rightPadding = repeatCharacter(paddingChar, rightPaddingLength);

        // Combine the paddings and the original text
        return leftPadding + text + rightPadding;
    }

    // Function to repeat a character n times
    public static String repeatCharacter(char c, int n) {
        String repeatedCharacter = "";
        for (int i = 0; i < n; i++) {
            repeatedCharacter += c;
        }
        return repeatedCharacter;
    }
}
