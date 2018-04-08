package application;


import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck {
	private List<Card> deck = new LinkedList<Card>();
	
	public void add(Card c){
		deck.add(c);
	}
	
	public Card getCard(int a){
		return deck.get(a);
		
	}
	public Card popCard(){
		Random r = new Random();
	    int index = r.nextInt(deck.size());
	    Card tmp = deck.remove(index);
	    return tmp;
	}
	public Card remove(int a){
		Card tmp = deck.remove(a);
		return tmp;
	}
	
	public void createFull(){
			
		String kolory[]={"kier","karo","pik","trefl"};
		String figury[]={"dziewiec", "dziesiec", "jopek","dama","krol","as"};
			
		for(int i=0;i<4;i++){
			   for(int j=0;j<6;j++){
				   Card c =new Card(j,figury[j],kolory[i]);
				   deck.add(c);
			   }
		}
	}
	
	public Boolean isEmpty(){
		return deck.isEmpty();
	}
	
	public void Wyswietl(){
		 Iterator<Card> x= deck.iterator() ;
		  
		 while(x.hasNext()){
			 System.out.println(x.next());
		 }
		   
	}
	/*
	public Boolean theSame34(int val){
		Iterator<Card> x= deck.iterator() ;
		int count=0;
		while(x.hasNext()){
			 if(x.next().getValue()==val) count++;
		}
		if(count>1) return true;
		return false;
		
	}
	*/
		
	
	public int getNum(){
		return deck.size();
	}
	
	public void sort(){
		Collections.sort(deck);
	}
	
	
	
}
