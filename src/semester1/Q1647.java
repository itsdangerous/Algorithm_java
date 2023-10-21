package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1647 {
    static int N,M;

    static int[] parent;
    static int[] rank;
    static PriorityQueue<Edge> pq;

    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        rank = new int[N + 1];
        pq = new PriorityQueue<>();
        makeSet();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(s, e, w));
        }

        int cnt = 0;
        int min = 0;
        while (cnt != N - 2) {
            Edge edge = pq.poll();
            if (union(edge.start, edge.end)) {
                cnt++;
                min += edge.weight;
            }
        }
        System.out.println(min);

    }

    static void makeSet() {
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return false; // 이미 연결되어있을 경우

        if (rank[px] >= rank[py]) {
            parent[py] = px;
            rank[px]++;
        }
        else {
            parent[px] = py;
            rank[py]++;
        }

        return true;

    }

}
