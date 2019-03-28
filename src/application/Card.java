package application;


public class Card implements Comparable<Card> {
	private String name, color;
	int value;
	
	public Card(int v, String n,String c){
		this.value=v;
		this.name=n;
		this.color=c;
	}
	public int getValue(){
		return this.value;
	}
	public String getName (){
		return this.name;
	}
	public String getColor (){
		return this.color;
	}
	public String toString(){
		return this.value + "   " + this.name + "  " + this.color;
	}
	@Override
	public int compareTo(Card o2) {
        int oceny;
        if(this.getValue()==o2.getValue()) oceny=0;
        else if(this.getValue()>o2.getValue()) oceny=-1;
        else oceny=1;
              
        
        return (int) oceny;
    }

}
