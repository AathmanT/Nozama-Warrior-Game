import java.io.*;
import java.util.Date;

public class MainClass {

	public static void main(String[] args) throws Exception {
		
		Date date = new Date();
		File file =new File("Output.txt");
		file.createNewFile();
		FileWriter writer = new FileWriter(file);
		
		String y = "Game started at "+Long.toString(date.getHours())+" "+Long.toString(date.getMinutes())+" "+Long.toString(date.getSeconds())+"\r\n";
		writer.write(y);
		Grid g = new Grid();
		
		for (int i=0;i<11;i++){
			for (int j=0;j<11;j++){
				g.gridArray[i][j]=new GridLocation(i, j);
			}
		}
		
		TreasureChest t = new TreasureChest(g);
		
		g.gridArray[10][3].l=(new Lotus("lotus 1",10,3));
		g.gridArray[9][2].l=(new Lotus("lotus 2",9,2));
		g.gridArray[3][4].l=(new Lotus("lotus 3",3,4));
		g.gridArray[8][9].l=(new Lotus("lotus 4",8,9));
		g.gridArray[7][8].l=(new Lotus("lotus 5",7,8));
		System.out.println();
		
		InnocentFish if1 = new InnocentFish("InnocentFish1",3,5,g);
		InnocentFish if2 = new InnocentFish("InnocentFish2",5,3,g);
		KillerFish kf1 = new KillerFish("KillerFish1", 5,2, g);
		KillerFish kf2 = new KillerFish("KillerFish2", 6,2, g);
		RubberEatingFish rf1 = new RubberEatingFish("RubberEatingFish1", 10,3, g);
		RubberEatingFish rf2 = new RubberEatingFish("RubberEatingFish2", 9,2, g);
		System.out.println();
		
		ThreadGroup group = new ThreadGroup("ThreadGroup");
		Thread t1 =new Thread(group,new SuperWarrior("SuperWarrior1",10,2,g,t));
		Thread t2 =new Thread(group,new SuperWarrior("SuperWarrior2",10,7,g,t));
		Thread t3 =new Thread(group,new NormalWarrior("NormalWarrior1",5,0,g,t));
		Thread t4 =new Thread(group,new NormalWarrior("NormalWarrior2",7,0,g,t));
		System.out.println();
		
		long start = System.currentTimeMillis();
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		while(t.claimed==false && group.activeCount()!=0){
			
		}
		
		group.stop();
		long end = System.currentTimeMillis();
		
		
		String s = g.gridArray[5][5].w.name+" claimed the treasure chest in "+(end-start)+" milliseconds\r\n";
		String z = "Game ended at "+Long.toString(date.getHours())+" "+Long.toString(date.getMinutes())+" "+Long.toString(date.getSeconds())+"\r\n";
		
		writer.write(s);
		writer.write(z);
		writer.flush();
		writer.close();
		
		
		if(t.claimed){
			System.out.println();
			System.out.printf("%s claimed the treasure chest \n",g.gridArray[5][5].w.name);
		}
	}
}
