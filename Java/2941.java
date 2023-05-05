import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] arr = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        
        String s = br.readLine();
        
        for(int i = 0; i < arr.length; i++) {
            s = s.replaceAll(arr[i], "S");
        }
        
        bw.write(String.valueOf(s.length()));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
