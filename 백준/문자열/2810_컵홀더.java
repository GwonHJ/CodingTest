import java.util.*;
import java.io.*;

 
public class Main {
	static boolean[] cupHolders;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		String line = br.readLine();
		
		cupHolders = new boolean[n + 1];
		int count = 0;
		boolean checked = false;
		
		for(int i = 0; i < n; i++) {
			char ch = line.charAt(i);
			if(ch == 'L') {
				if(!checked) {
					checked = true;
					cupHolders[i + 1] = true;
				}
				else {
					checked = false;
				}
			}
		
			if(!cupHolders[i]) {
				cupHolders[i] = true;
				count++;
			}
			else if(!cupHolders[i + 1]) {
				cupHolders[i + 1] = true;
				count++;
			}
		}
		
		System.out.println(count);
	}
}
