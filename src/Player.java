/************************************************************************************************************************************************************
	Player.java
	Purpose: To hold data about the Total games played, games won, games lost, and the net profit for the players bidding.
************************************************************************************************************************************************************/
import java.util.Random;
public class Player{
	private   Card[] myHand = new Card[5];
	
	public   double myBet = 0;
    public   double myWinnings = 0;
    public   int gamesPlayed = 0;
    public   int gamesWon = 0;
    public   int gamesLost = 0;
	//Getters and setters for total games played.
	 public   void setStartingGamesPlayed(int n){gamesPlayed = n;}
    public   void setGamesPlayed(int n){gamesPlayed = gamesPlayed + n;}
    public   int getGamesPlayed(){return gamesPlayed;}
	//Getters and setters for games won.
	public   void setStartingGamesWon(int n){gamesWon = n;}
    public   void setGamesWon(int n){gamesWon = gamesWon + n;}
    public   int getGamesWon(){return gamesWon;}
	//Getters and setters for games lost.
	public   void setStartingGamesLost(int n){gamesLost = n;}
    public   void setGamesLost(int n){gamesLost = gamesLost + n;}
    public   int getGamesLost(){return gamesLost;}
    //Getters and setters for the card array which will hold the hand.
	public   Card[] getHand(){return myHand;}
	public   void setHand(Card[] c){myHand = c;}
	public Card getCard(int i, Card[] tempArr){return tempArr[i];}
	//Getter and setter for the bet.
	public   void setBet(double n){ if(n>500) myBet = 500; else if(n < 10) myBet = 10; else myBet = n;}
    public   double getBet(){return myBet;}
	//Getters and setters for the winnings  of the player.
	public   void setStartingWinnings(double n){ myWinnings = n;}
	public   void setWinnings(double n){ myWinnings = myWinnings + n;}
    public   double getWinnings(){return myWinnings;}

	
    //Creates a new instance of Player, generating a new hand, setting gamesPlayed, Won, and Lost to 0, and the winnings set to 1000.0
	public Player(){
		Card[] newHand = new Card[5];
		for(int i=0; i<newHand.length; i++){
			newHand[i] = genCard();
		}
		setHand(newHand);
		gamesPlayed = 0;
		gamesLost = 0;
		gamesWon = 0;
		myWinnings = 1000.0;
		
	}
	
	//Generates a single card.
	public Card genCard(){
		Card newCard = new Card();
		Random suitGen = new Random();
		Random faceGen = new Random();
		int suitTemp = suitGen.nextInt(4);
		int faceTemp = faceGen.nextInt(12);
		//Use a switch statement to find the card suit.
		switch(suitTemp){
			case 0:
				newCard.setSuit(Card.suitValue.HEARTS);
				break;
			case 1:
				newCard.setSuit(Card.suitValue.DIAMONDS);
				break;
			case 2:
				newCard.setSuit(Card.suitValue.CLUBS);
				break;
			case 3:
				newCard.setSuit(Card.suitValue.SPADES);
		}
		//Use a switch statement to find the card face value.
		switch(faceTemp){
			case 0:
				newCard.setFace(Card.faceValue.ACE);
				break;
			case 1:
				newCard.setFace(Card.faceValue.TWO);
				break;
			case 2:
				newCard.setFace(Card.faceValue.THREE);
				break;
			case 3:
				newCard.setFace(Card.faceValue.FOUR);
				break;
			case 4:
				newCard.setFace(Card.faceValue.FIVE);
				break;
			case 5:
				newCard.setFace(Card.faceValue.SIX);
				break;
			case 6:
				newCard.setFace(Card.faceValue.SEVEN);
				break;
			case 7:
				newCard.setFace(Card.faceValue.EIGHT);
				break;
			case 8:
				newCard.setFace(Card.faceValue.NINE);
				break;
			case 9:
				newCard.setFace(Card.faceValue.TEN);
				break;
			case 10:
				newCard.setFace(Card.faceValue.JACK);
				break;
			case 11:
				newCard.setFace(Card.faceValue.QUEEN);
				break;
			case 12:
				newCard.setFace(Card.faceValue.KING);
				break;
		}
		return newCard;
	}
	
	//Generates a new hand, and also checks for duplicates.
	public Card[] genHand(){
		Card[] newHand = new Card[5];
		for(int i=0; i<newHand.length; i++){
			Card newCard = genCard();
			newHand[i] = newCard;
		}
		checkAndReplaceDuplicates(newHand);		
		setHand(newHand);
		return newHand;
	}
	//Replaces cards in hand, boolean true replaces the card.
	public Card[] genHand(boolean par1, boolean par2, boolean par3, boolean par4, boolean par5){
		setHand(myHand);
		if(par1){
			Card newCard = genCard();
			myHand[0] = newCard;
			checkAndReplaceDuplicates(myHand);
		}
		if(par2){
			Card newCard = genCard();
			myHand[1] = newCard;
			checkAndReplaceDuplicates(myHand);
		}
		if(par3){
			Card newCard = genCard();
			myHand[2] = newCard;
			checkAndReplaceDuplicates(myHand);
		}
		if(par4){
			Card newCard = genCard();
			myHand[3] = newCard;
			checkAndReplaceDuplicates(myHand);
		}
		if(par5){
			Card newCard = genCard();
			myHand[4] = newCard;
			checkAndReplaceDuplicates(myHand);
		}
		return myHand;
	}
	
	//Checks for duplicate cards and replaces any that have been duplicated.
	public Card[] checkAndReplaceDuplicates(Card[] c){
		for(int i=0; i<c.length; i++){
			for(int j=0; j<c.length; j++){
				if(c[i].cardSuit == c[j].cardSuit && c[i].cardFace == c[j].cardFace && i != j){
					Card newCard = genCard();
					c[j] = newCard;
				}
			}
		}
		return c;
	}
	//Returns a card as a string.
	public String cardToString(Card c){
		String cardComplete = new String("");
		cardComplete += c.cardFace;
		cardComplete += " OF ";
		cardComplete += c.cardSuit;
		return cardComplete;
	}
	//Places the bet specified and checks the hand to determine the payout.
	public void playBet(double i){
		if(CheckHand.getHand(myHand) == Hands.FLOP){
			myWinnings = myWinnings - i;
			setGamesPlayed(1);
			setGamesLost(1);
		}
		else if(CheckHand.getHand(myHand) != Hands.FLOP){
			setWinnings(Payout.getPayout(CheckHand.getHand(myHand), i));
			setGamesPlayed(1);
			setGamesWon(1);
		}
	}
}