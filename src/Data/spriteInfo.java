/* This is a way to pass a sprite's key information in one entity. (x, y, tag) */

package Data;

public class spriteInfo {
	// Fields
	private Vector2D v2d;
	private String tag;
	private BoundingBox boundingBox;
	private Vector2D lastVec= new Vector2D(0, 0);
	

	// Constructor
	public spriteInfo(Vector2D v2d, String tag){
		this.v2d=v2d;
		this.tag=tag;
		this.boundingBox = new BoundingBox(v2d);
	
	}
	public Vector2D getLastVec() {
		return this.lastVec;
	}
	public BoundingBox getBoundingBox() {
		return boundingBox;
	}
	// Methods
	public String getTag(){
		return tag;
	}
	
	public Vector2D getCoords(){
		return v2d;
	}
	
	public void setTag(String newTag){
		tag=newTag;
	}
	
	public void setCoords(Vector2D newV2D){
		v2d=newV2D;
		this.boundingBox = new BoundingBox(newV2D);
		this.lastVec = v2d;
	}
	
	public void setCoords(int x, int y){
		this.lastVec = v2d;
		v2d.setX(y);
		v2d.setY(y);
		this.boundingBox = new BoundingBox(this.v2d);
		
		// TODO: Overload the setCoords method to allow another way to set the coordinates. 
		//Place the x, y integers into v2d by changing the values of v2d to hold x and y (Absolute assignment)
	}
	
	public String toString(){
		
		// TODO: Create a "toString" method to test. Assume an x, y of 100, 50 and a tag of "star", this should return: [100, 50, star]
			// Remove my placeholder code below (which is there to prevent an error) and 
		//replace it with your proper toString method with specifications above
		return "[ "+ v2d.getX()+", " +v2d.getY() +", "+ getTag() +" ]";
	}
	public void setLastVec(Vector2D lastVec) {
		this.lastVec = lastVec;
	}


	public void moveSprite(int moveCountX, int moveCountY) {
		this.lastVec.setX(this.v2d.getX());
		this.lastVec.setY(this.v2d.getY());
		this.v2d.adjustX(moveCountX);
		this.v2d.adjustY(moveCountY);
		this.boundingBox = new BoundingBox(this.v2d);
		
	}
	public void moveSpriteX(int x) {
		this.lastVec.setX(this.v2d.getX());
		this.v2d.adjustX(x);
		this.boundingBox = new BoundingBox(this.v2d);
	}
	public void moveSpriteY(int y) {
		this.lastVec.setY(this.v2d.getY());
		this.v2d.adjustY(y);
		this.boundingBox = new BoundingBox(this.v2d);
	}
	public void setBoundingBox(BoundingBox boundingBox) {
		this.boundingBox = boundingBox;
	}
	public void bounceBack() {

		this.v2d.setX(this.lastVec.getX());
		this.v2d.setY(this.lastVec.getY());
		this.boundingBox = new BoundingBox(this.v2d);
	}

	
}
