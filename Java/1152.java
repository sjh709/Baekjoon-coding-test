/*
1. 아이디어
- 공백 제거
- split 공백 기준
- length
2. 변수
- String s
- String[] ss
*/
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = br.readLine().trim();
        
        if(s.length() == 0) {
            bw.write("0");
        }else {
            String[] ss = s.split(" ");
            bw.write(String.valueOf(ss.length));
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
