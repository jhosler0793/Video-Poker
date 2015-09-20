/************************************************************************************************************************************************************
 SaveLoad.java
 Purpose: To write and read from a text file for the intention of saving and loading game data.
*************************************************************************************************************************************************************/
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class SaveLoad {
	public static Player tempPlayer = new Player();
	//Saves the game by writing to a text file.
	public static void saveGame(Player player) {//request player
		try {
			//Get the winnings, total games played, games won, and games lost.
			double tempA = player.getWinnings();
			int tempB = player.getGamesPlayed();
			int tempC = player.getGamesWon();
			int tempD = player.getGamesLost();
			double[] paramArray = {tempA, tempB, tempC, tempD};
			//Write them to a file.
			PrintWriter writer = new PrintWriter("saveGameData.txt");
			writer.println(tempA);
			writer.println(tempB);
			writer.println(tempC);
			writer.println(tempD);

			writer.close();
		} catch (IOException e) {
			System.err.println("Problem writing to the file saveGameData.txt");
		}
	}
	//Loads the game by reading from a text file.
	public static Player loadGame(){
		Player tempPlayer = new Player();
		//Read from a file into an array.
		double[] tempArr = new double[4];
		try{
		Scanner scan = new Scanner(new File("saveGameData.txt"));
		int count = 0;
		while(scan.hasNextDouble()){
			tempArr[count] = scan.nextDouble();
			count++;
		}
		//Set the winnings, games played, games won, and games lost.
		tempPlayer.setStartingWinnings(tempArr[0]);
		tempPlayer.setStartingGamesPlayed((int)tempArr[1]);
		tempPlayer.setStartingGamesWon((int)tempArr[2]);
		tempPlayer.setStartingGamesLost((int)tempArr[3]);
		}catch (FileNotFoundException e){
			System.out.println("Problem reading from file saveGameData.txt");
		}
		return tempPlayer;
	}
}