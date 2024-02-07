import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] suits = {"Tréboles", "Corazones", "Picas", "Diamantes"};
        String[] colors = {"Negro", "Rojo"};

        for (String suit : suits) {
            for (int value = 2; value <= 10; value++) {
                cards.add(new Card(suit, colors[value % 2], String.valueOf(value)));
            }
            cards.add(new Card(suit, colors[0], "J"));
            cards.add(new Card(suit, colors[0], "Q"));
            cards.add(new Card(suit, colors[0], "K"));
            cards.add(new Card(suit, colors[1], "A"));
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        Card card = cards.remove(0);
        System.out.println(card);
        System.out.println("Quedan " + cards.size() + " cartas en deck");
    }

    public void pick() {
        int randomIndex = (int) (Math.random() * cards.size());
        Card card = cards.remove(randomIndex);
        System.out.println(card);
        System.out.println("Quedan " + cards.size() + " cartas en deck");
    }

    public void hand() {
        for (int i = 0; i < 5; i++) {
            Card card = cards.remove(0);
            System.out.println(card);
        }
        System.out.println("Quedan " + cards.size() + " cartas en deck");
    }
}

class Card {
    private String suit;
    private String color;
    private String value;

    public Card(String suit, String color, String value) {
        this.suit = suit;
        this.color = color;
        this.value = value;
    }

    @Override
    public String toString() {
        return suit + "," + color + "," + value;
    }
}

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println("---- Head ----");
        deck.head();
        System.out.println("---- Pick ----");
        deck.pick();
        System.out.println("---- Hand ----");
        deck.hand();
    }
}
