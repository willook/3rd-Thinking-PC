import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char int2char(int x) {
		if (x==0)
			return ' ';
		if (x<27) 
			return (char)(x-1+(int)'A');
		return (char)(x-27+(int)'a');
	}
	static int char2int(char ch) {
		if(ch == ' ')
			return 0;
		if(ch <= 'Z')
			return ch-'A'+1;
		return ch-'a'+27;
	}
	
	static String solve(int n, int[] arr, String str) {
		int[] numbers1 = new int[53];
		int[] numbers2 = new int[53];
		Arrays.fill(numbers1, 0);
		Arrays.fill(numbers2, 0);
		for(int i=0;i<n;i++)
			++numbers1[arr[i]];
		for(int i=0;i<str.length();i++) {
			++numbers2[char2int(str.charAt(i))];
			//System.out.println(char2int(str.charAt(i)));
		}
		
		for(int i=0;i<numbers1.length;i++)
			if(numbers1[i] != numbers2[i])
				return "n";
		return "y";
		
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = scan.nextInt();
		
		scan.nextLine();
		String str = scan.nextLine();
		String ret = solve(n,arr,str);
		
		System.out.println(ret);
		scan.close();
		
	}
}
