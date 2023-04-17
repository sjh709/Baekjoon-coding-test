import java.io.*;
import java.util.*;
class Score {
    String num = "";
    int s = 0;
    int b = 0;
    Score(String num, int s, int b) {
        this.num = num;
        this.s = s;
        this.b = b;
    }
}
public class Main {
    public static int result = 0;
    public static void solve(boolean[] visit, int depth, int[] nums, int n, ArrayList<Score> list) {
        if(depth == 3) {
            int cnt = 0;
            for(int k = 0; k < n; k++) {
                String num = list.get(k).num;
                int s = list.get(k).s;
                int b = list.get(k).b;
                
                int temp_s = 0, temp_b = 0;
                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < 3; j++) {
                        int number = num.charAt(j) - '0';
                        if(nums[i] == number) {
                            if(i == j) {
                                temp_s++;
                                break;
                            }else {
                                temp_b++;
                                break;
                            }
                        }
                    }
                }
                
                if(s == temp_s && b == temp_b) cnt++;
                else return;
            }
            
            if(cnt == n) result++;
            
            return;
        }
        for(int i = 1; i <= 9; i++) {
            if(!visit[i]) {
                visit[i] = true;
                nums[depth] = i;
                solve(visit, depth + 1, nums, n, list);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        ArrayList<Score> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            String num = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            list.add(new Score(num, s, b));
        }
        
        boolean[] visit = new boolean[10];
        int[] nums = new int[3];
        
        solve(visit, 0, nums, n, list);
        
        bw.write(String.valueOf(result));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
