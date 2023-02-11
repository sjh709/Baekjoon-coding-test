import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int m = Integer.parseInt(br.readLine());
        int bit = 0;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch(s) {
                case "add" :
                    {
                        int num = Integer.parseInt(st.nextToken());
                        bit |= (1 << (num - 1));
                        break;
                    }
                case "remove" :
                    {
                        int num = Integer.parseInt(st.nextToken());
                        bit &= ~(1 << (num - 1));
                        break;
                    }
                case "check" :
                    {
                        int num = Integer.parseInt(st.nextToken());
                        sb.append((bit & (1 << (num - 1))) != 0 ? "1\n" : "0\n");
                        break;
                    }
                case "toggle" :
                    {
                        int num = Integer.parseInt(st.nextToken());
                        bit ^= (1 << (num - 1));
                        break;
                    }
                case "all" :
                    {
                        bit |= (~0);
                        break;
                    }
                case "empty" :
                    {
                        bit = 0;
                        break;
                    }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}
