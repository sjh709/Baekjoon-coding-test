/*
1. 아이디어
- 동전을 저장한뒤 반대로 뒤집음
- 동전 for > 
	- 동전 사용개수 추가
	- 동전 사용한만큼 K값 갱신
	
2. 시간복잡도
- O(N)

3. 자료구조
- 동전 금액 : int[]
- 동전 사용 cnt : int
- 남은 금액 : int
*/
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] coin = new int[n];
        
        for(int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        
        int answer = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(k == 0) break;
            answer += k / coin[i];
            k %= coin[i];
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
