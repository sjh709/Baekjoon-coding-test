import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = br.readLine();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            list.add(n);
        }
        
        Collections.sort(list, Collections.reverseOrder());
        String answer = "";
        for(int i = 0; i < list.size(); i++) {
            answer += list.get(i);
        }
        
        bw.write(answer);
        bw.flush();
        
        bw.close();
        br.close();
    }
}
