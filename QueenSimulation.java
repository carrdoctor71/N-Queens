// Project 3 simulation file Ken Carr and Duncan McKay
// Objective of this program is to run and test the Queen class
// It allows user input for board size and then will output the solutions

import java.util.Scanner;  // Scanner class imported to allow user input


public class QueenSimulation  {
   public /*variables we want to reference*/
      static LinkedStack<Queen> pile;// = new LinkedStack();
      static int boardSize;
   public static void main(String [] args)   {  // start main program   
      boardSize = 16;
      boolean tryAgain=false;
   
      Scanner keyboard = new Scanner(System.in);   // allows for user input 
      System.out.println("Enter the size of the board"); // ask for size of board
         
         while(tryAgain)   {  // loops for input till input is valid
            boardSize=keyboard.nextInt(); // user input of size, must be greater than 0
            if(boardSize>0)
               tryAgain=false;
            else  {
               tryAgain=true;
               System.out.println("Enter a valid board size");
            }
               
         }  // end valid input loop
      pile = new LinkedStack<Queen>();
      Queen cursor = new Queen(1,1);
      while(cursor!=null){
         cursor = placeTheQueen(cursor);
      }
   
   }  // end main program
   public static Queen placeTheQueen(Queen that){
     if( that.getY() > boardSize ){//if the queen would fall off the board
         if(pile.size()==boardSize){
             for(int x = 0; x < pile.size(); x++){
                System.out.print(pile.itemAt(x).toString()+"|");
             }
             System.out.println();
         }
         pile.peek().setX(pile.peek().getX()+1);
         return pile.pop();
      }
      else if( that.getX() > boardSize && !pile.isEmpty()){
         pile.peek().setX(pile.peek().getX()+1);
         return pile.pop();
      }
      else if( that.getX() > boardSize && pile.isEmpty()){
         return null;
      }
      else if(!stackCheck(that)){//if the queen doesn't conflict with anything on the board, it gets placed
         pile.push(that);
         
         return new Queen(1,(pile.peek().getY()+1));
      }
      else{
         that.setX(that.getX()+1);
         return that;
      }
   }
   
   public static boolean stackCheck(Queen that){
      boolean conflicted = false;
      for(int x = 0; x < pile.size(); x++){
         if(that.conflict(pile.itemAt(x)) )//conflict returns true if the queens would attack each other, 
            conflicted = true;  
      }
      return conflicted;//FIXXXXXX
   }//end of stackCheck method  
}