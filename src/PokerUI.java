import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;

public class PokerUI extends JPanel implements ActionListener{
	private JToggleButton[] cardSlot;
	private Card[] cards;
	private JButton minBet, maxBet, deal, hold;
	private Player player;
	private JLabel[][] payoutLabel;
	private JLabel winNum, loseNum, netGain, numPlayed;
	private int gamesPlayed=0;
	private int gamesWon=0;
	private int gamesLost=0;
	private double netProfit=1000;
	private double bet=10.0;
	private boolean betLocked=false;
	private String handString = new String("");
	
	private JTextField betField;
	private final double MIN_BET = 10.00;
	private final double MAX_BET = 500.00;
	
	
	
	public PokerUI(){
		player=new Player();
		setLayout(new GridLayout(3,1));
		
	
		//payout info pane
		JPanel payoutPane = new JPanel(new GridLayout(9, 6));
		
		payoutLabel = new JLabel[9][6];
		//######
		payoutLabel[0][0]=new JLabel(" Royal Flush");
		payoutPane.add(payoutLabel[0][0]);
		int pay1=250;
		for(int i=1;i<5;i++){
			
			payoutLabel[0][i]=new JLabel(String.valueOf(pay1*i));
			payoutPane.add(payoutLabel[0][i]);
		}
		//maximum awesomeness
		payoutLabel[0][5]=new JLabel(String.valueOf(pay1*16));
		payoutPane.add(payoutLabel[0][5]);
		//######
		payoutLabel[1][0]=new JLabel(" Straight Flush");
		payoutPane.add(payoutLabel[1][0]);
		pay1=50;
		int j=6;
		for(int i=1;i<j;i++){
			
			payoutLabel[1][i]=new JLabel(String.valueOf(pay1*i));
			payoutPane.add(payoutLabel[1][i]);
		}
		//######
		payoutLabel[2][0]=new JLabel(" 4 of a Kind");
		payoutPane.add(payoutLabel[2][0]);
		pay1=25;
		for(int i=1;i<j;i++){
			
			payoutLabel[2][i]=new JLabel(String.valueOf(pay1*i));
			payoutPane.add(payoutLabel[2][i]);
		}
		//######
		payoutLabel[3][0]=new JLabel(" Full House");
		payoutPane.add(payoutLabel[3][0]);
		pay1=9;
		for(int i=1;i<j;i++){
			
			payoutLabel[3][i]=new JLabel(String.valueOf(pay1*i));
			payoutPane.add(payoutLabel[3][i]);
		}
		//######
		payoutLabel[4][0]=new JLabel(" Flush");
		payoutPane.add(payoutLabel[4][0]);
		pay1=6;
		for(int i=1;i<j;i++){
			
			payoutLabel[4][i]=new JLabel(String.valueOf(pay1*i));
			payoutPane.add(payoutLabel[4][i]);
		}
		//######
		payoutLabel[5][0]=new JLabel(" Straight");
		payoutPane.add(payoutLabel[5][0]);
		pay1=6;
		for(int i=1;i<j;i++){
			
			payoutLabel[5][i]=new JLabel(String.valueOf(pay1*i));
			payoutPane.add(payoutLabel[5][i]);
		}
		//######
		payoutLabel[6][0]=new JLabel(" 3 of a Kind");
		payoutPane.add(payoutLabel[6][0]);
		pay1=3;
		for(int i=1;i<j;i++){
			
			payoutLabel[6][i]=new JLabel(String.valueOf(pay1*i));
			payoutPane.add(payoutLabel[6][i]);
		}
		//######
		payoutLabel[7][0]=new JLabel(" Two Pair");
		payoutPane.add(payoutLabel[7][0]);
		pay1=2;
		for(int i=1;i<j;i++){
			
			payoutLabel[7][i]=new JLabel(String.valueOf(pay1*i));
			payoutPane.add(payoutLabel[7][i]);
		}
		//######
		payoutLabel[8][0]=new JLabel(" Jacks or Better  ");
		payoutPane.add(payoutLabel[8][0]);
		pay1=1;
		for(int i=1;i<j;i++){
			
			payoutLabel[8][i]=new JLabel(String.valueOf(pay1*i));
			payoutPane.add(payoutLabel[8][i]);
		}
		//######
		
		//cards
		JPanel cardSlotPane = new JPanel(new GridLayout(1, 5));
		cardSlot = new JToggleButton[5];
		for(int i=0;i<5;i++){
			//initial set up
			cardSlot[i] = new JToggleButton();
			cardSlot[i].setPreferredSize(new Dimension(82, 119));
			cardSlotPane.add(cardSlot[i]);
		}
		//instantiate blank cards
		resetCards();
		
		
		//buttons
		JPanel buttonPane = new JPanel(new GridLayout(1,4));
		JPanel betBPane = new JPanel(new GridLayout(2, 1));
		minBet = new JButton("Min Bet: $10.00");
		minBet.addActionListener(this);
		maxBet = new JButton("Max Bet: $500.00");
		maxBet.addActionListener(this);
		betBPane.add(minBet);
		betBPane.add(maxBet);
		
		//bet things
		JPanel dealBPane = new JPanel(new GridLayout(2, 1));
		JPanel betPane = new JPanel(new GridLayout(1, 2));
		betPane.add(new JLabel("Bet: "));
		betField = new JTextField(String.valueOf(bet));
		betPane.add(betField);
		dealBPane.add(betField);
		
		JPanel deal2Pane = new JPanel(new GridLayout(1, 2));
		hold = new JButton("HOLD");
		hold.addActionListener(this);
		deal2Pane.add(hold);
		
		deal = new JButton("DEAL");
		deal.addActionListener(this);
		deal2Pane.add(deal);
		
		dealBPane.add(deal2Pane);
		//games stats
		JPanel statsPane = new JPanel(new GridLayout(2, 2));
		JPanel gamesPane = new JPanel(new GridLayout(1, 2));
		gamesPane.add(new JLabel("Games Played: "));
		numPlayed = new JLabel(String.valueOf(gamesPlayed));
		gamesPane.add(numPlayed);
		
		//games won
//		JPanel gamesPane1 = new JPanel(new GridLayout(1, 2));
		JPanel gamesWonPane = new JPanel(new GridLayout(1, 2));
		gamesWonPane.add(new JLabel("Games Won: "));
		winNum = new JLabel(String.valueOf(gamesWon));
		gamesWonPane.add(winNum);
//		gamesPane1.add(gamesWonPane);
		
		//games lost
		JPanel gamesLostPane = new JPanel(new GridLayout(1, 2));
		gamesLostPane.add(new JLabel("Games Lost: "));
		loseNum = new JLabel(String.valueOf(gamesLost));
		gamesLostPane.add(loseNum);
//		gamesPane1.add(gamesLostPane);
		
		
		//net profits
		JPanel profitPane = new JPanel(new GridLayout(1, 2));
		profitPane.add(new JLabel("Net Gain: "));
		netGain = new JLabel(String.valueOf(netProfit));
		profitPane.add(netGain);
		
		statsPane.add(gamesPane);
		statsPane.add(profitPane);
		statsPane.add(gamesWonPane);
		statsPane.add(gamesLostPane);
		
		
		//add to main window
		buttonPane.add(betBPane);
		buttonPane.add(dealBPane);
		buttonPane.add(statsPane);
		add(payoutPane);
		add(cardSlotPane);
		add(buttonPane);
	}
	
	public void actionPerformed(ActionEvent a){
		
		boolean validBet;
		try{
			bet = checkBetValidity(betField.getText());
			validBet=true;
		}
		catch (NumberFormatException e){
		validBet=false;
		}
		
		
		if(validBet){
			if(a.getSource()==hold){
			//Hold will replace any held cards, check the hand for any matches, then update the games played, won, and lost, then flip the cards over.
				Card[] cards = player.genHand(keepCard(0),keepCard(1),keepCard(2),keepCard(3),keepCard(4));
				updateCards(cards);
				player.playBet(bet);
				if(CheckHand.getHand(cards) == Hands.FLOP){
					lostHand();
					hold.setEnabled(false);
					deal.setEnabled(true);
					minBet.setEnabled(true);
					maxBet.setEnabled(true);
					//synchronize stats
					gamesPlayed=player.getGamesPlayed();
					gamesWon=player.getGamesWon();
					gamesLost=player.getGamesLost();
					netProfit=player.getWinnings();
					resetCards();
				}
				if(CheckHand.getHand(cards) != Hands.FLOP){
					handToString(cards);
					wonHand();
					hold.setEnabled(false);
					deal.setEnabled(true);
					//synchronize stats
					gamesPlayed=player.getGamesPlayed();
					gamesWon=player.getGamesWon();
					gamesLost=player.getGamesLost();
					netProfit=player.getWinnings();
					resetCards();
				}
				betLocked=false;
			}
			if(a.getSource()==deal){
			//Deal will flip the cards to the faces, and generate the new hand.
				hold.setEnabled(true);
				player.setBet(bet);
				
				//get new hand
				Card[] cards = player.genHand(true,true,true,true,true);
				updateCards(cards);
				deal.setEnabled(false);
				minBet.setEnabled(false);
				maxBet.setEnabled(false);
				betLocked=true;
			}
		}
		else if(a.getSource()==hold||a.getSource()==deal){
			validBet=true;
		JOptionPane.showMessageDialog(this, 
		"Invalid bet.",
		"Error",
		JOptionPane.ERROR_MESSAGE);
		}
		//max bet
		if(a.getSource()==minBet){
			bet=MIN_BET;
		}
		//min bet
		if(a.getSource()==maxBet){
			bet=MAX_BET;
		}
		
		
		netProfit= Math.floor(netProfit * 100) / 100;
		updateLabels();
		depressButtons();
		updateBet();
		
		lockBet();
		
		if(netProfit<=0.0){commitSuicide();}
	}
	
	public void CardSet(Card card, int slot){
		BufferedImage cardImage;
		cardImage = CardImage.CardImage(card);
		ImageIcon icon = new ImageIcon(cardImage);
		cardSlot[slot].setIcon(icon);
	}
	
	public void updateLabels(){
		winNum.setText(String.valueOf(gamesWon));
		loseNum.setText(String.valueOf(gamesLost));
		netGain.setText(String.valueOf(netProfit));
		numPlayed.setText(String.valueOf(gamesPlayed));
		payoutGrid();
		lowWinnings(netProfit);
	}
	public void updateBet(){
		betField.setText(String.valueOf(bet));
	}
	
	public void depressButtons(){
		for(int i=0;i<5;i++){
			cardSlot[i].setSelected(false);
		}
	}

	public boolean keepCard(int i){
		if(cardSlot[i].isSelected())
			return false;
		else
			return true;
	}
	
	public Player getPlayer(){return player;}
	//loads a "new" player from one passed in
	public void setPlayer(Player newPlayer){
		gamesPlayed=newPlayer.getGamesPlayed();
		player.setStartingGamesPlayed(gamesPlayed);
		gamesWon=newPlayer.getGamesWon();
		player.setStartingGamesWon(gamesWon);
		gamesLost=newPlayer.getGamesLost();
		player.setStartingGamesLost(gamesLost);
		netProfit=newPlayer.getWinnings();
		player.setStartingWinnings(netProfit);
		System.out.println(netProfit);
		updateLabels();
	
	}
	
	//sets all cards to show the back face
	public void resetCards(){
		for(int i=0;i<5;i++){
			BufferedImage image = CardImage.CardBack();
			ImageIcon icon = new ImageIcon(image);
			cardSlot[i].setIcon(icon);
		}
	}
	
	public void updateCards(Card[] cards){
		for(int i=0;i<5;i++){
			BufferedImage image = CardImage.CardImage(cards[i]);
			ImageIcon icon = new ImageIcon(image);
			cardSlot[i].setIcon(icon);
		}
	}
	
	public double checkBetValidity(String bet1) throws NumberFormatException{
		double bet2;
		try{
			bet2 = Double.parseDouble(bet1);
			bet2= Math.floor(bet2 * 100) / 100;
			
		}
		catch (NumberFormatException e){
		throw new NumberFormatException();
		}
		if(bet2<10.0){throw new NumberFormatException();}
		if(bet2>500.0){throw new NumberFormatException();}
		if(bet2>player.getWinnings()){throw new NumberFormatException();}
		return bet2;
	}
	
	public void lockBet(){
		if(betLocked){
			betField.setEditable(false);
		}
		else{
			betField.setEditable(true);
		}
	}
	
	public void commitSuicide(){
		JOptionPane.showMessageDialog(this, 
		"You're out of money.",
		"Game Over",
		JOptionPane.ERROR_MESSAGE);
	}
		public void wonHand(){
		JOptionPane.showMessageDialog(this, 
		handString,
		"This hand won!",
		JOptionPane.PLAIN_MESSAGE);
	}
		public void lostHand(){
		JOptionPane.showMessageDialog(this, 
		"No matching hands.",
		"This hand lost.",
		JOptionPane.PLAIN_MESSAGE);
	}
		public void handToString(Card[] array){
		if(CheckHand.checkRoyalFlush(array)) {
			handString = "Royal Flush";
		}
		else if(CheckHand.checkStraightFlush(array)) {
			handString = "Straight Flush";
		}
		else if(CheckHand.checkFour(array)) {
			handString = "Four of a Kind";
		}
		else if(CheckHand.checkFullHouse(array)) {
			handString = "Full House";
		}
		else if(CheckHand.checkFlush(array)) {
			handString = "Flush";
		}
		else if(CheckHand.checkStraight(array) || CheckHand.checkRoyal(array)) {
			handString = "Straight";
		}
		else if(CheckHand.checkThree(array)) {
			handString = "Three of a Kind";
		}
		else if(CheckHand.checkTwoPair(array)) {
			handString = "Two Pair";
		}
		else if(CheckHand.checkPair(array)) {
			handString = "One Pair";
		}
		else {
			handString = "Flop";
		}
		handString += " with a payout of: $";
		
		handString += String.valueOf(Payout.getPayout(CheckHand.getHand(array), bet));
	}
	
	public void payoutGrid(){
		Color color = new Color(231,231,231,255);
	
		for(int i=0;i<9;i++){
			for(int j=0;j<6;j++){
				payoutLabel[i][j].setOpaque(true);
				payoutLabel[i][j].setBackground(color);
			}
		}
	
		PayoutTier pT=Payout.getPayTier(bet);
		int j = pT.getTier();
			for(int i=0;i<9;i++){
				payoutLabel[i][j].setBackground(Color.YELLOW);
			}
		
	}
	
	public void lowWinnings(double netProfit){
		if(netProfit<100.0){
			netGain.setForeground(Color.RED);
		}
		else{
			netGain.setForeground(Color.BLACK);
		}
	}
}