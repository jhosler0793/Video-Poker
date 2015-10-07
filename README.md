Video Poker
===========
&emsp;This is a program designed, developed, and built by a team of 3 people.
It was built as a final project to determine the group's understanding of Java.
The program was designed to be played through a GUI.

&emsp; The game starts out with a user able to make a bet to increase the 
amount won if the user receives a winning hand. After the bet is confirmed,
the hand is dealt to the user. The user is then able to select any card
in the hand to be replaced. After the user has or has not selected cards to
be replaced, the game checks the user's hand to see if there are any winning
combinations. The program was designed around the [Jacks or Better](https://en.wikipedia.org/wiki/Video_poker#Jacks_or_Better)
video poker machine.

##My Role##
&emsp; My role on this team was to assist in programming and GUI design.

##Requirements##
- A [**JDK**](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) is required.

###Features###
####1.) Easy-to-Use GUI####
&emsp; The program features a functional, easy-to-use GUI.

![Imgur](http://i.imgur.com/MMYRzpd.png)

&emsp;In the GUI is a toolbar giving the user access to save their progress, load from an older save, or start a new game.
It includes a listing of all the possible rewards, an area to display the user's hand, buttons for placing the minimum bet of $10.00
and the maximum bet of $500.00, an area to display the current amount being bet, and two buttons to hold current cards in the hand or deal
more cards. The GUI also includes a stat-tracking area displaying games played, games won, games lost, and the net gain achieved by the user.

####2.) All payouts viewable####
&emsp; When a user has placed their bet and drawn cards, the payout screen will light up with the potential reward the user will receive if
the user has a winning hand.

![Imgur](http://i.imgur.com/7Un1fpT.png)

- If a player has bet between $10 and $100, the first column will be highlighted.
- If a player has bet between $101 and $200, the second column will be highlighted.
- If a player has bet between $201 and $300, the third column will be highlighted.
- If a player has bet between $301 and $400, the fourth column will be highlighted.
- If a player has bet between $401 and $500, the fifth column will be highlighted.

####3.)Saving and Loading####
&emsp; The program also includes a way to save the user's data when the user is done playing. The user would go
to the top left of the program and press on 'File' that will open a dropdown menu with three options:

![Imgur](http://i.imgur.com/1kfPsXw.png?1)

&emsp; If the user selects `New Game` the game will restart, setting games played, games won, and games lost to 0. It will also
reset the user's net gain to $1000, the original starting amount.

&emsp; If the user selects `Save Game` the game will save the user data to `src\saveGameData.txt`. First saving the net gain, then the amount of games played,
followed by the amount of games won, and finally the amount of games lost.

&emsp; If the user selects `Load Game` the game will load the user data from `src\saveGameData.txt`. It will set the net gain to the first line in the .txt file.
It will then set games played, games won, and games lost to the next three lines inside the .txt file.

&emsp; *Net gain has to be a double. Games played, won, and lost have to be integers.*

##Installation##
&emsp; After cloning or unzipping the files, navigate to the `src` folder and run the following command in command line: `javac VideoPoker.java`.
This will compile all required files to let the program run. After everything has been compiled run the following command in command line: `java VideoPoker`.
Upon running the previous command, you will be greeted by the GUI containing the video poker game.

##Playing the Game##
&emsp; After pulling up the GUI, the user is ready to play! First off, the user should place a bet either by clicking the buttons on the left side, or by placing their own
bet in the middle. 

*The user can not bet more than $500 or the user's net gain if the user has less than $500. The user can also not bet less than $10.*
![Imgur](http://i.imgur.com/EsF8iYV.png)

&emsp; Once the user has chosen a bet, the user will click on the `DEAL` button to deal a hand to the user and the program will also
highlight the potential rewards the user can win.

![Imgur](http://i.imgur.com/cDsvaSq.png)

&emsp; The user will then select the cards they will keep and press the `HOLD` button. If the user does not have a winning hand, a dialog box will pop-up to let the user
know there are no winning hands.

![Imgur](http://i.imgur.com/NmZzlMP.png)

&emsp; If the user won with a hand, a dialog box will pop-up to alert the user about the hand that matched and the payout the user will receive.


&emsp; The game will end when the user has less than the minimum amount of betting money left.

![Imgur](http://i.imgur.com/3g1qZf6.png)

##Acknowledgements##
Credit is shared between Jonathan Hosler, Joshua Hester, and Vincent McAffrey. 