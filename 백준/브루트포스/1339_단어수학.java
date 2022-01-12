import java.util.*;
import java.io.*;

public class Main {

	static int[] arr;
	static boolean[] visited;
	static int max_score;
	static String[] input;
	static boolean[] alpha;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		input = new String[N];
		for(int i = 0; i<N; i++) {
			input[i] = br.readLine();
		}
		
		alpha = new boolean[26];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<input[i].length(); j++) {
				alpha[input[i].charAt(j)-'A'] = true;
			}
		}
		int cnt = 0;
		for(int i = 0; i<26; i++) {
			if(alpha[i])	cnt++;
		}
		arr = new int[cnt];
		visited= new boolean[cnt];
		//숫자별로 줄세우기
		//알파벳순서랑 줄이랑 매칭해서 점수 계산
		permu(cnt,0);
		
		System.out.println(max_score);
	}

	private static void permu(int cnt, int step) {
		// TODO Auto-generated method stub
		if(cnt == step) {
			calcu(cnt);
			return;
		}
		
		for(int i = 0; i<cnt; i++) {
			if(visited[i])
				continue;
			visited[i]= true;
			arr[i] = 9-step;
			permu(cnt, step+1);
			visited[i] = false;
		}
	}

	private static void calcu(int cnt) {
		// TODO Auto-generated method stub
		int[] score = new int[26];
		
		int idx = 0;
		for(int i = 0; i<26; i++) {
			if(alpha[i])
				score[i] = arr[idx++];
		}
				
		int sum = 0;
		for(int i = 0; i<input.length; i++) {
			int sum_s = 0;
			for(int j = 0; j<input[i].length(); j++) {
				sum_s = sum_s*10 + score[input[i].charAt(j)-'A'];
			}
			sum += sum_s;
		}
		
		max_score = Math.max(sum, max_score);
	}
}
