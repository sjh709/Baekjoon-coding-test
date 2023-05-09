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
            boolean chk = true;
            if(i == 0 || i == 1) continue;
            for(int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    chk = false;
                    break;
                }
            }
            
            if(chk) {
                list.add(i);
            }
        }
        
        if(list.size() == 0) {
            bw.write("-1");
        }else {
            int sum = 0;
            for(int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            bw.write(String.valueOf(sum) + "\n" + String.valueOf(list.get(0)));
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
