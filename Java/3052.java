/*
1. 아이디어
- for : % 나머지 -> HashSet
- HashSet size
2. 시간복잡도
- O(N)
3. 변수
- int
*/
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            set.add(num % 42);
        }
        
        bw.write(String.valueOf(set.size()));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
