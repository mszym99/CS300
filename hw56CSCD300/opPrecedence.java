/*
 * Matthew Szymanski
 * 11/2/2021 
 * HW56
 * 
 */
package hw56;

public class opPrecedence {
	public static int getPreCur(char cur) {
	      if (cur == '(') { //implementing the data table for precedence from class.
	         return 100;
	         }
	      else if(cur == ')') {
	         return 0;
	      }
	      else if(cur == '^') {
	         return 6;
	      }
	      else if(cur == '*') {
	         return 3;
	      }
	      else if(cur == '/') {
	         return 3;
	      }
	      else if(cur == '%') {
	         return 3;
	      }
	      else if(cur == '+') {
	         return 1;
	      }
	      else if(cur == '-') {
	         return 1;
	      }
	      return 0;
	      
	   }
	    
	   public static int getStackCur(char cur) {
	      if (cur == '(') { //implementing the data table for precedence from class.
	         return 0;
	         }
	      else if(cur == ')') {
	         return -1;
	      }
	      else if(cur == '^') {
	         return 5;
	      }
	      else if(cur == '*') {
	         return 4;
	      }
	      else if(cur == '/') {
	         return 4;
	      }
	      else if(cur == '%') {
	         return 2;
	      }
	      else if(cur == '+') {
	         return 2;
	      }
	      else if(cur == '-') {
	         return 1;
	      }
	      return 0;
	   } 
}
