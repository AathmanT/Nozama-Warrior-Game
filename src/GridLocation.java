import java.util.Observable;

public class GridLocation extends Observable{
	int x;
	int y;
	Fish f;
	Warrior w;
	TreasureChest t;
	Lotus l;
	boolean locationAvailable=true;
	
	public GridLocation(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	public void addInhabitant(Inhabitant i){
		if (i instanceof Fish){
			f=(Fish)i;
		}
		else if(i instanceof Warrior){
			if(w==null && ((Warrior)i).alive){
				w=(Warrior)i;
				System.out.printf("%s swam to (%d,%d)\n",w.name,x,y);
				notifyCheck();
				locationAvailable=false;
			}
		
		}
		
	}
	
	public void notifyTheFish(){
		if(f instanceof KillerFish){
			((KillerFish)f).killWarrior(w);
			
		}else if(f instanceof InnocentFish){
			
		}else if(f instanceof RubberEatingFish){
			((RubberEatingFish)f).eatFins(w);
		}
	}
	
	public void notifyTheTreasureChest(Warrior w){
		((TreasureChest)t).notifyWarriors(w);
	}
	
	public void notifyCheck(){
	
		if(f!=null){
			notifyTheFish();
		}
		else if(t!=null){
			notifyTheTreasureChest(w);
		}
	}
	
	
}
