import java.util.*;
class Solution {
    
    static int size;
    static StringBuilder sb;
    static HashSet<Integer> hashset;
    
    public int solution(String numbers) {
        int answer = 0;
        size = numbers.length();
        hashset = new HashSet<>();
        
        for(int i = 1; i<=size; i++){
            sb = new StringBuilder();
            sb.append(numbers);
            perm(i, 0);
        }
        answer = hashset.size();
        return answer;
    }
    
    public static boolean sosu(int a){
        if(a == 1 || a == 0){
            return false;
        }
        if(a == 2){
            return true;
        }
        for(int i = 2; i*i<=a; i++){
            if(a%i == 0)
                return false;
        }
        return true;
    }
    public static void swap(int x, int y){
        char tmp1 = sb.charAt(x);
        char tmp2 = sb.charAt(y);
        sb.setCharAt(x,tmp2);
        sb.setCharAt(y,tmp1);
    }
    public static void perm(int step, int start){
        if(start == step){
            int a = Integer.parseInt(sb.toString());
            int sub = (int)Math.pow(10,(size-step));
            
            a = a/sub;
            // System.out.println(a);
            if(sosu(a)){
                hashset.add(a);
            }
            return;
        }
        
        for(int i = start; i<size; i++){
            swap(i,start);
            perm(step, start+1);
            swap(i,start);
        }
    }
}
