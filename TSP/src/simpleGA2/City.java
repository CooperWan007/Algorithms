package simpleGA2;
/*
 * encode a city
 */
public class City {
	//coordination:x y
	int x;
	int y;
	
	//constructs a placed city randomly
	public City(){
		this.x=(int)(Math.random()*200);
		this.y=(int)(Math.random()*200);
	}
	
	//constructs a city at chosen location
	public City(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	//gets x coordinate
	public int getX() {
		return x;
	}
	
	//gets y coordinate
	public int getY() {
		return y;
	}
	
	//calculates the distance between this city and a given city
	public double distanceTo(City city){
		int xDistance=Math.abs(this.getX()-city.getX());
		int yDistance=Math.abs(this.getY()-city.getY());
		double distance=Math.sqrt(xDistance*xDistance+yDistance*yDistance);
		return distance;
	}

	@Override
	public String toString() {
		return "("+getX()+", "+getY()+")";
	}
	
}
