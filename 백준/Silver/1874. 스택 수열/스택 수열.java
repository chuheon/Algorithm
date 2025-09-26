// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    Stack<Integer> stack = new Stack<>();
	    StringBuilder sb = new StringBuilder();
	    boolean flag = true;
	    int[] arr = new int[N];
        int num = 1;
	    for(int i=0;i<N;i++){
	        arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0;i<N;i++){
	        int a = arr[i];
	        while(a >= num){
	            stack.push(num++);
	            sb.append("+\n");
	        }
	        if(!stack.isEmpty() && stack.peek() == a){
	            stack.pop();
	            sb.append("-\n");
	        }else{
                flag = false;
                break;
            }
	        
	    }
	    if(flag){
	        System.out.println(sb);
	    }else System.out.println("NO");
	}
}