import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine()," ");
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    int[][] a = new int[n][m];                      //도화지
	    boolean[][] check = new boolean[n][m];          //마킹
	    int[] x = {0, 0, -1, 1};
	    int[] y = {1, -1, 0, 0};
	    Queue<int[]> q = new LinkedList<>();
	    
	    for(int i=0; i<n; i++){                                 //도화지 입력
	        st = new StringTokenizer(br.readLine()," ");
	        for(int j=0; j<m; j++){
	            a[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    int max = 0;
	    int num = 0;
	    
	    for(int i=0;i<n; i++){
	        for(int j=0;j<m;j++){
	            if(a[i][j] == 0) continue;              //그림인지 확인
	            if(check[i][j] == true) continue;       //이미 마킹 되어있는지 확인
	            q.offer(new int[]{i, j});
	            check[i][j] = true;
	            num++;
	            int mx = 1;
	            while(!q.isEmpty()){
	                int qx = q.peek()[0];
	                int qy = q.peek()[1];
	                q.poll();
	                for(int k=0; k<4;k++){
	                    int px = qx+x[k];
	                    int py = qy+y[k];
	                    if(px<0 || py<0 || px >= n || py >= m || a[px][py] == 0 || check[px][py] == true) continue;
	                    q.offer(new int[]{px, py});
	                    check[px][py] = true;
	                    mx++;
	                }
	            }
	            if(mx > max) max = mx;
	        }
	    }
	    System.out.println(num);
	    System.out.println(max);
	}
}