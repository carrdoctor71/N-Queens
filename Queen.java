// Project 3 Ken Carr and Duncan McKay
// Objective of this program is to determine the possible combinations
// so that N-Queens has no conflict with the other

import java.util.EmptyStackException;
import java.util.NoSuchElementException;


// Invariant of the Queen class

public class Queen {  // start of class

   private int x, y;
      
   public Queen(int input1, int input2) {  // constructor
      x=input1;
      y=input2;
   }
   
   public String toString() {  // output value of x and y to user interface
      String output=x + "," + y;
      return output;
   }  // end toString method
   
   public boolean conflict(Queen that){  // returns true if conflict is found
      if (that == null)//there is no conflict between a single queen
         return false;
      else{
         for(int j = 0; j <= (Math.max(   this.getY()+1   ,   this.getX()+1  )); j++){
            if(      (that.getX()+j == this.getX() && that.getY()+j == this.getY())   ||    (that.getX()-j == this.getX() && that.getY()+j == this.getY())    ){
               return true;
            }
            if( this.getY()==that.getY() || this.getX()==that.getX()){
               return true;
            }
         }
         return false;
      }
   }  // end conflict method
   
   public int getX() {
      return x;
   }
   
   public int getY() {
      return y;
   }
   
   public void setX(int newX) {
      x=newX;
   }
   
   public void setY(int newY) {
      y=newY;
   }         

}  // end of Queen class