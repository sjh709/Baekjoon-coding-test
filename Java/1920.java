/*
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            hash.put(num, 1);
        }
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int value = hash.getOrDefault(num, 0);
            bw.write(String.valueOf(value) + "\n");
        }
        bw.flush();
        
        bw.close();
        br.close();
    }
}
*/


/*
1. 아이디어
- N개의 숫자를 정렬
- M개를 for문 돌면서, 이진탐색
- 이진탐색 안에서 마지막에 데이터 찾으면 1출력, 아니면 0출력

2. 시간복잡도
- N개 입력값 정렬 = O(NlgN)
- M개를 N개중에서 탐색 = O(M * lgN)
- 총합 : O((N+M)lgN) > 가능

3. 자료구조 
- N개 숫자 : int[]
- M개 숫자 : int[]
*/
import java.io.*;
import java.util.*;
public class Main {
    public static int[] nums;
    public static int search(int start, int end, int target) {
        if(start == end) {
            if(nums[start] == target) {
                return 1;
            }else {
                return 0;
            }
        }
        
        int mid = (start + end) / 2;
        
        if(nums[mid] < target) {
            return search(mid + 1, end, target);
        }else {
            return search(start, mid, target);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        nums = new int[n];
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st1.nextToken());
        }
        
        Arrays.sort(nums);
        
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st2.nextToken());
            
            int answer = search(0, n - 1, num);
            
            sb.append(String.valueOf(answer) + "\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}
