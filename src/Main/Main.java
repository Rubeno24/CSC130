package Main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import Data.BoundingBox;
import Data.Vector2D;
import Data.spriteInfo;
import FileIO.EZFileRead;
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
	public static Vector2D spriteCoords = new Vector2D(250,250);
	public static spriteInfo spriteRender = new spriteInfo(spriteCoords, spriteInfo);
	private static ArrayList<BoundingBox> bounds = new ArrayList<>();
	public static Vector2D oldCoords = new Vector2D(0, 0);



	


	
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start(){
		
		bounds.add(new BoundingBox(new Vector2D(-128, -128), 1400, 100)); // TOP Boundary
		bounds.add(new BoundingBox(new Vector2D(-128, 720), 1400, 100)); // BOTTOM Boundary
		bounds.add(new BoundingBox(new Vector2D(-128, -128), 170, 800)); // LEFT Boundary
		bounds.add(new BoundingBox(new Vector2D(1280, -128), 150, 800)); // RIGHT Boundary
		sprites.add(spriteRender);
		
			}
	
		
		

		
		// TODO: Code your starting conditions here...NOT DRAW CALLS HERE! (no addSprite or drawString)
		
	
	
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl) {
		
		oldCoords = spriteRender.getCoords();
		ctrl.addSpriteToFrontBuffer(0, 0, "background");
	
		ctrl.addSpriteToFrontBuffer(spriteRender.getCoords().getX(), spriteRender.getCoords().getY(), spriteRender.getTag());
		
		for (int i = 0; i < bounds.size(); i++) {
			if (checkCollision(spriteRender.getBoundingBox(), bounds.get(i))) {
				moveCharacterBack();

			}
		}
	
	}
	public static boolean checkCollision(BoundingBox box1, BoundingBox box2) {
		return !( (box1.getX1() > box2.getX2()) || (box1.getX2() < box2.getX1()) ||(box1.getY1() > box2.getY2()) || (box1.getY2() < box2.getY1()) );
	}
	public static void moveCharacterBack() {
		// spriteRender.setCoords(oldCoords);
		spriteRender.bounceBack();
	}
	
}
	
		
		// Add a tester sprite to render list by tag (Remove later! Test only!)
		
		// Test drawing text on screen where you want (Remove later! Test only!)
	
	
	// Additional Static methods below...(if needed)


