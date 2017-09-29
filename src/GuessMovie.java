/**
 * <h1>Guess Movie Name!</h1>
 * The GuessMovie program implements an application that
 * chooses movie from .txt file randomly, hides the name of a movie
 * and shows characters on the screen if user inputs character which
 * is in this name.
 *
 * @author  Laima Stinskaite
 * @version 1.0
 * @since   2017-09-29
 */

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Random;

public class GuessMovie extends Game{

    /**
     * This is the main method which extends Game class.
     * @param args Unused.
     * @return Nothing.
     * @exception Exception On input error.
     * @see Exception
     */
    public static void main(String [] args) throws Exception {
        // Reads every line in .txt file and selects random one
        BufferedReader reader = new BufferedReader(new FileReader("movies.txt"));
        String line = reader.readLine();
        List<String> lines = new ArrayList<String>();
        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }
        Random r = new Random();
        String randomLine = lines.get(r.nextInt(lines.size()));
        String randomLineUnderscore = randomLine.replaceAll("[a-zA-Z]", "_");
        System.out.println(randomLineUnderscore);

        int countOfWrongGuesses = 0;

        // Main logic of the Game
        while (randomLineUnderscore.contains("_")) {
            if (countOfWrongGuesses < 10) {
                String newCharacter = Game.userInput();
                if (newCharacter.length() == 1) {
                    randomLineUnderscore = Game.searchCharacter(randomLine, newCharacter, randomLineUnderscore);
                    if (!randomLineUnderscore.contains("_")) {
                        System.out.println("You win!");
                    } else {
                        countOfWrongGuesses = Game.countGuesses(randomLineUnderscore, newCharacter);
                        Game.addUserInput(newCharacter);
                    }
                }
                else {
                    System.out.println("You may input ONLY one character.");
                    System.out.println(randomLineUnderscore);
                }
            } else {
                System.out.println("You lost!");
                break;
            }
        }
    }
}
