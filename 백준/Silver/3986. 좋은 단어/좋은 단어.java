// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int count = 0;
	    
	    for(int i=0; i<N;i++){
	        String s = br.readLine();
	        Stack<String> stack = new Stack<>();
	        //if(s.length()%2 == 1) continue;
	        char[] ch = s.toCharArray();
	        for(int j=0;j<ch.length;j++){
	            if(stack.isEmpty() && ch[j] == 'A'){
	                stack.push("A");
	            }else if(stack.isEmpty() && ch[j] == 'B'){
	                stack.push("B");
	            }else if(!stack.isEmpty() && ch[j] == 'A'){
	                if(stack.peek().equals("A")) stack.pop();
	                else stack.push("A");
	            }else if(!stack.isEmpty() && ch[j] == 'B'){
	                if(stack.peek().equals("B")) stack.pop();
	                else stack.push("B");
	            }
	        }
	        if(stack.isEmpty()) count++;
	    }
	    System.out.println(count);
	}
}