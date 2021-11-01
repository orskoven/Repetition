import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class ExerciseThree {

    static void getSavedGame() {
        int lineCounter = 0;
        boolean isNameFound = false;
        File populationFiles = new File("resources/GameStats.csv");
        try {
            Scanner sc = new Scanner(populationFiles);
            while (sc.hasNextLine() || isNameFound) {
                // Få mappet dataværdier til et object
                String line = sc.nextLine();
                String[] stringLikeArray = line.split(";");
                lineCounter++;

            }
            System.out.println(lineCounter);
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found!");
            e.printStackTrace();
        }
    }
}
