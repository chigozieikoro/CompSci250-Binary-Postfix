package stuff;

import java.util.Scanner;

public class Postfix {
	public static boolean postfixString(String eval){
		int count = 0;
		java.util.Stack<Character> stack = new java.util.Stack<Character>();
	   for(int i = 0; i < eval.length(); i++){
		   char curr = eval.charAt(i);
		
		   if(curr == '0' || curr == '1' || curr == '+' || curr == '*'){
		   if(curr == '0' || curr == '1'){
			   stack.push(curr);
			   count++;
		   }
		   
		   else if(curr == '+'){
			   count--;
			   count--;
			   count++;
			   if(count <= 0)
				   throw new IllegalStateException("Bad string");
			   char last_num = stack.pop();
			   char first_num = stack.pop();
			   char to_push;
			   if(first_num == '0' && last_num == '0'){
				   to_push = '0';
			   }
			   else{ 
				   to_push = '1'; 				 
		        }
			   stack.push(to_push);
			 
	   }
		   else{
			   count--;
			   count--;
			   count++;
			   if(count <= 0)
				   throw new IllegalStateException("Bad string");
			   char last_num = stack.pop();
			   char first_num = stack.pop();
			   char to_push;
			   if(first_num == '1' && last_num == '1'){
				   to_push = '1';
			   }
			   else{
				   to_push = '0';
			   }
			 stack.push(to_push);  
		   }
		 }
		   else{
			   throw new IllegalStateException("Invalid character parsed");
		   }
	}
	   char final_boolean = stack.pop();
	   if(!stack.isEmpty())
		   throw new IllegalStateException("Invalid Postfix");
	   if(final_boolean == '0')
		   return false;
	   else
		   return true;

	}
	public static void main(String [] args){
		//test this out, then try multiple strings
		Scanner kbd = new Scanner(System.in);
		String postfix = kbd.next();
		System.out.println(postfixString(postfix));
		kbd.close();
	}
}
