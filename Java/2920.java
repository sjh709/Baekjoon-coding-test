import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = "";
        for(int i = 0; i < 8; i++) {
            s += st.nextToken();
        }
        
        if(s.equals("12345678")) bw.write("ascending");
        else if(s.equals("87654321")) bw.write("descending");
        else bw.write("mixed");
        
        bw.flush();
        bw.close();
        br.close();
    }
}
