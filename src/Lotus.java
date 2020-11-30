
public class Lotus {

	int noOfPetals=100;
	String name;
	int x;
	int y;
	
	public Lotus(String s,int x,int y){
		name = s;
		this.x=x;
		this.y=y;
		System.out.printf("%s created at (%d,%d)\n",name,x,y);
	}
	//reduce no of petals if plucked
	public void plucked(){
		noOfPetals-=1;
	}
	//give the string representation of object
	public String toString(){
		return name;
	}
	
}
