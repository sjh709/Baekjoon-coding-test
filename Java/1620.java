import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        HashMap<Integer, String> idx_to_name = new HashMap<>();
        HashMap<String, Integer> name_to_idx = new HashMap<>();
        
        for(int i = 1; i <= n; i++) {
            String name = br.readLine();
            idx_to_name.put(i, name);
            name_to_idx.put(name, i);
        }
        
        for(int i = 0; i < m; i++) {
            String query = br.readLine();
            if(Character.isDigit(query.charAt(0))) {
                bw.write(idx_to_name.get(Integer.parseInt(query)));
                bw.newLine();
            }else {
                bw.write(String.valueOf(name_to_idx.get(query)));
                bw.newLine();
            }
        }
        bw.flush();
        
        bw.close();
        br.close();
    }
}
