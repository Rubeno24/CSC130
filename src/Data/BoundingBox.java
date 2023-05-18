package Data;

public class BoundingBox {
	 private Vector2D spriteLocation;
	 private int x1, x2, y1, y2;
	 //constructor that accepts essentialy a set of cordinates we add 128 to x1 and y1 to get x2 and y2 to create a bounding box
	 public BoundingBox(Vector2D spriteLocation) {
	        this.spriteLocation = spriteLocation;
	        this.x1 = spriteLocation.getX();
	        this.x2 = spriteLocation.getX() + 128;
	        this.y1 = spriteLocation.getY();
	        this.y2 = spriteLocation.getY() + 128;
	    }
	 
	 //constructor that accepts coordinates and you decided how big you want your bounding box to be
	   public BoundingBox(Vector2D spriteLocation, int width, int height) {
	        this.spriteLocation = spriteLocation;
	        this.x1 = spriteLocation.getX();
	        this.x2 = spriteLocation.getX() + width;
	        this.y1 = spriteLocation.getY();
	        this.y2 = spriteLocation.getY() + height;
	    }
	   //standard getter methods
	   public Vector2D getSpriteLocation() {
	        return spriteLocation;
	    }

	    public int getX1() {
	        return x1;
	    }

	    public int getX2() {
	        return x2;
	    }

	    public int getY1() {
	        return y1;
	    }

	    public int getY2() {
	        return y2;
	    }



	   

	 

	  

}
