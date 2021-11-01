

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static boolean isSaveNamePresent;
    static String userNameIdSave;
    static boolean isGameExitting = false;
    static char surrenderInput;
    static String inputFromUser;
    static int roundCounter;
    static String inputNamePlayerOne;
    static String inputNamePlayerTwo;
    static CardStackPlayerOne stackPlayerOne = new CardStackPlayerOne(inputNamePlayerOne);
    static CardStackPlayerTwo stackPlayerTwo = new CardStackPlayerTwo(inputNamePlayerTwo);




    public static void main(String[] args) throws InterruptedException {
        do {
            if (roundCounter < 1) {
                play("resources/checkthis.wav");
                System.out.println("\nTYPE PLAYER ONE NAME:");
                inputNamePlayerOne = scanner.next();
                System.out.println("\nTYPE PLAYER TWO NAME:");
                inputNamePlayerTwo = scanner.next();
                Collections.shuffle(stackPlayerOne.createStack());
                Collections.shuffle(stackPlayerTwo.createStack());
                roundCounter += 3;
                System.out.println("\nTYPE ANYTHING BUT 'x' TO START!");
                surrenderInput = scanner.next().charAt(0);
                if (surrenderInput == 'x') {
                    roundCounter = -1;
            }
        }
        if (roundCounter > 1) {
            System.out.println("PRESS 'x' TO SURRENDER!\n" +
                    "PRESS '1' TO SAVE!\n"
                    + "OR ANY OTHER KEY TO CONTINUE!");
            surrenderInput = scanner.next().charAt(0);
            boolean saveCommand = '1' == surrenderInput;
            if (saveCommand) {
                System.out.println("Please type your name: ");
                userNameIdSave = scanner.next();
                writerToFile(roundCounter + ";" + stackPlayerOne.displayStackToSave() + ";" + stackPlayerTwo.displayStackToSave() + ";" + userNameIdSave);
                System.out.println("PRESS 'x' TO EXIT!\nPRESS ANY OTHER KEY TO CONTINUE!");
                surrenderInput = scanner.next().charAt(0);
                if (surrenderInput == 'x') {
                    roundCounter = 0;
                }
            }
            if (roundCounter != 0 || surrenderInput != 'x') {
                Card playerOneTopCard = stackPlayerOne.top();
                Card playerTwoTopCard = stackPlayerTwo.top();
                int cardCompare = playerOneTopCard.compareTo(playerTwoTopCard);
                System.out.println("_________________________________________________\n");
                System.out.println("\n" + inputNamePlayerOne + "'s top card is " + playerOneTopCard + "\n");
                System.out.println("_________________________________________________\n");
                System.out.println(inputNamePlayerTwo + "'s top card is " + playerTwoTopCard + "\n");

                if (cardCompare == 0) {
                    ArrayList<Card> warCardsPlayerOne = new ArrayList<Card>();
                    ArrayList<Card> warCardsPlayerTwo = new ArrayList<Card>();
                    System.out.println("it's WAR!\n");
                    System.out.println(inputNamePlayerOne + " PLEASE TYPE A NUMBER 1-3");
                    int inputChoicePlayerOne = scanner.nextInt();
                    for (int i = 0; i < 3; i++) {
                        warCardsPlayerOne.add(stackPlayerOne.pop());
                    }
                    playerOneTopCard = warCardsPlayerOne.get(randomizer(inputChoicePlayerOne));
                    System.out.println(inputNamePlayerTwo + " PLEASE TYPE A NUMBER 1-3");
                    int inputChoicePlayerTwo = scanner.nextInt();
                    for (int i = 0; i < 3; i++) {
                        warCardsPlayerTwo.add(stackPlayerTwo.pop());
                    }
                    playerTwoTopCard = warCardsPlayerTwo.get(randomizer(inputChoicePlayerTwo));
                    cardCompare = playerOneTopCard.compareTo(playerTwoTopCard);
                    determineWinner(inputNamePlayerOne, inputNamePlayerTwo, stackPlayerOne, stackPlayerTwo,
                            roundCounter - 1, playerOneTopCard, playerTwoTopCard, cardCompare);
                }
                // EXERCISE THREE EXECUTED
                System.out.println("The number of saved games are:");
              ExerciseThree.getSavedGame();
                determineWinner(inputNamePlayerOne, inputNamePlayerTwo, stackPlayerOne, stackPlayerTwo,
                        roundCounter - 1, playerOneTopCard, playerTwoTopCard, cardCompare);
                roundCounter++;
                if (stackPlayerTwo.isEmpty() || isGameExitting) {
                    System.out.println(inputNamePlayerOne + " WINS THE GAME!");
                } else if (stackPlayerOne.isEmpty() || isGameExitting) {
                    System.out.println(inputNamePlayerTwo + " WINS THE GAME!");
                }
                if (surrenderInput == 'x') {
                    roundCounter = 0;
                }
            }



        }



        }while ( !isGameExitting );

    }

        static void determineWinner (String inputNamePlayerOne, String inputNamePlayerTwo, CardStackPlayerOne
        stackPlayerOne, CardStackPlayerTwo stackPlayerTwo,int roundCounter, Card playerOneTopCard, Card playerTwoTopCard,
        int cardCompare){
            if (cardCompare > 0) {
                System.out.println("_________________________________________________\n");
                System.out.println("\n" + inputNamePlayerTwo + " wins round nr. " + roundCounter);
                System.out.println("_________________________________________________\n");
                stackPlayerOne.pop();
                stackPlayerTwo.enqueue(playerOneTopCard);
            }
            if (cardCompare < 0) {
                System.out.println("_________________________________________________\n");
                System.out.println("\n" + inputNamePlayerOne + " wins round nr. " + roundCounter);
                System.out.println("_________________________________________________\n");
                stackPlayerTwo.pop();
                stackPlayerOne.enqueue(playerTwoTopCard);
            }
        }


        static int randomizer ( int bound){
            return random.nextInt(bound);
        }

         static void writerToFile(String listToBeSaved){
            try {
                Writer w = new FileWriter("resources/GameStats.csv", true);
                w.write("\r\n");
                String content = listToBeSaved;
                w.write(content);
                w.close();

                System.out.println("Saved" + "💾");
            } catch (IOException e) {
                e.printStackTrace();
                isSaveNamePresent = false;
                System.out.println("Name not found!");
            }
        }
    static void play(String filename)
    {
        try
        {
            Clip clip = AudioSystem.getClip();
            ((Clip) clip).open(AudioSystem.getAudioInputStream(new File(filename)));
            clip.start();
        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }

}


