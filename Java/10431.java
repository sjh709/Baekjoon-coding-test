import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int p = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < p; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            
            int[] arr = new int[20];
            for(int j = 0; j < 20; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            
            int cnt = 0;
            for(int j = 0; j < 20; j++) {
                while(j >= 1 && arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    cnt++;
                    j--;
                }
            }
            bw.write(String.valueOf(t) + " " + String.valueOf(cnt));
            bw.newLine();
        }
        bw.flush();
        
        bw.close();
        br.close();
    }
}
