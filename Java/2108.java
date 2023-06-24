import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int avg = 0; // 산술평균
        int idx = n / 2;
        ArrayList<Integer> list = new ArrayList<>(); // 중앙값
        HashMap<Integer, Integer> hash = new HashMap<>(); // 최빈값
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE; // 범위
        
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            
            avg += num;
            list.add(num);
            hash.put(num, hash.getOrDefault(num, 0) + 1);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        avg = (int)Math.round(avg / (double)n);
        bw.append(String.valueOf(avg) + "\n");
        
        Collections.sort(list);
        bw.append(String.valueOf(list.get(idx)) + "\n");
        
        ArrayList<Integer> keyList = new ArrayList<>(hash.keySet());
        Collections.sort(keyList);
        keyList.sort((a, b) -> hash.get(b).compareTo(hash.get(a)));
        if(n > 1 && hash.get(keyList.get(0)) == hash.get(keyList.get(1))) {
            bw.append(String.valueOf(keyList.get(1)) + "\n");
        }else {
            bw.append(String.valueOf(keyList.get(0)) + "\n");
        }
        
        bw.append(String.valueOf(max - min));
        
        bw.flush();
        
        bw.close();
        br.close();
        
    }
}
