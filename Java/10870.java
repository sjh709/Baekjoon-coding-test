import java.util.*;

public class Main {
    
	public static int fibo(int n) {
		// 2. 탈출 조건
		if(n < 2)
			return n;
		
		// 1. 기본 동작
		return fibo(n - 1) + fibo(n - 2);
	}
	
	public static void main(String[] args) {
		// 재귀 함수
		// 1. 재귀 함수의 기본 동작
		// 2. 재귀 함수의 탈출 조건
		
		Scanner sc = new Scanner(System.in);
		
		// ver 1
		int n = sc.nextInt();
		System.out.println(fibo(n));
	}
}
