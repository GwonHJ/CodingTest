import java.util.*;
import java.io.*;
 
class Temp{
    int low;
    int high;
    public Temp(int low, int high) {
        this.low = low;
        this.high = high;
    }
     
}
public class Main {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
         
        Temp[] t = new Temp[N];
        for(int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
             
            t[i] = new Temp(a,b);
        }
         
        Arrays.sort(t, new Comparator<Temp>() {
 
            @Override
            public int compare(Temp o1, Temp o2) {
                // TODO Auto-generated method stub
                if(o1.high > o2.high) {
                    return 1;
                }
                return -1;
            }
             
        });
         
//      for(int i = 0; i<N; i++) {
//          System.out.println(t[i].low+" "+t[i].high);
//      }
         
        int cnt =1;
        int tmp = t[0].high;
        for(int i = 1; i<N; i++) {
            if(tmp < t[i].low) {
                cnt++;
                tmp = t[i].high;
            }
        }
         
        System.out.println(cnt);
    }
 
}
