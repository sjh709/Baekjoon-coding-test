import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i = 0; i < n; i++) {
            hash.put(br.readLine(), 1);
        }
        
        ArrayList<String> answer = new ArrayList<>();
        for(int i = 0; i < m; i++){
            String name = br.readLine();
            if(hash.containsKey(name)) {
                answer.add(name);
            }
        }
        
        Collections.sort(answer);
        
        bw.write(answer.size() + "\n");
        for(int i = 0; i < answer.size(); i++) {
            bw.write(answer.get(i));
            bw.newLine();
        }
        bw.flush();
        
        bw.close();
        br.close();
    }
}
