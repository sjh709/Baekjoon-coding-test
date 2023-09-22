import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> list = new Stack<>();
		
		for(int i = n - 1; i >= 0; i--) {
			while(true) {
				if(stack.isEmpty()) {
					list.push(-1);
					stack.push(arr[i]);
					break;
				}else {
					if(arr[i] < stack.peek()) {
						list.push(stack.peek());
						stack.push(arr[i]);
						break;
					}else {
						stack.pop();
					}
				}
			}
		}
		
		while(!list.isEmpty()) {
			bw.append(list.pop() + " ");
		}
		
		bw.flush();
		
		bw.close();
		br.close();
	}
}
