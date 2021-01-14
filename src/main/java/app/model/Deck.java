package main.java.app.model;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> deck = new LinkedList<>();
    private Random random = new Random();

    public void addCard(Card c) {
        deck.add(c);
    }

    public Card popRandomCard() {
        int index = random.nextInt(deck.size());
        return deck.remove(index);
    }

    public Card getCardByIndex(int i) {
        return deck.get(i);

    }

    public Card removeByIndex(int i) {
        return deck.remove(i);
    }

    public void createFullDeck() {
        String[] colors = {"kier", "karo", "pik", "trefl"};
        String[] figures = {"dziewiec", "dziesiec", "jopek", "dama", "krol", "as"};

        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < figures.length; j++) {
                Card c = new Card(j, figures[j], colors[i]);
                deck.add(c);
            }
        }
    }

    public Boolean isEmpty() {
        return deck.isEmpty();
    }

    public int getSize() {
        return deck.size();
    }

    public void sort() {
        Collections.sort(deck);
    }

    @Override
    public String toString() {
        return deck.toString();
    }

}
