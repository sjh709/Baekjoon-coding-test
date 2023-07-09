import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        int[] ans = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] value = Arrays.stream(arr).distinct().sorted().toArray();
        
        for(int i = 0; i < n; i++) {
            bw.append(Arrays.binarySearch(value, arr[i]) + " ");
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
