import java.io.*;
import java.util.*;
public class Main {
    public static int n, m;
    public static int[] num, temp, oper;
    public static ArrayList<Integer> list;
    public static boolean[] visit;
    public static int maxValue = Integer.MIN_VALUE;
    public static int minValue = Integer.MAX_VALUE;
    
    public static void solve(int depth) {
        if(depth == m) {
            int ans = num[0];
            
            for(int i = 0; i < m; i++) {
                if(oper[i] == 0) {
                    ans += num[i + 1];
                }else if(oper[i] == 1) {
                    ans -= num[i + 1];
                }else if(oper[i] == 2) {
                    ans *= num[i + 1];
                }else if(oper[i] == 3) {
                    if(ans < 0) {
                        int a = ans * (-1);
                        ans = (a / num[i + 1]) * (-1);
                    }else {
                        ans /= num[i + 1];
                    }
                }
            }
            
            maxValue = Math.max(maxValue, ans);
            minValue = Math.min(minValue, ans);
            
            return;
        }
        
        for(int i = 0; i < m; i++) {
            if(!visit[i]) {
                visit[i] = true;
                oper[depth] = list.get(i);
                solve(depth + 1);
                visit[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        m = n - 1;
        
        num = new int[n];
        temp = new int[4];
        oper = new int[m];
        list = new ArrayList<>();
        visit = new boolean[m];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
            
            if(temp[i] != 0) {
                for(int j = 0; j < temp[i]; j++) {
                    list.add(i);
                }
            }
        }
        
        solve(0);
        
        bw.append(String.valueOf(maxValue) + "\n");
        bw.append(String.valueOf(minValue) + "\n");
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
