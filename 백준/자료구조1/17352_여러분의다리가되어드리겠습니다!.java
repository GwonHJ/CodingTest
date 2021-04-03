import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

	
	static int N;
	static int[] arr;
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	
    	arr= new int[N+1];
    	
    	makeSet();
    	
    	for(int i = 0; i<N-2; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		union(a, b);
    	}
    	
    	int a = 0;
    	int b = 0;
    	
//    	System.out.println(Arrays.toString(arr));
    	for(int i = 1; i<N; i++) {
    		if(union(i,i+1)) {
    			a= i;
    			b = i+1;
    			break;
    		}
//    		System.out.println(i+ " "+ (i+1));
//    		System.out.println(Arrays.toString(arr));
    	}
    	
    	System.out.println(a+" "+b);
    }
    
    public static void makeSet() {
    	for(int i = 1; i<N+1; i++) {
    		arr[i] = i;
    	}
    }
    
    public static int find(int a) {
    	if(arr[a] == a) {
    		return a;
    	}
    	
    	return arr[a] = find(arr[a]);
    }
    
    public static boolean union(int a, int b) {
    	a = find(a);
    	b = find(b);
    	
    	if(a==b)
    		return false;
    	
    	arr[b] = a;
    	return true;
    }
   
    
}
