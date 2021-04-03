import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	String s = br.readLine();
    	int ans = 123456789;
    	
    	char[] ball = new char[N];
    	int Rcnt = 0;
    	int Bcnt = 0;
    	for(int i =0; i<N; i++) {
    		ball[i] = s.charAt(i);
    		if(ball[i] == 'R')
    			Rcnt++;
    	}
    	
    	Bcnt = N-Rcnt;
    	
    	
    	int cnt = 0;
    	int idx = 0;
    	while(ball[idx++]=='R'&&idx<N)
    		cnt++;
    	ans = Math.min(ans, Rcnt-cnt);
    	
    	cnt = 0;
    	idx = N-1;
    	
    	while(ball[idx--]=='R'&&idx>=0)
    		cnt++;
    	ans = Math.min(ans, Rcnt-cnt);
    	
    	cnt = 0;
    	idx = 0;
    	
    	while(ball[idx++]=='B'&&idx<N)
    		cnt++;
    	ans = Math.min(ans, Bcnt-cnt);
    	
    	cnt = 0;
    	idx = N-1;
    	
    	while(ball[idx--]=='B'&&idx>=0)
    		cnt++;
    	ans = Math.min(ans, Bcnt-cnt);
    	
    	System.out.println(ans);
    	
    	
    }
   
    
}
