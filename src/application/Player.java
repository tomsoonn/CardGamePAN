package application;


public class Player {
	private String name;
	private Deck deck;
	
	public Player(String n, Deck d){
		this.name=n;
		this.deck=d;
	}
	
	public void addCard(Card c){
		this.deck.add(c);
	}
	
	public Card giveCard(int decision){
		Card tmp = deck.remove(decision);
	    return tmp;
	}
	
	public void Wyswietl(){
		System.out.println(name);
		this.deck.Wyswietl();
		   
	}
	
	public String getName(){
		return this.name;
	}
	public Deck getDeck(){
		return this.deck;
	}
	
	public Boolean isEmpty(){
		return deck.isEmpty();
	}
	public void sort(){
		deck.sort();
	}

	

}
