/*
1. 아이디어
- for문
    - O : cnt++, score += cnt
    - X : cnt = 0
2. 시간복잡도
- O(N)?
3. 변수
- int score, int cnt
*/
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++) {
            String s = br.readLine();
            
            int score = 0, cnt = 0;
            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                
                if(c == 'O') cnt++;
                else cnt = 0;
                
                score += cnt;
            }
            
            bw.append(String.valueOf(score) + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
