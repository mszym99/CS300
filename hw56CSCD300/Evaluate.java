/*
 * Matthew Szymanski
 * 11/2/2021 
 * HW56
 * 
 */

package hw56;

import java.util.Scanner;

public class Evaluate {
	public static String infixToPost(String cur) {
		TheStack stack = new TheStack();
		String postFixExp = "";
		String ch = cur;
		
		
		for(int i = 0; i < ch.length(); i++) {
            if(ch.charAt(i) <= '9' && ch.charAt(i) >= '0') { //checks if operand
                postFixExp += ch.charAt(i);
            }
            else if(ch.charAt(i) == '(') {
                stack.push(ch.charAt(i));
            }
            else if(ch.charAt(i) == ')') {
                while((char)stack.top() != '(') {
                    postFixExp += " " + stack.pop();
                }
                stack.pop();
            }
            else {//The precedence part has been giving me a hard time been trying for hours to get it to work
                while(stack.size() != 0 && opPrecedence.getStackCur(ch.charAt(i)) > opPrecedence.getStackCur(cur.charAt(i))) {
                    stack.pop();
                    postFixExp += " " + cur;
                }
                stack.push(ch);
            }
            
            while(stack.size() != 0) {
                postFixExp += " " + stack.pop();
            }
        }
        return postFixExp;
	}
	
	public int postFixEval(char cur) throws IllegalArgumentException {
		TheStack stack = new TheStack();
		String ch = "";
		
		ch.substring(0);
		while (cur != 0) {
			
			if (cur <=9 && cur >=0) {
				stack.push(ch);
			}
			
			else {
				Object popLeft = stack.pop();
				Object popRight = stack.pop();
				//This part cant be done with object but it should look something like this if my logic is correct
				/*switch(cur - '0') {
				case '+':
					stack.push(popRight + popLeft);
				
				case '-':
					stack.push(popRight - popLeft);
					
				case '*':
					stack.push(popRight * popLeft);
				
				case '/':
					stack.push(popRight / popLeft);
					
				case '^':
					stack.push(popRight ^ popLeft);
					
				case '%':
					stack.push(popRight % popLeft);
				}*/	
				
			}
			
			
		ch.substring(1);	
		}
		
		if(stack.size() == 1) {
			stack.pop();
		}
		
		else {
			throw new IllegalArgumentException("Infix has SYNTAX ERROR!");
		}
		return -1;  
	   }
	public static void main(String[] args) { //moved main into evaluate because i couldnt access these methods outside of Evaluate
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter an infix expression");
        String input = kb.nextLine();
        kb.close();
        System.out.println(input);
        
        System.out.println(infixToPost(input));
        //System.out.println(postfixEval(infixToPost(input)));
        System.out.println("Done");
    }
}
