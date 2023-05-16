import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int dd = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            if(dd < Math.pow((r1 + r2), 2)) {
                if(dd == 0) {
                    if(r1 != r2) {
                        bw.append("0\n");
                    }else {
                        bw.append("-1\n");
                    }
                }else {
                    if(dd == Math.pow((r1 - r2), 2)) {
                        bw.append("1\n");
                    }else if(dd < Math.pow((r1 - r2), 2)) {
                        bw.append("0\n");
                    }else if(dd > Math.pow((r1 - r2), 2)) {
                        bw.append("2\n");
                    }
                }
            }else if(dd > Math.pow((r1 + r2), 2)) {
                bw.append("0\n");
            }else if(dd == Math.pow((r1 + r2), 2)) {
                bw.append("1\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
