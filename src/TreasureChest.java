import java.util.Observable;

public class TreasureChest extends Observable{
	int x=5;
	int y=5;
	boolean claimed=false; 
	Warrior winner;
	
	public TreasureChest(Grid g){
		g.gridArray[x][y].t=this;
	}
	
	//check for claim of the treasure
	public void notifyWarriors(Warrior w){
		winner=w;
		claimed=true;
		setChanged();
		notifyObservers();
	}
	
	
}