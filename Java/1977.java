import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = m; i <= n; i++) {
            double d = Math.sqrt(i);
            if(d % 1 == 0) {
                list.add(i);
            }
        }
        
        if(list.size() == 0) {
            bw.write("-1");
        }else {
            Collections.sort(list);
            
            int sum = 0;
            
            for(int num : list) {
                sum += num;
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append(sum + "\n");
            sb.append(list.get(0));
            
            bw.write(sb.toString());
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
