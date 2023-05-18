package Data;

public class spriteInfo {
	
	private Vector2D v2d;
	private String tag;
	private BoundingBox boundingBox;
	private Vector2D lastVec= new Vector2D(0, 0);
	

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

	//moveback method that we use when collision is detected. I created a new Vector2d object to hold the previous coordinates
	//just in case we want to move our character back is collison is dectected
	public void moveBack() {
		this.v2d.setX(this.lastVec.getX());
		this.v2d.setY(this.lastVec.getY());
		
	}

	
}
