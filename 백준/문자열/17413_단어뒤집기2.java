import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		Stack<Character> stack = new Stack<>();
		Queue<Character> queue = new LinkedList<>();
		
		for(int i = 0; i<s.length(); i++) {
			if(s.charAt(i) == '<') {
				queue.add('<');
				if(!stack.isEmpty()) {
					while(!stack.isEmpty()) {
						System.out.print(stack.pop());
					}
				}
			}else if(s.charAt(i)=='>') {
				while(!queue.isEmpty()) {
					System.out.print(queue.poll());
				}
				System.out.print('>');
			}else if(s.charAt(i)==' ') {
				if(!queue.isEmpty()) {
					queue.add(' ');
				}else {
					while(!stack.isEmpty()) {
						System.out.print(stack.pop());
					}
					System.out.print(" ");
				}
			}else{
				if(queue.isEmpty())
					stack.add(s.charAt(i));
				else
					queue.add(s.charAt(i));
			}
		}
		if(!stack.isEmpty()) {
			while(!stack.isEmpty()) {
				System.out.print(stack.pop());
			}
		}
	
	}

}
