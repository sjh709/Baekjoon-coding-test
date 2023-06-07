import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // "55-50+40"
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        
        int count = st.countTokens();
        String[] s = new String[count];
        int answer = 0;
        for(int i = 0; i < count; i++) {
            // "55", "50+40"
            s[i] = st.nextToken();
            
            String[] number = s[i].split("\\+");
            int sum = 0;
            // "50", "40"
            for(String num : number) {
                sum += Integer.parseInt(num);
            }
            
            if(i == 0) {
                answer += sum;
            }else {
                answer -= sum;
            }
        }
         
        bw.write(String.valueOf(answer));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
