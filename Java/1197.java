/*
1. 아이디어
- MST 기본문제, 외우기
- 간선을 인접리스트에 집어넣기
- 힙에 시작점넣기
- 힙이 빌때까지 다음 작업을 반복
	- 힙의 최소값 꺼내서, 해당 노드 방문 안했다면
		- 방문 표시, 해당 비용 추가, 연결된 간선들 힙에 넣어주기
		
2. 시간복잡도
- MST : O(ElgE)

3. 자료구조
- 간선 저장되는 인접리스트 : (무게, 노드번호)
- 힙 : (무게, 노드번호)
- 방문 여부 : boolean[]
- MST 결과값 : int
*/
import java.io.*;
import java.util.*;
class Edge implements Comparable<Edge> {
    int node;
    int cost;
    Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
    
    public int compareTo(Edge o) {
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
        
        ArrayList<ArrayList<Edge>> list = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[v + 1];
        int answer = 0;
        
        for(int i = 0; i < v + 1; i++) list.add(new ArrayList<Edge>());
        
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            list.get(a).add(new Edge(b, c));
            list.get(b).add(new Edge(a, c));
        }
        
        pq.offer(new Edge(1, 0));
        
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            
            if(!visit[edge.node]) {
                visit[edge.node] = true;
                answer += edge.cost;
                
                for(int i = 0; i < list.get(edge.node).size(); i++) {
                    Edge next = list.get(edge.node).get(i);
                    if(!visit[next.node]) pq.offer(new Edge(next.node, next.cost));
                }
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
