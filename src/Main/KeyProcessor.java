/* This will handle the "Hot Key" system. */

package Main;

import logic.Control;
import timer.stopWatchX;

public class KeyProcessor{
	// Static Fields
	private static char last = ' ';			// For debouncing purposes
	private static char lastKey = ' ';
	private static String spriteInfo = "";
	private static int spriteMoveCount = 0;
	private static stopWatchX sw = new stopWatchX(250);
	
	
	// Static Method(s)
	public static void processKey(char key){
		if(key == ' ')				return;
		// Debounce routine below...
		if(key == last)
			if(sw.isTimeUp() == false)			return;
		last = key;
		sw.resetWatch();
		Main.ringText = "";
		Main.houseText = ""; // reset
		Main.houseText1 = ""; // reset
		Main.ballText = ""; 
		
		
		
		/* TODO: You can modify values below here! */
		switch(key){
		case '%':								// ESC key
			System.exit(0);
			break;
			
		case '$':
			lastKey = '$';
			boolean itemCheck = ((Main.showSprites.getBoundingBox().getY1()  - Main.ringBoundry.getY2() < 30) 
					&& Main.showSprites.getBoundingBox().getX1() > Main.ringBoundry.getX1() && 
					Main.showSprites.getBoundingBox().getX1() < Main.ringBoundry.getX2() );
			if (itemCheck  == true) {
				Main.ringText = "LeBron's 5th Ring is on the floor. I should take it to his house."; //TODO: diff doorbell text
			}

			boolean houseCheck = ((Main.showSprites.getBoundingBox().getY1()  - Main.houseBoundry.getY2() < 30) 
					&& Main.showSprites.getBoundingBox().getX1() > Main.houseBoundry.getX1() && 
					Main.showSprites.getBoundingBox().getX1() < Main.houseBoundry.getX2() );
			if (houseCheck  == true) {
				Main.houseText = "This house is way to small it belongs to Michael Jordan"; //TODO: diff doorbell text
			}


			boolean houseCheck1 = ((Main.showSprites.getBoundingBox().getY1()  - Main.houseBoundry1.getY2() < 30) 
					&& Main.showSprites.getBoundingBox().getX1() > Main.houseBoundry1.getX1() && 
					Main.showSprites.getBoundingBox().getX1() < Main.houseBoundry1.getX2() );
			if (houseCheck1  == true) {
				Main.houseText1 = "Lebron does not seem to be home. He is destroying the Warriors."; //TODO: diff doorbell text
			}
			boolean ballCheck = ((Main.showSprites.getBoundingBox().getY1()  - Main.ballBoundry.getY2() < 30) 
					&& Main.showSprites.getBoundingBox().getX1() > Main.ballBoundry.getX1() && 
					Main.showSprites.getBoundingBox().getX1() < Main.ballBoundry.getX2() );
			if (ballCheck  == true) {
				Main.ballText = "Someone left a basketball I should take it to Lebrons House"; //TODO: diff doorbell text
			}

			
			break;
			
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
	private static void moveSprite(String spriteInfo, int moveCountX, int moveCountY, char key) {
		if (key == lastKey) {
			spriteMoveCount++;
			if (spriteMoveCount >= 4) {
				spriteMoveCount = 0;
			}
			Main.showSprites.setTag(spriteInfo + spriteMoveCount);
		} else {
			spriteMoveCount = 0;
			Main.showSprites.setTag(spriteInfo + spriteMoveCount);
		}
		Main.showSprites.moveSprite(moveCountX, moveCountY);
	}
}