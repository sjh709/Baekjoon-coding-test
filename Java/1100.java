import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[][] map = new String[8][8];
        
        for(int i = 0; i < 8; i++) {
            String s = br.readLine();
            for(int j = 0; j < 8; j++) {
                map[i][j] = String.valueOf(s.charAt(j));
            }
        }
        
        int answer = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(i % 2 == 0 && j % 2 == 0 && map[i][j].equals("F")) answer++;
                if(i % 2 != 0 && j % 2 != 0 && map[i][j].equals("F")) answer++;
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
