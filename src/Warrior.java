import java.util.Observable;
import java.util.Observer;
import java.util.Random;

abstract public class Warrior extends Inhabitant implements Runnable,Observer {
	int noOfFins=0;
	volatile boolean hasSwimFins=true;
	volatile boolean immortal=false;
	volatile boolean alive=true;
	int xTemp,yTemp,time=0;
	static int noOfWarriors=0;
	volatile boolean claimed=false;
	Grid g;
	
	Random r = new Random();
	//Warrior constructor
	public Warrior(String s,int x, int y,Grid g,TreasureChest t){
		name = s;
		this.x = x;
		this.y = y;
		noOfWarriors+=1;
		this.g=g;
		System.out.printf("%s created at (%d,%d)\n",name,x,y);
		g.gridArray[x][y].addInhabitant(this);
		t.addObserver(this);
	}
	
		//gives the string representation of the class
		public String toString(){
			return name;
		}
	
	public void update(Observable theObservable, Object message) {
		claimed=true;
		
	}
	
	//moves the warrior by 1 step
		public void swim(Grid g){
			if (hasSwimFins==true && alive==true){
				int xStep = r.nextInt(2);
				int yStep = r.nextInt(2);
				xTemp=x;
				yTemp=y;
				if ((xStep ^ yStep)==1){
					if(xTemp==5){
						if(y<5){
							yTemp+=1;
						}
						else if(y>5){
							yTemp-=1;
						}
						
					}
					if(yTemp==5){
						if(x<5){
							xTemp+=1;
						}
						else if(x>5){
							xTemp-=1;
						}
					}
					if(xTemp>=0 && xTemp<5){
						if (yTemp>=0 && yTemp<5){
							xTemp+=xStep;
							yTemp+=yStep;
						}else if(yTemp>5 && yTemp<=11){
							xTemp+=xStep;
							if(yTemp!=5){
								yTemp-=yStep;
							}
						}
					}else if(xTemp>5 && xTemp<=11){
						if(yTemp>=0 && yTemp<5){
							xTemp-=xStep;
							yTemp+=yStep;
						}else if(yTemp>5 && yTemp<=11){
							xTemp-=xStep;
							yTemp-=yStep;
						}
					}
					//System.out.println(xTemp+","+yTemp);
					synchronized(g.gridArray[xTemp][yTemp]){
						if (g.gridArray[xTemp][yTemp].locationAvailable==true){
							x=xTemp;
							y=yTemp;			
							g.gridArray[x][y].addInhabitant(this);
						}else{
							if(x-xTemp==0 && y-1>=0){
								synchronized(g.gridArray[xTemp][y-1]){
									if(g.gridArray[xTemp][y-1].locationAvailable){
										x=xTemp;
										y-=1;
										g.gridArray[x][y].addInhabitant(this);
									}
								}
							}else if(x-1>=0){
								synchronized(g.gridArray[x-1][yTemp]){
									if(g.gridArray[x-1][yTemp].locationAvailable){
										y=yTemp;
										x-=1;
										g.gridArray[x][y].addInhabitant(this);
									}
								}
							}
						}
					}	
				}else{
					swim(g);
				}
			}
		}
}
