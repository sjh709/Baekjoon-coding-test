import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            ArrayList<String> list = map.getOrDefault(s.length(), new ArrayList<String>());
            if(!list.contains(s)) list.add(s);
            Collections.sort(list);
            map.put(s.length(), list);
        }
        
        ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);
        for(int key : keyList) {
            ArrayList<String> list = map.get(key);
            for(int i = 0; i < list.size(); i++) {
                bw.append(list.get(i) + "\n");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
