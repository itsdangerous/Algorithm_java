package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Q1865 {
    static int N, M, W;
    static long[] dist;
    static ArrayList<Edge> graph;
    static final long INF = Long.MAX_VALUE;
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
        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            //dist 배열 초기화


            // 그래프 입력받기
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                graph.add(new Edge(from, to, weight));
                graph.add(new Edge(to, from, weight));
            }
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                graph.add(new Edge(from, to, -weight));
            }

            bellmanFord();

            if (minusCycle) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }

    private static void bellmanFord() {

        for (int startIndex = 1; startIndex <= N; startIndex++) {
            minusCycle = false;
            dist = new long[N + 1];
            Arrays.fill(dist, INF);
            dist[startIndex] = 0;
            for (int j = 0; j < N - 1; j++) {
                for (Edge edge : graph) {
                    if (dist[edge.from] != INF && (dist[edge.to] > dist[edge.from] + edge.weight)) {
                        dist[edge.to] = dist[edge.from] + edge.weight;
                    }
                }
            }

            for (Edge edge : graph) {
                if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.weight) { // 음수 cycle 찾기
                    if (edge.to == startIndex) { // 시작정점 돌아오기
                        minusCycle = true;
                        break;
                    }
                }
            }
        }
    }
}