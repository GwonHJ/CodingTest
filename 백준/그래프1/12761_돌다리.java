import java.util.*;
import java.io.*;

public class Main {

	static int A, B, N, M;
	static int[] map = new int[100001];

	static Queue<Integer> que;

	public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
		A = Integer.parseInt(st.nextToken());
    	B = Integer.parseInt(st.nextToken());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());

		bfs();

	}

	private static void bfs() {
		que = new LinkedList<>();
		que.add(N);
		map[N] = 1;
		while (!que.isEmpty()) {
			N = que.poll();
			if (N == M) {

				break;
			}
			if (N + 1 <= 100000 && map[N + 1] == 0) {
				que.add(N + 1);
				map[N + 1] = map[N] + 1;
			}
			if (N - 1 >= 0 && map[N - 1] == 0) {
				que.add(N - 1);
				map[N - 1] = map[N] + 1;
			}
			if (N + A <= 100000 && map[N + A] == 0) {
				que.add(N + A);
				map[N + A] = map[N] + 1;
			}
			if (N * A <= 100000 && map[N * A] == 0) {
				que.add(N * A);
				map[N * A] = map[N] + 1;
			}
			if (N - A >= 0 && map[N - A] == 0) {
				que.add(N - A);
				map[N - A] = map[N] + 1;
			}

			if (N + B <= 100000 && map[N + B] == 0) {
				que.add(N + B);
				map[N + B] = map[N] + 1;
			}
			if (N - B >= 0 && map[N - B] == 0) {
				que.add(N - B);
				map[N - B] = map[N] + 1;
			}

			if (N * B <= 100000 && map[N * B] == 0) {
				que.add(N * B);
				map[N * B] = map[N] + 1;
			}
		}
		System.out.println(map[M] - 1);

	}
}
