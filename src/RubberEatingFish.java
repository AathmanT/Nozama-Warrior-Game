import java.util.Observable;

public class RubberEatingFish extends Fish{

	public RubberEatingFish(String s, int x, int y, Grid g) {
		super(s, x, y, g);
		
	}



	@Override
	public void update(Observable arg0, Object arg1) {
		eatFins((Warrior)arg1);
		
	}
	
	//eat the fins of the warrior
	public void eatFins(Warrior w){
		synchronized(w){
			w.hasSwimFins=false;
			System.out.printf("%s ate %s's fins\n",name,w.name);
		}
	}
}
