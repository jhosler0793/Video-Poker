/*
Royal Flush		250		500		750		1000	4000
Straight Flush	50		100		150		200		250
Four of a kind	25		50		75		100		125
Full House		9		18		27		36		45
Flush			6		12		18		24		30
Straight		4		8		12		16		20
Three of a kind	3		6		9		12		15
Two Pair		2		4		6		8		10
Jacks or Better	1		2		3		4		5
*/

/*
Royal Flush
	10, jack, queen, king, ace; same suit
Straight Flush
	cards are sequential; not royal flush; same suit
Four of a kind
	four of a single card
Full House
	three of one card, two of another
Flush
	all cards same suit
Straight
	cards are sequential; not same suit
Three of a kind
	three of one card
Two Pair
	two of one card, two of another
Jacks or Better
	pair of jacks, queens, kings, or aces
*/
import java.util.Arrays;

public class CheckHand {
	public static boolean checkPair(Card[] array) {
		boolean isPair = false;
		
		for(int i = 0; i < array.length - 1; i++) {
			int count = 1;
			for(int j = i + 1; j < array.length; j++) {
				if(array[i].cardFace == array[j].cardFace && (array[i].cardFace == Card.faceValue.JACK || array[i].cardFace == Card.faceValue.QUEEN || array[i].cardFace == Card.faceValue.KING || array[i].cardFace == Card.faceValue.ACE)) {
					count++;
				}
				if(count > 2) {
					count = 1;
				}
			}
			if(count == 2) {
				return isPair = true;		
			}
		}
		
		return isPair;
	}
	
	public static boolean checkTwoPair(Card[] array) {
		Card pairOne = null;
		Card pairTwo = null;
		boolean isTwoPair = false;
		int count = 0;
		
		for(int i = 0; i < array.length - 1; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if(array[i].cardFace == array[j].cardFace && count < 1) {
					pairOne = array[i];
					count++;
				}
				else if(array[i].cardFace == array[j].cardFace && count > 0) {
					pairTwo = array[i];
					count++;
				}
			}
			if(pairOne != pairTwo && count == 2) {
				return isTwoPair = true;
			}
		}
		return isTwoPair;
	}

	public static boolean checkTwo(Card[] array) {
		Card cardOne = null;
		Card cardTwo = null;
		boolean isTwo = false;
		
		for(int i = 0; i < array.length - 1; i++) {
			int count = 1;
			int temp = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[temp].cardFace == array[j].cardFace && count < 2) {
					cardOne = array[temp];
					temp = j;
					count++;
				}
				else if(array[temp].cardFace == array[j].cardFace && count > 1) {
					cardTwo = array[temp];
					temp = j;
					count++;
				}
			}
			if(cardOne != cardTwo && count == 2) {
				return isTwo = true;
			}
		}
		return isTwo;
	}
	
	public static boolean checkThree(Card[] array) {
		Card card = null;
		boolean isThree = false;
		
		for(int i = 0; i < array.length - 1; i++) {
			int count = 1;
			int temp = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[temp].cardFace == array[j].cardFace && card == null) {
					card = array[temp];
					temp = j;
					count++;
				}
				else if(array[temp].cardFace == array[j].cardFace && array[temp] != card) {
					card = array[temp];
					temp = j;
					count++;
				}
			}
			if(count == 3) {
				return isThree = true;
			}
		}
		return isThree;
	}
	
	public static boolean checkFour(Card[] array) {
		boolean isFour = false;
		
		for(int i = 0; i < array.length - 1; i++) {
			int count = 1;
			int temp = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[temp].cardFace == array[j].cardFace) {
					temp = j;
					count++;
				}
			}
			if(count == 4) {
				return isFour = true;
			}
		}
		return isFour;
	}
	
	public static boolean checkStraight(Card[] array) {
		int[] temp = new int[array.length];
		boolean isStraight = false;
		
		for(int i = 0; i < array.length; i++) {
			temp[i] = array[i].cardFace.getFace();
		}
		
		Arrays.sort(temp);
		
		for(int i = 0; i < temp.length - 1; i++) {
			if(temp[i] != temp[i + 1] - 1) {
				return isStraight;
			}
		}
		return isStraight = true;
	}

	public static boolean checkFlush(Card[] array) {
		boolean isFlush = false;
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i].cardSuit != array[i + 1].cardSuit) {
				return isFlush;
			}	
		}
		return isFlush = true;
	}
	
	public static boolean checkRoyal(Card[] array) {
		int[] temp = new int[array.length];
		boolean isRoyal = false;
		
		for(int i = 0; i < array.length; i++) {
			temp[i] = array[i].cardFace.getFace();
		}
		
		Arrays.sort(temp);
		
		if(temp[0] == Card.faceValue.ACE.getFace() && temp[1] == Card.faceValue.TEN.getFace() && temp[2] == Card.faceValue.JACK.getFace() && temp[3] == Card.faceValue.QUEEN.getFace() && temp[4] == Card.faceValue.KING.getFace()) {
			return isRoyal = true;
		}
		return isRoyal;
	}
	
	public static boolean checkRoyalFlush(Card[] array) {
		boolean isRoyalFlush = false;
		
		if(checkFlush(array) && checkRoyal(array)) {
			return isRoyalFlush = true;
		}
		return isRoyalFlush;
	}
	
	public static boolean checkStraightFlush(Card[] array) {
		boolean isStraightFlush = false;
		
		if(checkFlush(array) && checkStraight(array)) {
			return isStraightFlush = true;
		}
		return isStraightFlush;
	}
	
	public static boolean checkFullHouse(Card[] array) {
		boolean isFullHouse = false;
		
		if(checkTwo(array) && checkThree(array)) {
			return isFullHouse = true;
		}
		return isFullHouse;
	}
	
	public static Hands getHand(Card[] array) {
		if(checkRoyalFlush(array)) {
			return Hands.ROYAL_FLUSH;
		}
		else if(checkStraightFlush(array)) {
			return Hands.STRAIGHT_FLUSH;
		}
		else if(checkFour(array)) {
			return Hands.FOUR_KIND;
		}
		else if(checkFullHouse(array)) {
			return Hands.FULL_HOUSE;
		}
		else if(checkFlush(array)) {
			return Hands.FLUSH;
		}
		else if(checkStraight(array) || checkRoyal(array)) {
			return Hands.STRAIGHT;
		}
		else if(checkThree(array)) {
			return Hands.THREE_KIND;
		}
		else if(checkTwoPair(array)) {
			return Hands.TWO_PAIR;
		}
		else if(checkPair(array)) {
			return Hands.ONE_PAIR;
		}
		else {
			return Hands.FLOP;
		}
	}
}