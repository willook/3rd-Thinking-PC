import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int solve(int n, int k, int[] arr) {
		++n;
		boolean[] cand = new boolean[n];
		Arrays.fill(cand, false);
		for(int i=0;i<k;i++) 
			for(int j=arr[i];j<n;j+=arr[i]) 
				cand[j] = true;
		int sum = 0;
		for(int i=0;i<n;i++)
			sum += cand[i] ? i:0;
		return sum;
		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int k = scan.nextInt();
		int[] arr = new int[k];
		for(int i=0;i<k;i++)
			arr[i] = scan.nextInt();
		

		System.out.println(solve(n,k,arr));
	    
	    scan.close();
	}
	   
	
}
