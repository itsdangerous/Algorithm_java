package semester1;

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