import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            arr[i] = s;
        }
        
        int[] num = new int[arr[0].length()];
        for(int i = 1; i < n; i++) {
            String a = arr[0];
            String b = arr[i];
            for(int j = 0; j < a.length(); j++) {
                if(a.charAt(j) != b.charAt(j)) num[j]++;
            }
        }
        
        String answer = "";
        for(int i = 0; i < num.length; i++) {
            if(num[i] != 0) answer += "?";
            else answer += arr[0].charAt(i);
        }
        
        bw.write(answer);
        bw.flush();
        
        bw.close();
        br.close();
    }
}
