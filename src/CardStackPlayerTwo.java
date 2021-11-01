//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CardStackPlayerTwo implements ArrayWarStack {
    static  Random random = new Random();
    private String playerName;
    private static ArrayList<Hearts> heartsObjects = new ArrayList(13);
    private static ArrayList<Clubs> clubsObjects = new ArrayList(13);
    private static ArrayList<Diamonds> diamondsObjects = new ArrayList(13);
    private static ArrayList<Spades> spadesObjects = new ArrayList(13);
    private static ArrayList<Card> cardObjects = new ArrayList();
    private Card firstCard;

    public CardStackPlayerTwo(String playerName) {
        this.playerName = playerName;
    }

    public ArrayList<Card> createStack() {
        for (int j = 1; j < 16; j++) {
            switch (j) {
                case 1:
                    for (CardNames name: CardNames.values()) {
                        cardObjects.add(new Hearts(name,j));
                        j++;
                    } j = 1;
                case 16:

                    for (CardNames name: CardNames.values()) {
                        cardObjects.add(new Clubs(name,j));
                        j++;
                    }j = 1;
                case 29:

                    for (CardNames name: CardNames.values()) {
                        cardObjects.add(new Diamonds(name,j));
                        j++;
                    }j = 1;
                case 35:
                    for (CardNames name: CardNames.values()) {
                        cardObjects.add(new Spades(name,j));
                        j++;
                    }
            }

        }return cardObjects;
    }
    public void enqueue (Card c){
        cardObjects.set(cardObjects.size()-1,c);
    }

    public void push(Card c) {
        cardObjects.add(c);
    }

    public String getPlayerName() {
        return playerName;
    }

    public Card pop() {
        return cardObjects.remove(cardObjects.size()-1);
    }

    public Card getFirstCard() {
        return firstCard;
    }

    public boolean isEmpty() {
        return cardObjects.isEmpty();
    }

    public Card top() {
        return cardObjects.get(cardObjects.size()-1);
    }


    public int size() {
        return cardObjects.size();
    }
    public void display() {
        System.out.println(cardObjects.toString());
    }

    public String toString() {
        return "Stack{}";
    }
    public void shuffles(){
        Collections.shuffle(cardObjects);
    }

    public String displayStackToSave() {
        return cardObjects.toString();
    }
}