import java.util.Scanner;

public class Main {
	public static int solve(int n, int k) {
		int ret = n;
		while(n!=0) {
			ret += n/k;
			n /= k;
		}
		return ret;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		System.out.println(solve(n,k));
		scan.close();
	}
}