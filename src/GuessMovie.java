import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Random;

public class GuessMovie extends Game{

    public static void main(String [] args) throws Exception {
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
