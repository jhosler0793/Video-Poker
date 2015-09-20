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
public enum Hands {
	ROYAL_FLUSH(250), STRAIGHT_FLUSH(50), FOUR_KIND(25), FULL_HOUSE(9), FLUSH(6), STRAIGHT(4), THREE_KIND(3), TWO_PAIR(2), ONE_PAIR(1), FLOP(0);
	
	private final int handValue;
	
	private Hands(int handValue) {
		this.handValue = handValue;
	}

	public int getHandValue() {
		return this.handValue;
	}
};