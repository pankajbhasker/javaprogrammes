// Java code to check balanced parenthesis  
import java.util.Stack;  
public class BalanceBracket { 
   public static boolean balParenthesis(String exp) { 
     Stack stack = new Stack();  
     for (int i = 0; i < exp.length(); i++) { 
       if (exp.charAt(i) == ‘(‘ || exp.charAt(i) == ‘{‘ || exp.charAt(i) == ‘[‘) {
         stack.push(exp.charAt(i)); 
       }  
       if (exp.charAt(i) == ‘)’ || exp.charAt(i) == ‘}’ || exp.charAt(i) == ‘]’) { 
         if (stack.empty()) { return false; }  Character top = stack.pop();  
         if ((top == ‘(‘ && exp.charAt(i) != ‘)’) || (top == ‘{‘ && exp.charAt(i) != ‘}’) || (top == ‘[‘ && exp.charAt(i) != ‘]’)) 
         {  
           return false; 
         } 
       } 
    }  return stack.empty(); 
  }  
                              
public static void main(String[] args) { 
  String exp = “{()}[{}]”;  
  if (balParenthesis(exp)) { 
    System.out.println(“The expression is balanced”); 
  } 
  else 
  { 
    System.out.println(“The expression is not balanced”); 
  } 
 } 
}
