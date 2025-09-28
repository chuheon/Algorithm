// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int m = Integer.parseInt(st.nextToken());
	    int n = Integer.parseInt(st.nextToken());
	    
	    Queue<int[]> q = new LinkedList<>();
	    int[][] map = new int[n][m];
	    int[][] check = new int[n][m];
	    int[][] distance = new int[n][m];
	    int[] dx = {0,0,-1,1};
	    int[] dy = {1,-1,0,0};
	    
	    for(int i=0; i<n;i++){                         //맵 입력
	        StringTokenizer stt = new StringTokenizer(br.readLine());
	        for(int j=0;j<m;j++){
	            map[i][j] = Integer.parseInt(stt.nextToken());
	        }
	    }

	    for(int i=0;i< n;i++){                         //check에 토마토가 없는곳 미리 -1 표시
	        for(int j=0;j<m;j++){
	            if(map[i][j] == -1) check[i][j] = -1;
	        }
	    }
	    
	    for(int i=0;i< n;i++){                      //처음 시작점들 마킹
	        for(int j=0;j<m;j++){
	            if(map[i][j] == 1){
	                q.offer(new int[]{i,j});
	                check[i][j] = 1;
	            }
	        }
	    }
	    
	    while(!q.isEmpty()){
	        int px = q.peek()[0];
	        int py = q.peek()[1];
	        q.poll();
	        for(int i=0;i<4;i++){
	            int qx = px + dx[i];
	            int qy = py + dy[i];
	            if(qx<0 || qy<0 || qx>=n || qy>=m || check[qx][qy] == 1 || map[qx][qy] == -1) continue;
	            check[qx][qy] = 1;
	            distance[qx][qy] = distance[px][py] + 1;
	            q.offer(new int[]{qx, qy});
	        }
	    }
	    int max = 0;
	    outer:
	    for(int i=0;i< n;i++){
	        for(int j=0;j<m;j++){
	            if(check[i][j] == 0) {
	                max = -1;
	                break outer;
	            }
	            if(distance[i][j] > max) max = distance[i][j];
	        }
	    }
	    System.out.println(max);
	}
}