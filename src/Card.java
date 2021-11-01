// this class inherits methods from the Comparable interface
public class Card implements Comparable<Card>{
    private CardNames name;
    private int number;
    private static int cardInExistence;

    public Card(CardNames name, int number) {
        this.name = name;
        this.number = number;
        cardInExistence++;
    }

    public CardNames getName() {
        return name;
    }
    public void setName(CardNames name) {
        this.name = name;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "" + name;
    }

    @Override
    public int compareTo(Card opponentTopCard) {
        return Integer.compare(opponentTopCard.getNumber(), this.getNumber());
    }
}

