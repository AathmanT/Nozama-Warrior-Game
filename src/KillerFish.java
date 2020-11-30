import java.util.Observable;

public class KillerFish extends Fish {

	public KillerFish(String s, int x, int y, Grid g) {
		super(s, x, y, g);
	}

	
	
	//check and kill the warrior if possible
		public void killWarrior(Warrior w){
			
				if(w.immortal==false){
					w.alive=false;
					System.out.printf("%s killed %s\n",name,w.name);
				}
			
		}



	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
