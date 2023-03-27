import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        int[] arr = new int[n];
        int[] brr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
            brr[i] = Integer.parseInt(st2.nextToken());
        }
        
        if(n == 1) {
            bw.write("good puzzle");
            bw.flush();
            return;
        }
        
        boolean a = true;
        boolean b = true;
        for(int i = 0; i < n; i++) {
            if(arr[0] == brr[i]) {
                // 오른쪽
                int index = i == n - 1 ? 0 : i + 1;
                if(arr[1] == brr[index]) {
                    for(int j = 2; j < n; j++) {
                        index = index == n - 1 ? 0 : index + 1;
                        if(arr[j] != brr[index]) {
                            a = false;
                            break;
                        }
                    }
                }else {
                    a = false;
                }
                
                // 왼쪽
                index = i == 0 ? n - 1 : i - 1;
                if(arr[1] == brr[index]) {
                    for(int j = 2; j < n; j++) {
                        index = index == 0 ? n - 1 : index - 1;
                        if(arr[j] != brr[index]) {
                            b = false;
                            break;
                        }
                    }
                }else {
                    b = false;
                }
            }
        }
        
        if(a || b) bw.write("good puzzle");
        else bw.write("bad puzzle");
        
        bw.flush();
        bw.close();
        br.close();
    }
}
