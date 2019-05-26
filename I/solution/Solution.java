import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int INF = 1000000;

	static int[][] length;
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,1,0,-1};
	
	static String solve(int n, int m,int[][] map) {
		length = new int[n][m];
		for (int i=0;i<n;i++) 
			Arrays.fill(length[i], INF);
		
		if(!isJaeum(map[0][0])) return "BAD";
		if(!isJaeum(map[1][0])) { 
			length[1][0] = 1;
			next(1,0,1,1,0,map);
			next(1,0,2,0,0,map);
		}
		if(!isJaeum(map[0][1])) { 
			length[0][1] = 1;
			next(0,1,1,1,0,map);
			next(0,1,0,2,0,map);
		}
		
		int ret = 0;
		if(!isJaeum(map[n-1][m-1])) ret = length[n-1][m-1];
		else ret = length[n-2][m-1] < length[n-1][m-2] ? length[n-2][m-1] : length[n-1][m-2];
		if (ret == INF) return "BAD";
		return Integer.toString(ret);
	}
	static void next(int si, int sj,int ci, int cj, int count,int[][] map) {
		
		if(ci < 0 || ci >= map.length) return;
		if(cj < 0 || cj >= map[0].length) return;
		if(count > 2) return;
		if(count == 0 && !isJaeum(map[ci][cj])) return;
		if(isJaeum(map[ci][cj])) {
			for(int k=0;k<4;k++) {
				next(si,sj,ci+di[k],cj+dj[k],count+1,map);
			}
		}
		if(!isJaeum(map[ci][cj])) {
			if(length[ci][cj] > length[si][sj]+1) {
				length[ci][cj] = length[si][sj]+1;
				for(int k=0;k<4;k++) 
					next(ci,cj,ci+di[k],cj+dj[k],0,map);
			}
			else return;
		}
	}
	
	static boolean isJaeum(int ch) {
		return (ch < 14);
	}
	static void pprint(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j] == INF)
					System.out.print("0 ");
				else
					System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] map = new int[n][m];
		for (int i=0;i<n;i++) 
			for (int j=0;j<m;j++) 
				map[i][j] = scan.nextInt();
			
		String ret = solve(n, m, map);
		System.out.println(ret);
		scan.close();
	}
}
