Video Poker
===========
&emsp;This is a program designed, developed, and built by a team of 3 people.
It was built as a final project to determine the group's understanding of Java.
The program was designed to be played through a GUI.

&emsp; The game starts out with a player able to make a bet to increase the 
amount won if the player receives a winning hand. After the bet is confirmed,
the hand is dealt to the player. The player is then able to select any card
in the hand to be replaced. After the player has or has not selected cards to
be replaced, the game checks the player's hand to see if there are any winning
combinations. Players can win with one of the following hands:
- Royal Flush
- Straight Flush
- Four of a Kind
- Full House
- Flush
- Straigh
- Three of a Kind
- Two Pair
- Jacks or Better

Classes
========
###VideoPoker###
&emsp;This is the main class of the program. Sets up the GUI, allowing the player
to play a round, save the game, and load the game. Also allows the player to reset
the game.

###SaveLoad###
&emsp;This class handles the saving and loading of the game. When saving, the program
saves the amount the player has won, the amount of games played, the number of games 
won and the number of games lost. When loading, it will pull the information out of
a text file and place it into the game.

###PokerUI###
&emsp;This class handles the UI of the game. The top row contains the various payouts
possible for the game. The middle row contains the player's hand, and the bottom row
contains the buttons for betting and replacing cards.

###Player###
&emsp;This class holds the information for the player. This information includes games
played, games won, games lost, and the net profit for the player's bidding.

###PayoutTier###
&emsp;This class holds an enumeration that has the various tiers for payout wins.

###Payout###
&emsp;This class will get and return the payout a player receives for winning a hand in
the game.

###Hands###
&emsp;This class contains the various types of hands that will give a win in the game.

###CheckHand###
&emsp;This class compares the player's hand to the various types of hands that can win
the game and return a bid.

###CardImage###
&emsp;This class adds images to all of the cards when the hand is dealt to the player.

###Card###
&emsp;This class contains two enumerations to hold the suit type and face type of every card.
