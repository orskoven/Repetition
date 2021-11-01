import java.util.ArrayList;
import java.util.Scanner;

public class ExerciseSix {
    static ArrayList<Integer> numbers = new ArrayList<Integer>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            numbers.add(i);
        }
        System.out.println(numbers);
        System.out.println("Please enter which number multiply to remove:");
        int numberToRemove = scanner.nextInt();
        for (int i  = 0; i < numbers.size(); i++) {
           if (numbers.get(i) % numberToRemove == 0 && numberToRemove != numbers.get(i)){
               numbers.remove(i);
           }
        }
        System.out.println(numbers);
    }
}


