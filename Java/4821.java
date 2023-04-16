import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true) {
            int total_page = Integer.parseInt(br.readLine());
            if(total_page == 0) break;
            
            String[] s = br.readLine().split(",");
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < s.length; i++) {
                if(s[i].contains("-")) {
                    int low = Integer.parseInt(s[i].split("-")[0]);
                    int high = Integer.parseInt(s[i].split("-")[1]);
                    if(low <= high) {
                        if(total_page < high) high = total_page;
                        for(int j = low; j <= high; j++) {
                            set.add(j);
                        }
                    }
                }else {
                    if(Integer.parseInt(s[i]) <= total_page) {
                        set.add(Integer.parseInt(s[i]));
                    }
                }
            }
            
            bw.write(String.valueOf(set.size()) + "\n");
            bw.flush();
        }
        
        bw.close();
        br.close();
    }
}
