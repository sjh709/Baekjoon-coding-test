import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] arr = new int[10001];
        
        for(int i = 1; i <= 10000; i++) {
            int num = i;
            int result = num;
            while(num > 0) {
                result += num % 10;
                num /= 10;
            }
            if(result <= 10000) arr[result]++;
        }
        
        for(int i = 1; i <= 10000; i++) {
            if(arr[i] == 0) bw.append(i + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
