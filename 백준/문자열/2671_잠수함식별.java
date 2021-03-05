import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String a = "100";
		String b = "01";
		
		
		while(input.length()>0) {
//			System.out.println(input);
			if(input.indexOf(a)==0) {
				input = input.substring(3);
				int idx = input.indexOf("1");
				if(idx == -1) {//100다음에 1이 없으면 무조건 노이즈
					System.out.println("NOISE");
					return;
				}
				//0찾기 : 0이 나오면 뒤에 1이면 자르기 거기까지 자르기
				//0앞에 앞에 1이 없으면 노이즈
				//0앞에 1이 있으면, 1 앞까지 자르기
				if(input.length() == idx+1) {//뒤에 더이상 신호가 없으면			
					System.out.println("SUBMARINE");//잠수함 소리
					return;
				}
				input = input.substring(idx+1);
				if(input.indexOf("0")==-1) {//뒤에 0이 없으면
					System.out.println("SUBMARINE");//잠수함 소리
					return;
				}else if(input.charAt(input.indexOf("0")+1)=='1') {//0뒤에 1이 있으면
					input = input.substring(input.indexOf("0")+2);//1뒤에 자르기
				}else if(input.indexOf("0")!=0&&input.charAt(input.indexOf("0")-1)=='1') {//0앞에 1이 있으면
					input = input.substring(input.indexOf("0")-1);//0앞에서 자르기
				}else {
					System.out.println("NOISE");
					return;					
				}
				
			}else if(input.indexOf(b)==0) {
				input = input.substring(input.indexOf(b)+2);
			}else {
				System.out.println("NOISE");
				return;
			}
		
		}
		System.out.println("SUBMARINE");

	}

}
