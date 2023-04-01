import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] arr = new int[7];
        for(int i = 1; i < 7; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int answer = arr[6];
        arr[6] = 0;
        
        arr[1] -= arr[5] * 11;
        answer += arr[5];
        arr[5] = 0;
        
        arr[2] -= arr[4] * 5;
        if(arr[2] < 0) {
            arr[1] -= (-arr[2]) * 4;
            arr[2] = 0;
        }
        answer += arr[4];
        arr[4] = 0;
        
        answer += arr[3] / 4;
        arr[3] %= 4;
        if(arr[3] == 1) {
            answer++;
            arr[2] -= 5;
            arr[1] -= 7;
        }
        if(arr[3] == 2) {
            answer++;
            arr[2] -= 3;
            arr[1] -= 6;
        }
        if(arr[3] == 3) {
            answer++;
            arr[2] -= 1;
            arr[1] -= 5;
        }
        
        if(arr[2] < 0) {
            arr[1] -= (-arr[2]) * 4;
            arr[2] = 0;
        }
        
        answer += arr[2] / 9;
        arr[2] %= 9;
        if(arr[2] != 0) {
            answer++;
            arr[1] -= (9 - arr[2]) * 4;
        }
        
        if(arr[1] > 0) {
            answer += arr[1] / 36;
            answer += arr[1] % 36 == 0 ? 0 : 1;
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        
        bw.close();
        br.close();
        
    }
}
