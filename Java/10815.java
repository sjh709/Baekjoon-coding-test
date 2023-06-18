import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st1.nextToken()));
        }
        
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st2.nextToken());
            if(set.contains(num)) {
                bw.append("1 ");
            }else {
                bw.append("0 ");
            }
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
