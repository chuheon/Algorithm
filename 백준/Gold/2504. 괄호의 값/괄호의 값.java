// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String s= br.readLine();
	    
	    Stack<String> stack = new Stack<>();
	    char[] ch = s.toCharArray();
	    int m = 1;          //곱할거 저장
	    int count = 0;      //총 합산 저장
	    char prec = '\0';           //이전 괄호 저장
	    
	    outer:
	    for(char c : ch){
	        switch(c){
	            case '(':
	                stack.push("(");
	                m = m*2;
	                prec = '(';
	                break;
	                
	            case '[':
	                stack.push("[");
	                m = m*3;
	                prec = '[';
	                break;
	                
	            case ')':
	                if(stack.isEmpty() || stack.peek().equals("[")){
	                    count = 0;
	                    break outer;
	                }
	                
	                if(!stack.isEmpty() && prec == '('){
	                    stack.pop();
	                    count = count + m;
	                    m = m/2;
	                }else{
	                    stack.pop();
	                    m = m/2;
	                }
	                prec = ')';
	                break;
	                
	            case ']':
	                if(stack.isEmpty() || stack.peek().equals("(")){
	                    count = 0;
	                    break outer;
	                }
	                
	                if(!stack.isEmpty() && prec == '['){
	                    stack.pop();
	                    count = count + m;
	                    m = m/3;
	                }else{
	                    stack.pop();
	                    m = m/3;
	                }
	                prec = ']';
	                break;
	        }
	    }
	    if(!stack.isEmpty()) count = 0;
	    System.out.println(count);
	}
}