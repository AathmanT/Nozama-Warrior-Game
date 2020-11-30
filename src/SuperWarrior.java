
public class SuperWarrior extends Warrior{

	Binocular b;
	
	public SuperWarrior(String s, int x, int y, Grid g,TreasureChest t) {
		super(s, x, y, g,t);
	}
	
	boolean hasBinocular=true;

	
	
	
	public void run() {
		while(!claimed && alive==true && hasSwimFins==true){
			try{
				Thread.sleep(500);
			}
			catch(InterruptedException e){}
			
			if(findFlower()==false){
				swim(g);
			}
		}
		
	}	
	
		
	
	//eating lotus if possible
	public void eatLotus(int x1,int y1){
		synchronized(this){
			immortal=true;
			g.gridArray[x1][y1].l.plucked();
			g.gridArray[x1][y1].l.plucked();
			System.out.println(name+" ate a lotus petal and became immortal");
		}
	}

	//get location of flower 
	public boolean findFlower(){
		if(hasBinocular){	
			synchronized(this){
				if(alive && hasSwimFins){
					if(x+1<=10){	
						synchronized(g.gridArray[x+1][y]){
						//	if(g.gridArray[x+1][y].l!=null){
							//	System.out.println(name+" x+1<=10");
								//}
							if(g.gridArray[x+1][y].l!=null && g.gridArray[x+1][y].locationAvailable){
								g.gridArray[x+1][y].addInhabitant(this);
								eatLotus(x+1,y);
								return true;
							}
						}
					}
					if(y+1<=10){
						synchronized(g.gridArray[x][y+1]){
							//if(g.gridArray[x][y+1].l!=null){
							//System.out.println(name+" y+1<=10");
							//}
							if(g.gridArray[x][y+1].l!=null && g.gridArray[x][y+1].locationAvailable){
								g.gridArray[x][y+1].addInhabitant(this);
								eatLotus(x,y+1);
								return true;
							}
						}
					}
					if(x-1>=0){
						synchronized(g.gridArray[x-1][y]){
						//	if(g.gridArray[x-1][y].l!=null){
							//	System.out.println(name+" x-1>=0");
								//}
							if(g.gridArray[x-1][y].l!=null && g.gridArray[x-1][y].locationAvailable){
								g.gridArray[x-1][y].addInhabitant(this);
								
								eatLotus(x-1,y);
								return true;
							}
						}
					}
					if(y-1>=0){
						synchronized(g.gridArray[x][y-1]){
					//		if(g.gridArray[x][y-1].l!=null){
						//		System.out.println(name+" y-1>=0");
							//	}
							if(g.gridArray[x][y-1].l!=null && g.gridArray[x][y-1].locationAvailable){
								g.gridArray[x][y-1].addInhabitant(this);
								
								eatLotus(x,y-1);
								return true;
							}
						}
					}
				}	
			}
		}
		return false;	
	}
}
