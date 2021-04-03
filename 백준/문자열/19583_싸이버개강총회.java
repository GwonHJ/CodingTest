import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
    	Scanner sc = new Scanner(System.in);        
    	
        String before = sc.next();
        String start = sc.next();
        String end = sc.next();
        
        HashMap<String, Integer> map = new HashMap<>();
        		
        while(sc.hasNext()) {
        	String time = sc.next();
        	String name = sc.next();
        	if(time.compareTo(before)<=0) {
        		map.put(name, 1);
        	}
        	else if(time.compareTo(start)>=0&&time.compareTo(end)<=0) {
        		if(map.containsKey(name)) {
        			map.put(name, 2);
        		}
        	}
        }
        
        int ans = 0;
        for(String n : map.keySet()) {
        	if(map.get(n)==2) {
        		ans++;
//        		System.out.println(n+" "+map.get(n));
        	}
        }
        System.out.println(ans);
    }   
    
}
