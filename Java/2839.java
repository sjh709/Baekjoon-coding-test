/*
1. 아이디어
- N이 5의 배수이면, 5로 나누기
- N이 5의 배수가 아니면, while(N % 5 != 0)문 돌면서 3을 빼주기
    - 3을 뺀 수가 음수면 break 후 -1 리턴
    - 3을 뺀 수가 양수면 answer++
*/
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int answer = 0;
        
        while(n % 5 != 0) {
            n -= 3;
            if(n >= 0) answer++;
            else {
                answer = -1;
                break;
            }
        }
        
        if(answer != -1) {
            answer += n / 5;
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
