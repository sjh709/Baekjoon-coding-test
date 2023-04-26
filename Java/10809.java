/*
1. 아이디어
- int[] 배열 : 초기화 -1
- for() 
    - s.charAt() : index 저장
*/
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = br.readLine();
        
        int[] c = new int[26];
        
        Arrays.fill(c, -1);
        
        for(int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if(c[idx] == -1) c[idx] = i;
        }
        
        for(int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
    }
}
