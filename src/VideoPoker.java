import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class VideoPoker extends JFrame implements ActionListener{
	private PokerUI ui;
	private JMenuItem saveGameItem, loadGameItem, newGameItem;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	
	public VideoPoker(){
		JFrame frame = new JFrame("Jacks or Better");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ui = new PokerUI();		
		frame.add(ui);
		
		//menu
		menuBar = new JMenuBar();
		//filemenu
		fileMenu = new JMenu("File");
		
		//new game
		newGameItem = new JMenuItem("New Game");
		newGameItem.addActionListener(this);
		fileMenu.add(newGameItem);
		
		//save game
		saveGameItem = new JMenuItem("Save Game");
		saveGameItem.addActionListener(this);
		fileMenu.add(saveGameItem);
	
		//load game
		loadGameItem = new JMenuItem("Load Game");
		loadGameItem.addActionListener(this);
		fileMenu.add(loadGameItem);
		menuBar.add(fileMenu);
		
		frame.setJMenuBar(menuBar);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent a){
		if(a.getSource()==newGameItem){
			resetGame();
		}
		if(a.getSource()==saveGameItem){
			SaveLoad.saveGame(ui.getPlayer());
		}
		if(a.getSource()==loadGameItem){
			ui.setPlayer(SaveLoad.loadGame());
			ui.resetCards();
		}
	}
	
	//instantiates a new player
	public void resetGame(){
		Player tempPlayer = new Player();
		ui.setPlayer(tempPlayer);
		ui.resetCards();
	}
	

	public static void main(String[] args){
		new VideoPoker();
	}
}