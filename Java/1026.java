import java.io.*;
import java.util.*;
public class Main {
    public static int min = Integer.MAX_VALUE;
    public static void combination(int[] a, boolean[] visit, int[] comb, int depth, int[] b) {
        int answer = 0;
        if(depth == comb.length) {
            for(int i = 0; i < comb.length; i++) {
                answer += comb[i] * b[i];
            }
            min = Math.min(min, answer);
        }
        
        for(int i = 0; i < a.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                comb[depth] = a[i];
                combination(a, visit, comb, depth + 1, b);
                visit[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(a, Collections.reverseOrder());
        Collections.sort(b);
        
        int answer = 0;
        for(int i = 0; i < n; i++) {
            answer += a.get(i) * b.get(i);
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
