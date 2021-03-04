import java.io.*;
import java.util.*;

class Point{
	int r;
	int c;
	
	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
public class Main {

	static int N, M;
	static int[][] map;
	static boolean[] checked;
	static ArrayList<Point> c, h;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		c = new ArrayList<>();
		h = new ArrayList<>();
		
		ans = 12345689;
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					h.add(new Point(i,j));
				}
				else if(map[i][j] == 2) {
					c.add(new Point(i,j));
				}
			}
		}
		
		Point[] choice = new Point[M];
		Select(0,0,choice);
		System.out.println(ans);
		
	}
	
	public static int dist(Point[] choice) {//거리 계산
		int sum = 0;
		for(Point i : h) {
			int tmp = 123456789;
			for(Point j : choice) {
				tmp = Math.min(tmp, Math.abs(i.r-j.r)+Math.abs(i.c-j.c));
			}
			sum += tmp;
		}
		
		return sum;
	}
	
	public static void Select(int step, int start, Point[] choice) {//조합
		if(step == M) {
			//모든 치킨 집에서 가까운 집의 거리 계산
			ans = Math.min(ans, dist(choice));
			
			return;
		}
		for(int i = start; i<c.size(); i++) {
			choice[step] = c.get(i);
			Select(step+1, i+1, choice);
		}
	}
	
	

}
