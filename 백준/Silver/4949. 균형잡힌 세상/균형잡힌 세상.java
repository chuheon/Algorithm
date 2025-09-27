// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
    
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    Stack<String> stack = new Stack<>();
	    StringBuilder sb = new StringBuilder();
	    String s;
	    
	    while((s = br.readLine()) != null){
	        if(s.equals(".")) break;
	        boolean b = true;
	        char[] ch = s.toCharArray();
	        for(char x : ch){
	            
	            
	            if(x == '(') stack.push("(");
	            if(x == '{') stack.push("{");
	            if(x == '[') stack.push("[");
	            
	            if(x == ')'){
	                if(!stack.isEmpty() && stack.peek().equals("(")){
	                    stack.pop();
	                }else{
	                    sb.append("no\n");
	                    b = false;
	                    break;
	                }
	            }
	            if(x == '}'){
	                if(!stack.isEmpty() && stack.peek().equals("{")){
	                    stack.pop();
	                }else{
	                    sb.append("no\n");
	                    b = false;
	                    break;
	                }
	            }
	            if(x == ']'){
	                if(!stack.isEmpty() && stack.peek().equals("[")){
	                    stack.pop();
	                }else{
	                    sb.append("no\n");
	                    b = false;
	                    break;
	                }
	            }
	        }
	        if(b){
	            if(stack.isEmpty()) sb.append("yes\n");
	            else sb.append("no\n");
	        }
	        stack.clear();
	    }
	    System.out.println(sb);
	}
}