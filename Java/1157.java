import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        /*HashMap<Character, Integer> map = new HashMap<>();
        
        String s = br.readLine().toUpperCase();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        ArrayList<Character> keyList = new ArrayList<>(map.keySet());
        keyList.sort((a, b) -> map.get(b).compareTo(map.get(a)));
        
        if(keyList.size() > 1 && map.get(keyList.get(0)).equals(map.get(keyList.get(1)))) {
            bw.write("?");
        }else {
            bw.write(keyList.get(0));
        }*/
        
        String str = br.readLine().toUpperCase();
        
        int[] count = new int[26];
        
        int maxValue = 0;
        char maxChar = '?';
        
        for(int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'A';
            count[idx]++;
            
            if(maxValue < count[idx]) {
                maxValue = count[idx];
                maxChar = str.charAt(i);
            }else if(maxValue == count[idx]) {
                maxChar = '?';
            }
        }
        
        bw.write(maxChar);
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
