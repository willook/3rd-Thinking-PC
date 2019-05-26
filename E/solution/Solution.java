import java.util.*;

public class Main {
	
	public static int solve(int a, int b, int c) {
	
		int x_2 = a*a - b*b;
		int y_2 = a*a - c*c;
		for(int d = 1;d<a;d++) {
			int left = (a*d + b*c)*(a*d + b*c);
			int right = x_2*y_2;
			if(left == right) 
				return d;
		}
		return -1;
	}
		
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	     
		int a = scanner.nextInt();                    
		int b = scanner.nextInt();                  
		int c = scanner.nextInt();  
		System.out.println(solve(a,b,c));
		scanner.close();
   }

}