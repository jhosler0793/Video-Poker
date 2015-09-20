/************************************************************************************************************************************************************
	Card.java
	Purpose: To hold two enumerations which the rest of the program relies on for generating hands.
************************************************************************************************************************************************************/
public class Card{
	//Two enumerations to hold the face value and suit of every card.
	public enum suitValue {HEARTS, DIAMONDS, SPADES, CLUBS};
	public enum faceValue {ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);
		private int face;
		
		private faceValue(int face) {
			this.face = face;
		}
		
		public int getFace() {
			return this.face;
		}
	};
	//Three variables to keep track of the card suit, card face value, and if the card is flipped to display the face or the back.
	public suitValue cardSuit;
	public faceValue cardFace;
	//public boolean flip; Outdated
	//Creates a new instance of card setting the face value and suit to null 
	public Card(){
		cardSuit = null;
		cardFace = null;
	//	flip = true; Outdated
	}
	
	
	public Card(suitValue s,faceValue f){
		cardSuit = s;
		cardFace = f;
		
	}
	
	
	//public void flip(){flip=false;} Outdated
	public void setFace(faceValue val){this.cardFace=val;}
	public void setSuit(suitValue val){this.cardSuit=val;}
	
//	public suitValue getFace(){return cardSuit;} Outdated
	public suitValue getSuit(){return cardSuit;}
	//public boolean isFlipped(){return flip;} Outdated
}