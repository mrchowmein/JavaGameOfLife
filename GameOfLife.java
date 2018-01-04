/*
github.com/mrchowmein
*/

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class GameOfLife {

	public static final int M = 25;
	public static final int N = 75;

	public static void main (String [] args) {

		boolean state = true;
		int menuSelect = -1;
		int genCounter = -1;
		//boolean state = true;

		char [][] oldGen = new char[M][N];
		char [][] newGen = new char[M][N];


		Scanner consoleReader = new Scanner(System.in);
		System.out.print ("Which file do you want to open? ");
		String filename = consoleReader.next();
		File file = new File(filename);
		Scanner fileReader = null;

		try { 
		   fileReader = new Scanner (file);
		}
		catch (FileNotFoundException e) {
		   System.out.print("file " + file + " does not exist");
		   System.exit(0);
		}
		
		//read file and add chars to oldGen
		for (int row = 0; row < M; row++) {
			String line = fileReader.nextLine();
				for (int col = 0; col< N; col++){
					oldGen[row][col] = line.charAt(col);
					newGen[row][col] = line.charAt(col);
					//System.out.print(oldGen[row][col]);
				}
			//System.out.println();
  		}	

  		
		

  		while (state = true){
  			
  			genCounter += 1;
  			System.out.println("\nGeneration: "+ genCounter);
  			RulesOfLife.printGame(newGen, N, M);
  			
  			menuSelect = RulesOfLife.mainMenu();
  			if(menuSelect == 1){
  				RulesOfLife.nextGen(oldGen, newGen);
  			}

  			if(RulesOfLife.emptyWorld(newGen)){
  				genCounter += 1;
	  			System.out.println("\nGeneration: "+ genCounter);
	  			RulesOfLife.printGame(newGen, N, M);

  				System.out.println("\nAlert: All lifeforms are dead. The world just ended! Goodbye forever\n");
  				System.exit(0);
  			}

  			if(Arrays.deepEquals(oldGen, newGen)){

  				System.out.println("Alert: No more successive generations possible. Exiting...\n");
  				System.exit(0);
  			}
  			

  			//System.out.println(Arrays.equals(newGen, oldGen));
  			

  			RulesOfLife.arraySwap(oldGen, newGen);


  			

  		}

		

		
  		

  		
  	} 
}
