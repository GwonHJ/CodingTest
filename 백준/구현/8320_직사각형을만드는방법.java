import java.util.*;
import java.io.*;

 
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i = 1; i<= N; i++) {
        	for(int j = i; i*j <=N; j++)
        		sum++;
        }
       
        System.out.println(sum);
    
    }
}
