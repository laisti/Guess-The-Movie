import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
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

        while (randomLineUnderscore.contains("_")) {
            String newCharacter = Game.userInput();
            randomLineUnderscore = Game.searchCharacter(randomLine, newCharacter, randomLineUnderscore);
        }
    }
}
