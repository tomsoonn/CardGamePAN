package main.java.app.model;


public class Card implements Comparable<Card> {
    int value;
    private String name, color;

    public Card(int v, String n, String c) {
        this.value = v;
        this.name = n;
        this.color = c;
    }

    public int getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                "}\n";
    }

    @Override
    public int compareTo(Card o2) {
        return Integer.compare(o2.getValue(), this.getValue());
    }
}
