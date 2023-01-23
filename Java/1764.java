import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            String key = br.readLine();
            int value = map.getOrDefault(key, 0) + 1;
            if(value >= 2) {
                list.add(key);
            }
        }
        Collections.sort(list);
        
        System.out.println(list.size());
        for(String s : list) {
            System.out.println(s);
        }
    }
}
