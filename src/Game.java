import java.util.Scanner;

public class Game {

    public static String userInput() {
        System.out.println("Input a character:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static String searchCharacter(String randomLine, String userInput, String randomLineUnderscore) {
        char c = userInput.charAt(0);
        StringBuilder newLine = new StringBuilder(randomLineUnderscore);
        String newValue = "";
        for(int i = 0; i < randomLine.length();i++) {
            if(randomLine.charAt(i) == c) {
                newLine.setCharAt(i, c);
                newValue = newLine.toString();
            }
        }
        System.out.println(newValue);
        return newValue;
    }
}
