import java.io.*;
import java.lang.Exception;
import javax.imageio.*;
import java.awt.image.BufferedImage;

public class CardImage{
	public static BufferedImage CardImage(Card card){
		String directory=CardPath(card);
		BufferedImage cardImage = null;
		try{
			cardImage=ImageIO.read(new File(directory));
		} catch (IOException e) {}
		return cardImage;
	}
	
	private static String CardPath(Card card){
		String directory="cards/"; 
		//if(card.isFlipped()){
			String suit="";
			switch(card.getSuit()){
				case HEARTS:
					suit = "hearts";
					break;
				case DIAMONDS:
					suit = "diamonds";
					break;
				case SPADES:
					suit = "spades";
					break;
				case CLUBS:
					suit = "clubs";
					break;
				default: suit="";
			}
			String face = String.valueOf(card.cardFace.getFace());
			
			
			directory=directory+suit+"_"+face+".png";
	//	}
		/*else{
			directory=directory+"back.png";
		}*/
		return directory;
	}
	
	public static BufferedImage CardBack(){
		String directory = "cards/back.png";
		BufferedImage cardImage = null;
		try{
			cardImage=ImageIO.read(new File(directory));
		} catch (IOException e) {}
		return cardImage;
	}
}