import java.util.*;
import java.io.*;

 
public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int[] arr= new int[L+1];
		Arrays.fill(arr, 0);
		int wmax = 0;
		int wans = 0;
		int rmax = 0;
		int rans = 0;
		
		for(int i = 1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(wmax < b-a+1) {
				wmax = b-a+1;
				wans = i;
			}
			int cnt = 0;
			for(int j = a; j<=b; j++) {
				if(arr[j] == 0) {
					arr[j] = i;
					cnt++;
				}
			}
			if(cnt>rmax) {
				rans = i;
				rmax = cnt;
			}
		}
		
		System.out.println(wans);
		System.out.println(rans);
		
	}
}
