import java.util.*;
import java.io.*;


class Number implements Comparable<Number>{//정렬을 하기 위한 Number 클래스
	int num;	//영어로 변환할 숫자
	String numtoS;	//영어로 변환한 문자열
	
	public Number(int num, String numtoS) {	//배열에 편하게 넣기 위해서 생성자를 만들어줌
		this.num = num;
		this.numtoS = numtoS;
	}
	
	@Override
	public int compareTo(Number o) {//영어로 변환한 문자열을 기준으로 정렬
		// TODO Auto-generated method stub
		return this.numtoS.compareTo(o.numtoS);
	}
	
	
}
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//입력을 받기 위한 버퍼드리더 선언
		StringTokenizer st = new StringTokenizer(br.readLine());	//한줄을 " "를 기준으로 자를떄
		
		int M = Integer.parseInt(st.nextToken());	//M을 입력받음
		int N = Integer.parseInt(st.nextToken());	//N을 입력받음
		

		String num[] = {"zero" , "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};	//숫자를 변환할 영어 문자열을 배열에 저장
		
		Number[] arr = new Number[N-M+1];	//변환할 숫자와 변환된 문자열을 저장할 배열
		

		
		int idx = 0;	//배열의 인덱스
		for(int i = M; i<=N; i++) {	//M~N까지 숫자를 배열에 넣고 숫자를 영어로 변환
			String tmp = "";	//숫자로 변환할 문자열
			String nts1 = "";	//1의자리수
			String nts2 = "";	//10의 자리수
			//입력이 1~99까지기 때문에 10의 자리수까지만 변수 만듦
			
			nts1 = num[i%10];//10으로 나눈 나머지가 1의 자리수니까 거기에 해당하는 영어단어
			nts2 = num[i/10];//10으로 나눈 값에 해당하는 수가 10의 자리니까 거기에 해당하는 영어단어
			if(i/10 == 0) {//만약 10으로 나눈값이 0이면 10이하의 수
				tmp = nts1;	//zero를 붙이면 안됨
			}
			else//그 외의 경우는 십의 자리 수의 영어와 일의자리수 영어를 합쳐준다.
				tmp = nts2 +" "+ nts1;
			
			arr[idx++] = new Number(i, tmp);//배열에 넣어주고 인덱스 증가
		}

		
		Arrays.sort(arr);	//정렬
		
		
		for(int i = 0; i<arr.length; i++) {//출력을 위한 for문
			System.out.print(arr[i].num+" ");//출력
			if(i%10 == 9)	//10개씩 출력이니까
				System.out.println();	//줄바꿈
		}
	}

}
