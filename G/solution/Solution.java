import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] solve(int TC, int m,int L, int[] slices, int[] query) {
		int[] ret = new int[TC];
		for(int tc = 0; tc<TC;tc++) {
			int n = query[tc];
			int left = 0;
			int right = L;
			int mid = (left+right)/2;
		
			while(left+1 < right) {
				boolean det = isSlice(n,m,L,slices,mid);
				if(det) left = mid;
				else right = mid-1;
				mid = (left +right)/2;
			}
		
			if(isSlice(n,m,L,slices,right)) ret[tc] = right;
			else ret[tc] = left;
		}
		return ret;
	}
	public static boolean isSlice(int n, int m, int L, int[] slices, int mid) {
		int k=0;
		int block = mid;
		for(int i=0;i<m;i++) {
			if(slices[i] < block) continue;
			if(slices[i]+mid > L) break;
			block = slices[i]+mid;
			++k;
		}
		return n <= k;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		StringTokenizer st = new StringTokenizer(br.readLine()); 
		//int n = 1; 
		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken()); 
		int l = Integer.parseInt(st.nextToken()); 
		
		int[] slices = new int[m];
		int[] query = new int[n];
		for(int i=0;i<m;i++) 
			slices[i] = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) 
			query[i] = Integer.parseInt(br.readLine());
		
		
		int[] ret = solve(n,m,l,slices, query);
		
		for(int i=0;i<n;i++) 
			System.out.println(ret[i]);
		
		br.close();
		
	}
}
