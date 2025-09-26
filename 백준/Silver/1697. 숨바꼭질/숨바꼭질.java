// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    int[] max = new int[100001];
	    boolean[] check = new boolean[100001];
	    int[] time = new int[100001];
	    Queue<Integer> q = new LinkedList<>();
	    check[N] = true;
	    q.offer(N);
	    int min = 0;
	    
	    flag:
	    while(!q.isEmpty()){
	        int qx = q.peek();
	        q.poll();
	        for(int i=0;i<3;i++){
	            int px;
	            switch(i){
	                case 0:
	                    if(qx-1<0 || qx-1>100000 || check[qx-1] == true) continue;
	                    px = qx-1;
	                    q.offer(px);
	                    check[px] = true;
	                    time[px] = time[qx] +1;
	                    if(px == K){
	                        min = time[px];
	                        break flag;
	                    }
	                    break;
	                case 1:
	                    if(qx+1<0 || qx+1>100000 || check[qx+1] == true) continue;
	                    px = qx+1;
	                    q.offer(px);
	                    check[px] = true;
	                    time[px] = time[qx] +1;
	                    if(px == K){
	                        min = time[px];
	                        break flag;
	                    }
	                    break;
	                case 2:
	                    if(qx*2<0 || qx*2>100000 || check[qx*2] == true) continue;
	                    px = qx*2;
	                    q.offer(px);
	                    check[px] = true;
	                    time[px] = time[qx] +1;
	                    if(px == K){
	                        min = time[px];
	                        break flag;
	                    }
	                    break;
	            }
	        }
	    }
	    System.out.println(min);
	}
}