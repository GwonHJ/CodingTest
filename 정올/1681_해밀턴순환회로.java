import java.util.*;
import java.io.*;
 
public class Main {
    static int[][]arr;
    static boolean[]visited;
    static int min, sum, N;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        
        for(int x = 0; x<N; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int y = 0; y<N; y++) {
                arr[x][y]=Integer.parseInt(st.nextToken());
            }
        }
        
        min = 123456789;
        for(int j = 1; j<N; j++) { 
            visited = new boolean[N];
            sum = 0;
            if(arr[0][j]!=0) {
                dfs(0,j,1);
            }
        }
        System.out.println(min);
    }
    public static void dfs(int x, int y, int cnt) {
        if(sum>min) {
            return;
        }
        sum = sum + arr[x][y];  
        visited[x] = true; 
        if(cnt==(N-1)) {
            sum = sum + arr[y][0];   
            if(arr[y][0]==0) {  
                return;
            }
            min = Math.min(min, sum);
            sum = sum - arr[y][0];  
            return;
        }
        
        
        for(int i = 0; i<N; i++) {
            if(!visited[i] && arr[y][i]!=0 &&(sum<min)) {  
                dfs(y,i,cnt+1);
                sum = sum - arr[y][i]; 
                visited[i] = false; 
            }
        }
    }
}
