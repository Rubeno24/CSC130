package Main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import Data.BoundingBox;
import Data.Vector2D;
import Data.spriteInfo;
import logic.Control;
import timer.stopWatchX;

public class Main{
	// Fields (Static) below...
	public static Color c = new Color(79, 52, 235);

	public static stopWatchX timer = new stopWatchX(80);
	
	public static Queue<Vector2D> vecs1 = new LinkedList<>();
	public static Queue<Vector2D> vecs2 = new LinkedList<>();
	public static Vector2D currentVec = new Vector2D(500, 0);
	
	public static int currentSpriteIndex = 0;
	public static HashMap<String, String> map = new HashMap<>();
	public static String trigger="";
	public static int xDirectionMove;
	public static int yDirectionMove;
	public static Vector2D move=new Vector2D(500, 250);
	public static char keyPressed ;
	public static String spriteInfo = "right0";
	
	public static ArrayList<spriteInfo> sprites = new ArrayList<>();
	public static Vector2D spriteCoords = new Vector2D(700,250);
	public static spriteInfo displayCharacter = new spriteInfo(spriteCoords, spriteInfo);
	private static ArrayList<BoundingBox> boundary = new ArrayList<>();
	public static Vector2D oldCoords = new Vector2D(0, 0);
	public static boolean itemCheck = true;
	public static String  ringText = "";
	public static BoundingBox ringBoundry;

	public static String  houseText = "";
	public static BoundingBox RighthouseBoundry;

	public static String  houseText1 = "";
	public static BoundingBox LefthouseBoundry;

	public static String  ballText = "";
	public static BoundingBox ballBoundry;





	


	
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start(){
		//created an ArrayList Named Boundry of type Bounding Box to hold all of our boundries 
		boundary.add(new BoundingBox(new Vector2D(-128, -128), 1400, 100)); // Top Bounding Box
		boundary.add(new BoundingBox(new Vector2D(-128, 650), 1400, 100)); // Bottom Bounding Box
		boundary.add(new BoundingBox(new Vector2D(-128, -128), 170, 800)); // // Left Bounding Box
		boundary.add(new BoundingBox(new Vector2D(1230, 100), 150, 800)); // Right Bounding Box
		boundary.add(new BoundingBox(new Vector2D(540, 587), 100, 100));// Water Bounidng Box

		RighthouseBoundry = (new BoundingBox(new Vector2D(883, 195), 150, 100));// Right House Bounding Box
		LefthouseBoundry = (new BoundingBox(new Vector2D(150, 135), 150, 100));// Left House Bounding Box		
		ringBoundry = (new BoundingBox(new Vector2D(650, 550), 65, 55)); // Ring Bounding Box
		ballBoundry= (new BoundingBox(new Vector2D(70, 550), 65, 55)); //Ball BounBounding Box

		boundary.add(ringBoundry);
		boundary.add(RighthouseBoundry);
		boundary.add(LefthouseBoundry);
		boundary.add(ballBoundry);

		sprites.add(displayCharacter);// ArrayList of type SpriteInfo to hold all of our sprites
		
			}
	
		
		// TODO: Code your starting conditions here...NOT DRAW CALLS HERE! (no addSprite or drawString)
		
	
	
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl) {
		
	
		ctrl.addSpriteToFrontBuffer(0, 0, "background"); //Displays Background Image
		ctrl.addSpriteToFrontBuffer(690, 560, "Ring"); //Displays Ring Image
		ctrl.addSpriteToFrontBuffer(120, 550, "Ball"); //Displays Ball Image
	
		//displays the player character x and y cordinates and the correct sprite depending on player input
		ctrl.addSpriteToFrontBuffer(displayCharacter.getCoords().getX(), displayCharacter.getCoords().getY(), displayCharacter.getTag());

		//displays the appropriate text based on what the user interacts with
		ctrl.drawString(350, 300, ringText, Color.RED);
		ctrl.drawString(360, 300, houseText, Color.RED);
		ctrl.drawString(360, 300, houseText1, Color.RED);
		ctrl.drawString(360, 300, ballText, Color.RED);
		
		
		for (int i = 0; i < boundary.size(); i++) {
			//the if statement executes when the collision method returns true
			if (collision(displayCharacter.getBoundingBox(), boundary.get(i)) == true) {
				//if a collision is detected the moveBack method will execute and move the player back
				moveSpriteBack();

			}
		}
	
	}

	public static void moveSpriteBack() {
		//moves the player back by assigning the previous x and y cords of the player to the current sprite
		displayCharacter.moveBack();
	}

	public static boolean collision(BoundingBox box1, BoundingBox box2) {
		//Algo from the canvas module
		if((box1.getX1() > box2.getX2()) || (box1.getX2() < box2.getX1()) ||(box1.getY1() > box2.getY2()) || (box1.getY2() < box2.getY1())){
			return false;
		}
		//returns true when there is a collision
		else
			{
			return true;
			}
		
		
	}
	
	
}
	
		
		// Add a tester sprite to render list by tag (Remove later! Test only!)
		
		// Test drawing text on screen where you want (Remove later! Test only!)
	
	
	// Additional Static methods below...(if needed)


