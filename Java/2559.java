/*
1. 아이디어
- 투포인터를 활용
- for문으로, 처음에 K개값을 저장
- 다음인덱스 더해주고, 이전인덱스 빼줌
- 이때마다 최대값을 갱신

2. 시간복잡도
- O(N) = 1e5 > 가능

3. 자료구조
- 각 숫자들 N개 저장 배열 : int[]
	- 숫자들 최대 100 > int 가능
- K개의 값을 저장 변수 : int
	- 최대 K * 100 = 1e5 * 100 = 1e7 > int 가능
- 최대값 : int
*/
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        
        int[] nums = new int[n];
        
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st2.nextToken());
        }
        
        // K개를 더해주기
        int each = 0;
        for(int i = 0; i < k; i++) {
            each += nums[i];
        }
        
        int max = each;
        
        // 다음 인덱스 더해주고 이전 인덱스 빼주기
        for(int i = k; i < n; i++) {
            each += nums[i];
            each -= nums[i - k];
            max = Math.max(max, each);
        }
        
        bw.write(String.valueOf(max));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
