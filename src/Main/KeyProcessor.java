/* This will handle the "Hot Key" system. */

package Main;

import logic.Control;
import timer.stopWatchX;

public class KeyProcessor{
	
	private static char last = ' ';			
	private static char lastKey = ' ';
	private static String spriteInfo = "";
	private static int count = 0;
	private static stopWatchX sw = new stopWatchX(250);
	
	
	public static void processKey(char key){
		if(key == ' ')				return;
		// Debounce routine below...
		if(key == last)
			if(sw.isTimeUp() == false)			return;
		last = key;
		sw.resetWatch();
		//resets the text so its not on the screen at all times
		Main.ringText = "";
		Main.houseText = ""; 
		Main.houseText1 = ""; 
		Main.ballText = ""; 
		
		
		
		/* TODO: You can modify values below here! */
		switch(key){
		case '%':								// ESC key
			System.exit(0);
			break;
		
		//
		case '$':
			lastKey = '$';
			//if the space key is pressed and our characters bounding box is coliding or near coliding ringCheck will be true
			boolean ringCheck = ((Main.displayCharacter.getBoundingBox().getY1() - Main.ringBoundry.getY2() < 30) && Main.displayCharacter.getBoundingBox().getX1() > Main.ringBoundry.getX1() && Main.displayCharacter.getBoundingBox().getX1() < Main.ringBoundry.getX2());
			if (ringCheck  == true) {
				//will only execute if ringCheck is true and ring text will be assigned this line of text to be displayed in the main file
				Main.ringText = "LeBron's 5th Ring is on the floor. I should take it to his house."; 
			}

			//Same goes for the 2 houses and the ball. If they bounding boxes colide and the player press the space buttton
			//Its corresponding line of text will execute
			boolean houseCheck = ((Main.displayCharacter.getBoundingBox().getY1()  - Main.RighthouseBoundry.getY2() < 30) && Main.displayCharacter.getBoundingBox().getX1() > Main.RighthouseBoundry.getX1() && Main.displayCharacter.getBoundingBox().getX1() < Main.RighthouseBoundry.getX2());
			if (houseCheck  == true) {
				Main.houseText = "This house is way too small it belongs to Michael Jordan"; 
			}


			boolean houseCheck1 = ((Main.displayCharacter.getBoundingBox().getY1()  - Main.LefthouseBoundry.getY2() < 30) && Main.displayCharacter.getBoundingBox().getX1() > Main.LefthouseBoundry.getX1() && Main.displayCharacter.getBoundingBox().getX1() < Main.LefthouseBoundry.getX2() );
			if (houseCheck1  == true) {
				Main.houseText1 = "Lebron does not seem to be home. He is destroying the Warriors."; 
			}

			boolean ballCheck = ((Main.displayCharacter.getBoundingBox().getY1()  - Main.ballBoundry.getY2() < 30) && Main.displayCharacter.getBoundingBox().getX1() > Main.ballBoundry.getX1() && Main.displayCharacter.getBoundingBox().getX1() < Main.ballBoundry.getX2() );
			if (ballCheck  == true) {
				Main.ballText = "Someone left a basketball I should take it to Lebrons House"; 
			}

			
			break;
		//if w,a,s,d are pressed we will assign lastkey with whatever key is pressed, we will then call our moveSprite method and 
		//pass in the name of the direction which corresponds to the name of the sprite and the respective direction that we will move in
		case 'a':
			lastKey = 'a';
			spriteInfo = "left";
			moveSprite(spriteInfo, -30, 0, key);
			break; 
		case 'w':
			lastKey = 'w';
			spriteInfo = "up";
			moveSprite(spriteInfo, 0, -30, key);
			break; 
		case 's':
			lastKey = 's';
			spriteInfo = "down";
			moveSprite(spriteInfo, 0, 30, key);
			break; 
		case 'd':
			lastKey = 'd';
			spriteInfo = "right";
			moveSprite(spriteInfo, 30, 0, key);
			break; 
		case 'm':
			// For mouse coordinates
			Control.isMouseCoordsDisplayed = !Control.isMouseCoordsDisplayed;
			break;
			
			
		}
		
	}
	private static void moveSprite(String spriteInfo, int countX, int countY, char key) {
		// if the key pressed is equal to last key were going to increase our count untill its greater than 4
		// if its not greater than 4 we are going to append that number to the direction that corresponds with
		// a sprite tag, for example count is 3 and the spirte tag is left that would be left3 which is the name of a spritetag
		if (key == lastKey) {
			count++;
			if (count >= 4) {
				count = 0;
			}
			Main.displayCharacter.setTag(spriteInfo + count);
		} else {
			count = 0;
			Main.displayCharacter.setTag(spriteInfo + count);
		}
		Main.displayCharacter.moveSprite(countX, countY);
	}
}