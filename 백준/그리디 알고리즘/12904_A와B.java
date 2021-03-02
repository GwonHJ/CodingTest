import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String result = br.readLine();
		
		while(true) {
			if(input.length() == result.length()) {
				if(input.equals(result))
					System.out.println(1);
				else
					System.out.println(0);
				break;
			}
			if(result.charAt(result.length()-1)=='A') {
				result = result.substring(0,result.length()-1);
			}else {
				result = result.substring(0,result.length()-1);
				result = new StringBuffer(result).reverse().toString();
			}
		}
	
	}

}
