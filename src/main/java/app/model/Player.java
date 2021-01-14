package main.java.app.model;


public class Player {
    private String name;
    private Deck deck;

    public Player(String n, Deck d) {
        this.name = n;
        this.deck = d;
    }

    public void addCard(Card c) {
        this.deck.addCard(c);
    }

    public Card giveCard(int decision) {
        Card tmp = deck.removeByIndex(decision);
        return tmp;
    }

    public boolean isEmpty() {
        return deck.isEmpty();
    }

    public boolean isFirst() {
        boolean isFirst = false;
        for (int i = deck.getSize() - 1; i > deck.getSize() - 5; i--) {
            if (deck.getCardByIndex(i).getValue() == 0 && deck.getCardByIndex(i).getColor().equals("kier")) {
                isFirst = true;
            }
        }
        return isFirst;
    }

    public void sort() {
        deck.sort();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", deck=\n" + deck +
                '}';
    }
}
