import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        BigInteger A = new BigInteger(br.readLine());
        String O = br.readLine();
        BigInteger B = new BigInteger(br.readLine());
        
        if(O.equals("+")) bw.write(String.valueOf(A.add(B)));
        if(O.equals("*")) bw.write(String.valueOf(A.multiply(B)));
        
        bw.flush();
        bw.close();
        br.close();
    }
}
