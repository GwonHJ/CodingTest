import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int T = Integer.parseInt(br.readLine());
	    
	    int[] D = new int[41];
	    
	    D[0] = 0;
	    D[1] = 1;
	    D[2] = 1;
	    
	    for(int i = 3; i<41; i++)
	    	D[i] = D[i-1]+D[i-2];
	    
	    for(int tc = 1; tc<=T; tc++) {
	    	
	    	int N = Integer.parseInt(br.readLine());
	    	
	    	if(N == 0)
	    		System.out.println(1 +" "+ 0);
	    	else if(N == 1)
	    		System.out.println(0 +" "+ 1);
	    	else
	    		System.out.println(D[N-1] +" "+ D[N]);
	    }
	    
	
	
	}
	
}
