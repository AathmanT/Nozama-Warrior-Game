
public class NormalWarrior extends Warrior {

	public NormalWarrior(String s, int x, int y, Grid g,TreasureChest t) {
		super(s, x, y, g,t);
		// TODO Auto-generated constructor stub
	}
	
	//This method is responsible for the behavior of the thread
	@Override
	public void run() {
		try{
			Thread.sleep(600);
		}
		catch(InterruptedException e){}
		while(!claimed && alive==true && hasSwimFins==true){
			swim(g);
			eatLotus();
		}
		
	}

	
	public void eatLotus() {
		if(g.gridArray[x][y].l!=null){
			immortal=true;
			g.gridArray[x][y].l.plucked();
			System.out.println(name+" ate a lotus petal and became immortal");
		}
		
	}

}
