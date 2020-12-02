package frogHighscore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import frogActor.Animal;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Highscore{

	public void highcore(){
	}
	private ArrayList<Integer> scorearr = new ArrayList<Integer>();
	
	public void setScore(int point) throws IOException{		
				
		for(int i=0;i<10;i++) {
			
			scorearr.add(0);
		}
	File scorefile = new File ("src/frogHighscore/hscore.txt");	
	Scanner scanner = new Scanner(scorefile);
		
		try {
			
			while(scanner.hasNextLine()) {
				String scorestr =scanner.nextLine();
				scorearr.add(Integer.parseInt (scorestr));				
			}
				
			} catch(Exception e) {				
				e.printStackTrace();
			}
			scanner.close();			
			if (scorearr.size()>=10) {
				if(point>=scorearr.get(9)) { 
						scorearr.add(point);
						scorearr.remove(9);
				}			
			}else {				
				scorearr.add(point);			
			}
			Collections.sort(scorearr,Collections.reverseOrder());	
			
			FileWriter file = new FileWriter(scorefile);
			BufferedWriter buffer = new BufferedWriter(file);
			PrintWriter writer = new PrintWriter(buffer);{
		
			
			for(int i=0;i<scorearr.size();i++) {
				writer.println(scorearr.get(i));
				
			}
			writer.close();
			
	}
}
	
	public String display(ArrayList<Integer> array) {
		
			String sortedscore = new String("Highscore\n1." + array.get(0)+ "\n2." +array.get(1)+ "\n3." +array.get(2)+ "\n4." +array.get(3) +"\n5." +array.get(4)+ "\n6." +array.get(5) +"\n7." +array.get(6)+ "\n8." +array.get(7) +"\n9." +array.get(8)+ "\n10." +array.get(9));
			return sortedscore;
			//System.out.println(scorearr.get(i));
	
	
}

	
	public void getScore() {
		
		try {
			BufferedReader br = null;
			FileReader fr = null;
			fr = new FileReader("highscore.txt");
			br = new BufferedReader(fr);
			String curline="";
			Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("You Have Won The Game!");
			
        		alert.setHeaderText(display(scorearr));
			
        		alert.setContentText("Highest Possible Score: 800");
        		alert.show();				
			} catch(Exception e) {
				
				e.printStackTrace();
			}
			
		}
	
}

	


	
	
	
	

