import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
 
    static int[][] map;
    //이동 : 오른쪽 위, 오른쪽, 오른쪽 아래, 아래
    static int[] dx = {-1, 0, 1, 1};
    static int[] dy = {1, 1, 1, 0}; 
         
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        map = new int[20][20];
        for(int i = 1; i<20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j<20; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
         
        //주의할것 : 1. 6개이상, 2. 판 범위 벗어날때
         
        //출력 : 가장 왼쪽, 위쪽
         
         
        int x = 0;
        int y = 0;
         
        int win = 0;
         
        aa : for(int i = 1; i<20; i++) {
            for(int j = 1; j<20; j++) {
                if(map[i][j] == 0)
                    continue;
                for(int k = 0; k<4; k++) {
                    int bx = i - dx[k];
                    int by = j - dy[k];
                    if(bx < 0 || bx >= 19 || by < 0 || by >=19 || map[bx][by] == map[i][j])
                        continue;
                     
                    win = check(i,j,k, map[i][j]);
                    if(win != 0) {
                        System.out.println(win);
                        System.out.println(i+" "+j);
                        return;
                    }
                }
            }
        }
         
        System.out.println(0);
    }
     
    public static int check(int x, int y, int k, int num) {
        int cnt = 1;
        int nx = x;
        int ny = y;
        while(true){
            nx += dx[k];
            ny += dy[k];
            if(nx <0 || nx>=20 || ny <0 || ny >=20)
                break;
            if(map[nx][ny] == num) {
                cnt++;
            }
            else
                break;
        }
             
        if(cnt == 5) {
            return num;
        }
        return 0;
    }
 
}
