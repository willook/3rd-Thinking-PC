import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static long[] DP = new long[51];
	static long MAX = 10_0000_0007;
	static long solve(int n) { 
		if (n < 2) 
		    return 1;
		if (DP[n] == 0) 
			DP[n] = (solve(n-2) + solve(n-1) + 1) % MAX;
		return DP[n];
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Arrays.fill(DP, 0);
		long ret = solve(n);
		System.out.println(ret);
		
		scan.close();
		
	}
}