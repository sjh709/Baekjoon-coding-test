import java.io.*;
import java.util.*;
class wh {
    int weight;
    int height;
    public wh(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        wh[] human = new wh[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            
            human[i] = new wh(w, h);
        }
        
        int[] grade = new int[n];
        Arrays.fill(grade, 1);
        for(int i = 0; i < human.length - 1; i++) {
            for(int j = i + 1; j < human.length; j++) {
                int m_weight = human[i].weight;
                int m_height = human[i].height;
                int y_weight = human[j].weight;
                int y_height = human[j].height;
                if(y_weight > m_weight && y_height > m_height) {
                    grade[i]++;
                }else if(y_weight < m_weight && y_height < m_height) {
                    grade[j]++;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < grade.length; i++) {
            sb.append(grade[i] + " ");
        }
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}
