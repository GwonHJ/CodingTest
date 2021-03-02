import java.util.*;
import java.io.*;

 
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<T; tc++) {
        	String prob = br.readLine();
        	int sum = 0;
        	int bef = 1;
        	for(int i = 0; i<prob.length(); i++) {
        		if(prob.charAt(i) == 'X') {
        			bef = 1;
        			continue;
        		}
        		sum += bef++;
        	}
        	System.out.println(sum);
        }
        
	}
}
