import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        
        int sum = 0;
        for(int i = 0; i < n; i++) {
            int num = s.charAt(i) - '0';
            sum += num;
        }
        
        bw.write(String.valueOf(sum));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
