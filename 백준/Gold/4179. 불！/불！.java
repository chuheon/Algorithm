// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int R = Integer.parseInt(st.nextToken());
	    int C = Integer.parseInt(st.nextToken());
	    char[][] map = new char[R][C];
	    int[][] jcheck = new int[R][C];
	    boolean[][] fcheck = new boolean[R][C];
	    int[][] jdist = new int[R][C];
	    int[][] fdist = new int[R][C];
	    Queue<int[]> qj = new LinkedList<>();
	    Queue<int[]> qf = new LinkedList<>();
	    int[] dx = {0,0,-1,1};
	    int[] dy = {1,-1,0,0};
	    
	    for(int i=0;i<R;i++){           // map 입력
	        String s = br.readLine();
	        char[] a = s.toCharArray();
	        for(int j=0;j<C;j++){
	            map[i][j] = a[j];
	            if(map[i][j] == '#' || map[i][j] == 'F'){
	                jcheck[i][j] = -1;        //벽, 불 체크
	                fcheck[i][j] = true;
	            }
	            if(map[i][j] == 'J'){                           //j 큐에 넣기
	                qj.offer(new int[]{i,j});
	                jcheck[i][j] = 1;
	            }
	            if(map[i][j] == 'F'){                           //f 큐에 넣기
	                qf.offer(new int[]{i,j});
	            }
	        }
	    }
	    
	    while(!qj.isEmpty()){
	        int px = qj.peek()[0];
	        int py = qj.peek()[1];
	        qj.poll();
	        for(int i=0;i<4;i++){
	            int qx = px + dx[i];
	            int qy = py + dy[i];
	            if(qx<0 || qy<0 || qx>=R || qy>= C || jcheck[qx][qy] == 1 || jcheck[qx][qy] == -1) continue;
	            jcheck[qx][qy] = 1;
	            jdist[qx][qy] = jdist[px][py] + 1;
	            qj.offer(new int[]{qx,qy});
	        }
	    }
	    
	    while(!qf.isEmpty()){
	        int px = qf.peek()[0];
	        int py = qf.peek()[1];
	        qf.poll();
	        for(int i=0;i<4;i++){
	            int qx = px + dx[i];
	            int qy = py + dy[i];
	            if(qx<0 || qy<0 || qx>=R || qy>= C || fcheck[qx][qy] == true) continue;
	            fcheck[qx][qy] = true;
	            fdist[qx][qy] = fdist[px][py] + 1;
	            qf.offer(new int[]{qx,qy});
	        }
	    }
	    int min = 1000002;
	    boolean b = false;
	    for(int i=0;i<R;i++){
	        for(int j=0;j<C;j++){
	            if(i==0 || i==R-1 || j==0 || j==C-1){
	                if(jcheck[i][j] == 1 && (jdist[i][j] < fdist[i][j] && fcheck[i][j] || !fcheck[i][j])){
	                    b = true;
	                    if(jdist[i][j]+1 < min){
	                        min = jdist[i][j] +1;
	                    }
	                }
	            }
	        }
	    }
	    if(b == true){
	        System.out.println(min);
	    }else{
	        System.out.println("IMPOSSIBLE");
	    }
	}
}