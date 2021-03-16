import java.util.*;
import java.io.*;

public class  {
	static int C;
    static int L;
    static String[] input;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        input = br.readLine().split(" ");

        Arrays.sort(input);

        solve(0, "");
    }

    public static void solve(int index, String ret) {
        if (ret.length() == L) {
            if (isPossible(ret)) {
                System.out.println(ret);
            }
            return;
        }
        if (index >= C) return;
        solve(index + 1, ret + input[index]);
        solve(index + 1, ret);
    }

    public static boolean isPossible(String ret) {
        int vowel = 0, consonant = 0;
        for (int i = 0; i < ret.length(); i++) {
            if (isVowel(ret.charAt(i))) vowel++;
            else consonant++;
        }

        return vowel >= 1 && consonant >= 2;
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
