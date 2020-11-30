import java.util.Observable;
import java.util.Observer;

abstract public class Fish extends Inhabitant implements Observer {

	public Fish(String s,int x, int y,Grid g){
		name = s;
		this.x = x;
		this.y = y;
		System.out.printf("%s created at (%d,%d)\n",name,x,y);
		g.gridArray[x][y].addInhabitant(this);
		registerTheGridLocation(g.gridArray[x][y]);
	}
	//making it as an observer for the grid location
	public void registerTheGridLocation(GridLocation gl){
		gl.addObserver(this);
	}
	
	//give the string representation of the object
		public String toString(){
			return name;
		}

}
