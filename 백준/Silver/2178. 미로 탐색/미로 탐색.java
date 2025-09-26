import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    
	    int[][] map = new int[n][m];
	    boolean[][] check = new boolean[n][m];
	    int[] dx = {0,0,-1,1};
	    int[] dy = {1,-1,0,0};
	    int[][] distance = new int[n][m];
	    Queue<int[]> q = new LinkedList<>();
	    
	    for(int i=0;i<n;i++){               //지도 그리기
	        String s = br.readLine();
	        char[] ch = s.toCharArray();
	        for(int j=0;j<m;j++){
	            map[i][j] = ch[j]-'0';
	        }
	    }
	    q.offer(new int[]{0,0});
	    check[0][0] = true;
	    distance[0][0] = 1;
	    int dis = 1;
	    
	    while(!q.isEmpty()){
	        int px = q.peek()[0];
	        int py = q.peek()[1];
	        q.poll();
	        
	        for(int i=0;i<4;i++){
	            int qx = px + dx[i];
	            int qy = py + dy[i];
	            if(qx<0 || qy<0 || qx>= n || qy>= m || map[qx][qy] == 0 || check[qx][qy] == true) continue;
	            q.offer(new int[]{qx, qy});
	            check[qx][qy] = true;
	            distance[qx][qy] = distance[px][py] + 1;
	        }
	    }
	    System.out.println(distance[n-1][m-1]);
	}
}