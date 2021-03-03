import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		//첫사람이 공을 받았다
		int cnt = 0;
		int now = 0;
		while(arr[now]<M) {
			arr[now]++;
			if(arr[now]== M) {
				break;
			}
			cnt++;
			if(arr[now]%2==1) {
				now = now+L;
				if(now >= N) { // L은 N보다 작음
					now = now%N;
				}
			}else {
				now = now-L;
				if(now < 0) {
					now += N;
				}
			}
		}
		
		System.out.println(cnt);
		
	}

}
