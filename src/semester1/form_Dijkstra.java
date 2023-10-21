package semester1;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class form_Dijkstra {

    static final int INF = 9999999;
    static List<List<Node>> graph; // 그래프를 표현 할 2차원 List
    static int[] result; // 최단거리 테이블을 표현할 배열

    static boolean[] visited; // 방문처리를 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int startIndex = Integer.parseInt(br.readLine());

        //그래프 생성
        graph = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            graph.add(new ArrayList<>());
        }

        // 최단거리 테이블 생성
        result = new int[E];

        //최단거리테이블 INF로 초기화
        Arrays.fill(result, INF);

        //방문처리를 위한 배열 생성
        visited = new boolean[E];


        //문제에서 주어진 입력 값에 따른 그래프 초기화
        for (int i = 0; i < E; i++) {
           st = new StringTokenizer(br.readLine());
           int from = Integer.parseInt(st.nextToken());
           int to = Integer.parseInt(st.nextToken());
           int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, weight));

        }

        //다익스트라 수행
        dijkstra(startIndex);

        //문제 조건에 맞게 출력
        for (int i = 1; i < result.length; i++) {

            if (result[i] == INF) {
                System.out.println(INF);
            } else {
                System.out.println(result[i]);
            }
        }

    }

    private static void dijkstra(int index) {

        //최단거리가 갱신 된 노드들을 담을 우선순위 큐 생성
        PriorityQueue<Node> pq = new PriorityQueue<>();

        //최단거리테이블의 시작지점노드 값 0으로 갱신
        result[index] = 0;
        pq.offer(new Node(index, 0)); // 우선순위 큐에 시작노드 넣기

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int nodeIndex = node.index;
            int distance = node.distance;

            if(visited[nodeIndex]) continue;
            visited[nodeIndex] = true;

            if(distance> result[nodeIndex]) continue;
            for (Node linkedNode : graph.get(nodeIndex)) {
                if (distance + linkedNode.distance < result[linkedNode.index]) {
                    result[linkedNode.index] = distance + linkedNode.distance;
                    pq.offer(new Node(linkedNode.index, result[linkedNode.index]));
                }
            }
        }
    }



    static class Node implements Comparable<Node> {

        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }
}
