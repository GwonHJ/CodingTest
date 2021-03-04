import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		String s = bf.readLine(); //String
		StringTokenizer st = new StringTokenizer(s); //StringTokenizer인자값에 입력 문자열 넣음
	
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> ans = new ArrayList<>();
		int c_ans = 0;
		for(int i = 0; i<N; i++) {
			int sum = 0;
			int cnt = 0;
			int[] arr = new int[3];
			s = bf.readLine(); //String
			st = new StringTokenizer(s);
			for(int j = 0; j<3; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				//팀원들의 점수합
				sum += arr[j];
				if(arr[j] < M) {
					//기준치 미달인 학생수
					cnt++;
				}
			}
			//기준치 미달인 학생이 없고 팀원의 합이 S이상이면 합격
			if(cnt==0&&sum>=S) {
				c_ans++;
				ans.add(arr[0]);
				ans.add(arr[1]);
				ans.add(arr[2]);
			}
		}
// 		System.out.println을 이용하여 출력하면 시간 초과가 발생
// 		StringBuilder로 한번에 출력
		StringBuilder sb = new StringBuilder();
//		System.out.println(c_ans);
		sb.append(c_ans).append("\n");
		//합격한 학생을 입력한 순으로 출력
		for(Integer i : ans) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

}
