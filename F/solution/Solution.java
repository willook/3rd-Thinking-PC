import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static LinkedList<Integer> que;
	static LinkedList<Integer> stack;
	public static int String2int(String str) {
		String[] parts = str.split("-");
		int ret = Integer.parseInt(parts[1]);
		ret += ((int)str.charAt(0)-'A') * 1000;
		
		return ret;
	}
	public static String solve(int n, String[] arr) {
		que = new LinkedList<Integer>();
		stack = new LinkedList<Integer>();
		n *= 5;
		int[] cands = new int[n];
		for(int i=0;i<n;i++) 
			cands[i] = String2int(arr[i]);
		int [] answers = Arrays.copyOf(cands,n); 
		Arrays.sort(answers);
		
		
		for(int i=0;i<n;i++)
			que.addLast(cands[i]);
		
		for(int i=0;i<n;i++) {
			int cand1, cand2;
			if (que.isEmpty()){
				cand2 = stack.removeLast();
				if(cand2 != answers[i]) return "BAD";
				else continue;
				
			}
			if (stack.isEmpty()){
				cand1 = que.removeFirst();
				if(cand1 == answers[i]) continue;
				else {
					stack.push(cand1);
					--i;
				}
			}
			else {
				if(stack.peekLast() == answers[i])
					stack.removeLast();
				else if(que.peekFirst() == answers[i])
					que.removeFirst();
				else {
					stack.addLast(que.removeFirst());
					--i;
				}
			}
		}
		return "GOOD";
	}
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		String[] arr = new String[n*5];
		for(int i=0;i<n*5;i++) 
			arr[i] = scan.next();
		
		String ret = solve(n, arr);
		System.out.println(ret);
		scan.close();
	}
}