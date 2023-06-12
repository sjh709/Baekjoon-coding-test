import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) q.offer(i);
        
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 0;
        while(!q.isEmpty()) {
            cnt++;
            int num = q.poll();
            
            if(cnt % k != 0) {
                q.offer(num);
            } else {
                list.add(num);
            }
        }
        
        bw.append("<");
        for(int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if(i == list.size() - 1) {
                bw.append(String.valueOf(num));
            }else {
                bw.append(String.valueOf(num) + ", ");
            }
        }
        bw.append(">");
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
