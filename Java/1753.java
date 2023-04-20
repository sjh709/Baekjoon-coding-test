/*
1. 아이디어
- 한점시작, 모든 거리 : 다익스트라
- 간선, 인접리스트 저장
- 거리배열 무한대 초기화
- 시작점 : 거리배열 0, 힙에 넣어주기
- 힙에서 빼면서 다음의 것들 수행
	- 최신값인지 먼저 확인
	- 간선을 타고 간 비용이 더 작으면 갱신
	
2. 시간복잡도
- 다익스트라 : O(ElgV)
	- E : 3e5
	- V : 2e4, lgV ~= 20 
	- ElgV = 6e6 > 가능
	
3. 변수
- 힙 : (비용, 노드번호)
- 거리 배열 : 비용 : int[]
- 간선 저장, 인접리스트 : (비용, 노드번호)[]
*/
import java.io.*;
import java.util.*;
class Node implements Comparable<Node> {
    int n;
    int cost;
    Node(int n, int cost) {
        this.n = n;
        this.cost = cost;
    }
    
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] min = new int[v + 1];
        
        Arrays.fill(min, 3000001); // 간선개수 최대(300,000) * 비용 최대(10)
        
        for(int i = 0; i <= v; i++) list.add(new ArrayList<Node>());
        
        int start = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            list.get(a).add(new Node(b, c));
        }
        
        min[start] = 0;
        pq.offer(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.n;
            int currentCost = current.cost;
            
            for(int i = 0; i < list.get(currentNode).size(); i++) {
                Node next = list.get(currentNode).get(i);
                int nextNode = next.n;
                int nextCost = next.cost;
                
                if(min[nextNode] > min[currentNode] + nextCost) {
                    min[nextNode] = min[currentNode] + nextCost;
                    pq.offer(new Node(nextNode, min[nextNode]));
                }
            }
        }
        
        for(int i = 1; i <= v; i++) {
            if(min[i] == 3000001) bw.append("INF\n");
            else bw.append(min[i] + "\n");
            
            bw.flush();
        }
        
        bw.close();
        br.close();
    }
}
