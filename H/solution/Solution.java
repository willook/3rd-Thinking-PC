import java.util.Scanner;

public class Main {
	
	public static int solve(int n, int m, String s1, String s2) {

		int INF = 1000000;
		
		int d[][] = new int[n+1][m+1];
		for(int i=1;i<n+1;i++)
			d[i][0] = INF;
		for(int j=1;j<m+1;j++) 
			d[0][j] = INF;		
		
		for(int i=1;i<n+1;i++)
			for(int j=1;j<m+1;j++) {
				int cand = Math.min(d[i-1][j],d[i][j-1]);
				cand = Math.min(cand,d[i-1][j-1]);
				d[i][j] = Math.abs(s1.charAt(i-1)-s2.charAt(j-1)) + cand;
			}

		return d[n][m];
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		scan.nextLine();
		String s1 = scan.nextLine();
		String s2 = scan.nextLine();
		int ret = solve(n,m,s1,s2);
		System.out.println(ret);
		
		scan.close();
		
	}
}
