import java.util.*;

public class Main {
    public static int[] d;
    
    public static int fibo(int n) {
        if(n == 0 || n == 1)
            return n;
        if(d[n] != 0)
            return d[n];
        d[n] = fibo(n - 1) + fibo(n - 2);
        return d[n];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n + 1];
        
        int answer = fibo(n);
        System.out.println(answer);
    }
}
