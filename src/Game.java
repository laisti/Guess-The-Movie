import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    static String userInput() {
        System.out.println("Input a character:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static ArrayList<String> inputList = new ArrayList<String>();
    static void addUserInput(String userInput) {
        if (!inputList.contains(userInput)) {
            inputList.add(userInput);
        }
    }

    static String searchCharacter(String randomLine, String userInput, String randomLineUnderscore) {
        char character = userInput.charAt(0);
        StringBuilder newLine = new StringBuilder(randomLineUnderscore);
        String newValue = "";
        for(int i = 0; i < randomLine.length();i++) {
            if(randomLine.charAt(i) == character) {
                newLine.setCharAt(i, character);
                newValue = newLine.toString();
            }
            else {
                newValue = newLine.toString();
            }
        }
        System.out.println(newValue);
        return newValue;
    }

    private static int countOfWrongGuesses = 0;
    static int countGuesses(String newValue, String userInput) {
        if (countOfWrongGuesses < 10) {
            if (!newValue.contains(userInput) && !inputList.contains(userInput)) {
                countOfWrongGuesses++;
            }
        }
        System.out.println("You have " + countOfWrongGuesses + " wrong guesses");
        return countOfWrongGuesses;
    }
}
