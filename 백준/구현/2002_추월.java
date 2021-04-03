import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	
    	HashMap<String, Integer> in = new HashMap<>();
    	
    	for(int i =0; i<N; i++) {
    		String car = br.readLine();
    		in.put(car,i);
    	}
    	
    	int[] out = new int[N];
    	
    	for(int i = 0; i<N; i++) {
    		String car = br.readLine();
    		out[i] = in.get(car);
    	}
    	
    	int cnt = 0;
    	for(int i= 0; i<N-1; i++) {
    		for(int j = i+1; j<N; j++) {
    			if(out[i]>out[j]) {
    				cnt++;
    				break;
    			}
    		}
    	}
    	
    	System.out.println(cnt);
    	
    	
    }   
    
}
