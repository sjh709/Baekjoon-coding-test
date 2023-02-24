import java.io.*;
import java.util.*;
public class Main {
    public static int[] answer;
    public static void backTracking(int[] height, boolean[] visit, int[] list, int depth) {
        if(depth == list.length) {
            int sum = 0;
            for(int i = 0; i < list.length; i++) {
                sum += list[i];
            }
            if(sum == 100) {
                answer = list.clone();
            }
            return;
        }
        
        for(int i = 0; i < height.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                list[depth] = height[i];
                backTracking(height, visit, list, depth + 1);
                visit[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] height = new int[9];
        boolean[] visit = new boolean[9];
        for(int i = 0; i < 9; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }
        
        int[] list = new int[7];
        backTracking(height, visit, list, 0);
        Arrays.sort(answer);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < answer.length; i++) {
            sb.append(String.valueOf(answer[i]) + "\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}
