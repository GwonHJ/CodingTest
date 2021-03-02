import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int cnt = 1;
		for(int i =1; i<s.length(); i++) {
			if(s.charAt(i)=='=') {
				if(s.charAt(i-1)=='c'||s.charAt(i-1)=='s') {
					continue;
				}else if(s.charAt(i-1)=='z') {
					if(i-1>0 && s.charAt(i-2)=='d'){
						cnt--;
					}
					continue;
				}
			}else if(s.charAt(i)=='-') {
				continue;
			}else if(s.charAt(i)=='j') {
				if(s.charAt(i-1)=='n'||s.charAt(i-1)=='l') {
					continue;
				}else {
					cnt++;
				}
			}else {
				cnt++;
			}
		}
		System.out.println(cnt);
	
	}

}
