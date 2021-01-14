package main.java.app.model;

public class Game {
    Player player1;
    Player player2;
    Deck table = new Deck();
    Boolean p1Turn;
    Boolean endGame;

    public Game(String p1, String p2) {
        player1 = new Player(p1, new Deck());
        player2 = new Player(p2, new Deck());
    }

    public Game(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
    }

    public void dealCards() {
        Deck deck = new Deck();
        deck.createFullDeck();
        for (int i = 0; i < 12; i++) {
            this.player1.addCard(deck.popRandomCard());
            this.player2.addCard(deck.popRandomCard());
        }
        player1.sort();
        player2.sort();
        endGame = false;
        p1Turn = player1.isFirst();
    }

    public Boolean giveCardIfPossible(int index, Boolean p1Turn) {

        if (!table.isEmpty()) { //any equal or higher
            if (p1Turn && index < player1.getDeck().getSize() && (player1.getDeck().getCardByIndex(index).getValue() >= table.getCardByIndex(table.getSize() - 1).getValue())) {
                Card c = player1.giveCard(index);
                table.addCard(c);
                return true;
            } else if (!p1Turn && index >= player1.getDeck().getSize() && (player2.getDeck().getCardByIndex(index - player1.getDeck().getSize()).getValue() >= table.getCardByIndex(table.getSize() - 1).getValue())) {
                Card c = player2.giveCard(index - player1.getDeck().getSize());
                table.addCard(c);
                return true;
            }
        } else { //only 9 of Hearts
            if (p1Turn && index < player1.getDeck().getSize() && (player1.getDeck().getCardByIndex(index).getValue() == 0 && player1.getDeck().getCardByIndex(index).getColor() == "kier")) {
                Card c = player1.giveCard(index);
                table.addCard(c);
                return true;
            } else if (!p1Turn && index >= player1.getDeck().getSize() && (player2.getDeck().getCardByIndex(index - player1.getDeck().getSize()).getValue() == 0 && player2.getDeck().getCardByIndex(index - player1.getDeck().getSize()).getColor() == "kier")) {
                Card c = player2.giveCard(index - player1.getDeck().getSize());
                table.addCard(c);
                return true;
            }
        }

        return false;
    }

    public void giveCard(int index) {
        if (!endGame && giveCardIfPossible(index, p1Turn))
            changePlayers();
        if (player1.isEmpty() || player2.isEmpty()) {
            setEndGame(true);
        }
    }

    public void takeOneCardFromTable() {
        if (table.getSize() > 1) {
            if (p1Turn) {
                Card c = table.removeByIndex(table.getSize() - 1);
                player1.addCard(c);
                player1.sort();
            } else {
                Card c = table.removeByIndex(table.getSize() - 1);
                player2.addCard(c);
                player2.sort();
            }
        }
    }

    public void takeCardsFromTable() {
        if (!endGame && table.getSize() > 1) {
            takeOneCardFromTable();
            takeOneCardFromTable();
            takeOneCardFromTable();
            changePlayers();
        }
    }

    public void changePlayers() {
        p1Turn = !p1Turn;
    }

    public void setEndGame(Boolean endGame) {
        this.endGame = endGame;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Deck getTable() {
        return table;
    }

    public Boolean getP1Turn() {
        return p1Turn;
    }

    public Boolean getEndGame() {
        return endGame;
    }

    @Override
    public String toString() {
        return "Game{\n" +
                "player1=" + player1 +
                "\n, player2=" + player2 +
                "\n, talia=" + table +
                '}';
    }

    public void play() { //simulate some turns
        Card c = player1.giveCard(0);
        table.addCard(c);
        int counter = 0;
        while (counter < 50 && !player1.isEmpty() && !player2.isEmpty() && !table.isEmpty()) {
            Card x = player2.giveCard(0);
            if (x.getValue() < table.getCardByIndex(table.getSize() - 1).getValue()) player1.addCard(x);
            else table.addCard(x);
            Card y = player1.giveCard(0);
            if (y.getValue() < table.getCardByIndex(table.getSize() - 1).getValue()) player2.addCard(y);
            else table.addCard(y);
            counter++;
        }
    }

    public static void main(String[] args) {

        Game game = new Game("Tomek", "Daniel");

        game.dealCards();
        System.out.println(game);
        game.play();
        System.out.println(game);
    }
}
