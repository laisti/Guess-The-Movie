import java.util.Scanner;
import java.util.ArrayList;

public class Game {


    public static String userInput() {
        System.out.println("Input a character:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    static ArrayList<String> inputList = new ArrayList<String>();
    public static ArrayList addUserInput(String userInput) {
        if (!inputList.contains(userInput)) {
            inputList.add(userInput);
        }
        return inputList;
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
            else {
                newValue = newLine.toString();
            }
        }
        System.out.println(newValue);
        return newValue;
    }

    static int count = 0;
    public static int countGuesses(String newValue, String userInput) {
        if (count < 10) {
            if (!newValue.contains(userInput) && !inputList.contains(userInput)) {
                count++;
            }
        }
        System.out.println("You have " + count + " wrong guesses");
        return count;
    }
}
