import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, endY, endX;
    static int[] Y = {-1, 0, 1, 0}, X = {0, 1, 0, -1}; //상 -> 우 -> 하 -> 좌
    static boolean[][][] visit;
    static int[][] map;

    static void init(){
        for(int i=0; i<=n+1; i++){
            map[0][i] = -1; map[n+1][i] = -1;
            map[i][0] = -1; map[i][n+1] = -1;
        }
    }

    static void DFS(int y, int x, int dir) {
        if(map[y][x] < 0){
            endY = y;
            endX = x;
            return;
        }
        if(visit[y][x][dir]) {
            endY = 0;
            endX = 0;
            return;
        }

        visit[y][x][dir] = true;
        
        if(map[y][x] == 1) //우향우 거울(1)이면 우로 회전
            dir = (dir + 1) % 4;

        int ny = y + Y[dir];
        int nx = x + X[dir];

        DFS(ny, nx, dir);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int a=0; a<t; a++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            endX = -1;
            endY = -1;
            int dir = -1; //방향(상,하,좌,우)
            map = new int[52][52];
            visit = new boolean[52][52][4];
            init();

            /* 우향우 거울 좌표 */
            for(int i=0; i<r; i++){
                st = new StringTokenizer(br.readLine());

                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }
            /* 레이저 빔 좌표 */
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if(x == n+1)     dir = 3; //좌
            else if(y == n+1)dir = 0; //상
            else if(x == 0)  dir = 1; //우
            else             dir = 2; //하

            DFS(y+Y[dir], x+X[dir], dir);

            System.out.println(endY + " " + endX);
        }
    }
}
