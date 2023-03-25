<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Q11657 {
    static int N, M;
    static long[] dist;
    static ArrayList<Edge> graph;
    static final long INF = Long.MAX_VALUE;
    static final long mINF = Long.MIN_VALUE;
    static boolean minusCycle;

    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new long[N+1];
        graph = new ArrayList<>();
        //dist 배열 초기화
        Arrays.fill(dist, INF);

        // 그래프 입력받기
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.add(new Edge(from, to, weight));
        }
        bellmanFord();

        if (minusCycle) {
            System.out.println(-1);
            return;
        }
        for (int j = 2; j < dist.length; j++) {
            if (dist[j] == INF) {
                System.out.println(-1);
            }
            else {
                System.out.println(dist[j]);
            }
        }
    }

    private static void bellmanFord() {
        dist[1] = 0;
        for (int j = 0; j < N-1; j++) {
            for (Edge edge : graph) {
                if (dist[edge.from] != INF && (dist[edge.to] > dist[edge.from] + edge.weight)) {
                    dist[edge.to] = dist[edge.from] + edge.weight;
                }
            }
        }

        for (Edge edge : graph) {
            if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.weight) {
                minusCycle = true;
                return;
            }
        }
    }
}
=======
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11657 {

    static final long INF = Long.MAX_VALUE;
    static List<List<Node>> graph; // 그래프를 표현 할 2차원 List
    static long[] result; // 최단거리 테이블을 표현할 배열
    static boolean[] visited; // 방문처리를 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int max = Math.max(V, E);

        //방문처리를 위한 배열 생성
        visited = new boolean[max+1];

        // 최단거리 테이블 생성
        result = new long[max+1];

        //최단거리테이블 INF로 초기화
        Arrays.fill(result, INF);

        //그래프 생성
        graph = new ArrayList<>();
        for (int i = 0; i < max+1; i++) {
            graph.add(new ArrayList<>());
        }

        //문제에서 주어진 입력 값에 따른 그래프 초기화
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());
            graph.get(from).add(new Node(to, weight));

        }
        st = new StringTokenizer(br.readLine());
        int startIndex = Integer.parseInt(st.nextToken());
        int endIndex = Integer.parseInt(st.nextToken());

        //다익스트라 수행
        dijkstra(startIndex);

        //문제 조건에 맞게 출력
        System.out.println(result[endIndex]);
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
            long distance = node.distance;

            if(visited[nodeIndex]) continue;

            visited[nodeIndex] = true;
            if(distance > result[nodeIndex]) continue;
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
        long distance;

        public Node(int index, long distance) {
            this.index = index;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node o) {
            return Long.compare(this.distance, o.distance);
        }
    }
}
>>>>>>> f205b1c (123)
