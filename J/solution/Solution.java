import java.util.Arrays;
import java.util.Scanner;

public class Main{
	static int ans = Integer.MAX_VALUE;

	static int[][] path;
	static int[][][] track;

	public static void floyd(int[][] times) {
		
		int n=times.length;
		
		for(int k=0;k<n;k++)
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					if(times[i][j] > times[i][k]+times[k][j]) {
						path[i][j] = k;
						times[i][j] = times[i][k] + times[k][j];
					}
		
		tracking();
	}
	public static void tracking() {
		int n = track.length;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)	
				if(i!=j) {
					track[i][j][j] += 1;
					_tracking(i,j,i,j);
				}
	}
	public static void _tracking(int i, int j, int s, int e) {
		if(path[s][e] != -1) {
			_tracking(i,j,s,path[s][e]);
			track[i][j][path[s][e]] += 1;
			_tracking(i,j,path[s][e],e);
			
		}
	}
	
	public static int solve(int n, int s,int[][] times) {
		path = new int[n][n];
		track = new int[n][n][n];
		
		for(int i=0;i<n;i++)
			Arrays.fill(path[i], -1);
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				Arrays.fill(track[i][j], 0);
		
		floyd(times);

	
		int[] visit = new int[n];
		for(int i=0;i<n;i++) visit[i] = 0;
		visit[s]++;
		bfs(n,s,times,visit,0);
		return ans;
	}
	
	public static void bfs(int n, int s, int[][] times, int[] visit, int time) {
		int det = 0;
		for(int i=0;i<n;i++) if(visit[i] != 0) ++det;
		if (det == n && time < ans) ans = time;
		
		for(int i=0;i<n;i++) {
			if(i==s || visit[i] != 0) continue;
			for(int k=0;k<n;k++)
				visit[k] += track[s][i][k];
			bfs(n,i,times,visit,time+times[s][i]);
			for(int k=0;k<n;k++)
				visit[k] -= track[s][i][k];
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int s = scan.nextInt();
		int[][] times = new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				times[i][j] = scan.nextInt();
		
		int det = solve(n, s, times);
		System.out.println(det);
		scan.close();
	}
}