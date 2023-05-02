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
		Main.itemText = ""; // reset
		
		
		/* TODO: You can modify values below here! */
		switch(key){
		case '%':								// ESC key
			System.exit(0);
			break;
			
		case '$':
			lastKey = '$';
			boolean itemCheck = ((Main.showSprites.getBoundingBox().getY1()  - Main.itemBoundry.getY2() < 30) 
					&& Main.showSprites.getBoundingBox().getX1() > Main.itemBoundry.getX1() && 
					Main.showSprites.getBoundingBox().getX1() < Main.itemBoundry.getX2() );
			if (itemCheck ) {
				Main.itemText = "What a strange Item"; //TODO: diff doorbell text
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