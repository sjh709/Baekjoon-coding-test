import java.io.*;
import java.util.*;
class Print {
    int idx;
    int pri;
    
    Print(int idx, int pri) {
        this.idx = idx;
        this.pri = pri;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++) {
            Queue<Print> q = new LinkedList<>();
            int ans = 0;
            
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int m = Integer.parseInt(st1.nextToken());
            
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                q.offer(new Print(j, Integer.parseInt(st2.nextToken())));
            }
            
            while(!q.isEmpty()) {
                Print p = q.poll();
                boolean chk = true;
                
                for(Print temp : q) {
                    if(p.pri < temp.pri) {
                        chk = false;
                        break;
                    }
                }
                
                if(chk) {
                    ans++;
                    if(p.idx == m) break;
                }else {
                    q.offer(p);
                }
            }
            
            bw.append(String.valueOf(ans) + "\n");
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
