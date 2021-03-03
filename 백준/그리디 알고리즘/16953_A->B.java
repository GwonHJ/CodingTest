import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int cnt = 1;
		
		while(B > A) {
			if(B%2 == 1) {
				if(B%10 == 1) {
					B = B/10;
				}else {
					break;					
				}
			}else {
				B = B/2;
			}
			cnt++;
		}
		if(A==B)
			System.out.println(cnt);
		else
			System.out.println(-1);
		
	}

}
