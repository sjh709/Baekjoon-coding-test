import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        HashMap<Integer, String> hash1 = new HashMap<>();
        HashMap<String, Integer> hash2 = new HashMap<>();
        
        for(int i = 1; i <= n; i++) {
            String s = br.readLine();
            hash1.put(i, s);
            hash2.put(s, i);
        }
        
        for(int i = 0; i < m; i++) {
            String s = br.readLine();
            if(s.charAt(0) >= '0' && s.charAt(0) <= '9') {
                bw.write(hash1.get(Integer.parseInt(s)));
                bw.newLine();
            }else {
                bw.write(String.valueOf(hash2.get(s)));
                bw.newLine();
            }
        }
        bw.flush();
        
        bw.close();
        br.close();
    }
}
