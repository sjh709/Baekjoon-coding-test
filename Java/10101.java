import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int sum = a + b + c;
        
        String answer = "";
        
        if(a == b && b == c) {
            answer = "Equilateral";
        }else if(sum == 180) {
            if(a == b || b == c || a == c) {
                answer = "Isosceles";
            }else {
                answer = "Scalene";
            }
        }else {
            answer = "Error";
        }
        
        bw.write(answer);
        bw.flush();
        
        bw.close();
        br.close();
    }
}
