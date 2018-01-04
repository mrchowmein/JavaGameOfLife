/*
Copyright 2017
github.com/mrchowmein
*/

import java.util.Scanner;

public class RulesOfLife {
	
	
	public static boolean emptyWorld(char[][] world){
		boolean state = true;
		for (int row = 0; row < world.length; row++) {
			for (int col = 0; col< world[0].length; col++){
				if(world[row][col]== 'X'){
					state = false;
				}
			}
  		}

  		return state;

	}


	public static void arraySwap(char[][] oldGen, char[][] newGen){

		for (int row = 0; row < oldGen.length; row++) {
			for (int col = 0; col< oldGen[0].length; col++){
				oldGen[row][col] = newGen[row][col];	
			}
  		}	

	}
	
	public static void nextGen(char[][] oldGen, char[][] newGen){

			for(int i =0; i < oldGen.length; i++){
				//System.out.println(oldGen.length);
				for(int j = 0; j < oldGen[0].length; j++){

					if(oldGen[i][j]=='X'){ //checked occupied location
						//System.out.println(oldGen[0].length);
						int sum = sumAround(oldGen, i, j);
						if(sum==3 || sum == 2){
							newGen[i][j] = 'X';
							//System.out.println(i + "" + j);
						} else {
							newGen[i][j] = '.';
							//System.out.println(i + "" + j);;
						}
					} else if (oldGen[i][j]=='.') { //check vacant position
						int sum = sumAround(oldGen, i, j);
						if (sum == 3){ 
							newGen[i][j] = 'X';
							//System.out.println(i + "" + j);;
						} else {
							newGen[i][j] = '.';
							//System.out.println(i + "" + j);;
						}
					}
				}

			}
		
	}


	public static int sumAround(char[][]g, int row, int col){
		//finds the sum around the target
		int sum = valueIn(g, row, col+1) + //right
				valueIn(g, row-1, col) + //above
				valueIn(g, row+1, col) + //below
				valueIn(g, row, col-1) + //left
				valueIn(g, row-1, col+1) + //top right
				valueIn(g, row-1, col-1) + //top left
				valueIn(g, row+1, col+1) + //botoom right
				valueIn(g, row+1, col-1); //bottom left

		return sum;


	}

	public static boolean isValid(char[][]g, int row, int col){

		return row >= 0 && row < g.length && col >=0 && col < g[0].length;
	}

	public static int valueIn(char[][]g, int row, int col){
		
		int value = 0;
		if (isValid(g, row, col)){
			if(g[row][col] == 'X'){
				value = 1;
			}
		} else {
			value = 0;
		}

		return value;
	}





	public static void printGame (char [][] inputArray, int N, int M){

		for (int row = 0; row < M; row++) {
				for (int col = 0; col< N; col++){
				
					System.out.print(inputArray[row][col]);
				}
			System.out.println();
  		}
	}


	public static int mainMenu(){
		Scanner consoleReader = new Scanner(System.in);

		boolean state = true;
		String menuSelect = "";
		int menuInt = -1;
		while (state == true){
  			System.out.println("\nWhat would you like to do next?");
	  		System.out.println("1: Next Generation");
	  		System.out.println("2: Exit the Game of Life");
			System.out.print("Please enter a number: ");
	  		menuSelect = consoleReader.nextLine();

	  		if(menuSelect.equals("2")){
	  			System.out.println("Exiting, Goodbye\n");
	  			System.exit(0);
	  		} else if(menuSelect.equals("1")){
				System.out.println("Growing... hopefully. Please wait.");
				state = false;
	  			menuInt = 1;
	  		} else {
	  			System.out.println("Invalid Selection!\n");
	  		}

  		}

		return menuInt;
	}



}
