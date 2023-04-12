import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Test {

    static int V, E;
    static int[] p;
    static int[] rank;
    static PriorityQueue<Edge> pq;
    static int answer;

    static class Edge implements Comparable<Edge> {

        int s, e;
        long w;

        public Edge(int s, int e, long w) {
            super();
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.w, o.w);
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int TC = 1; TC < T + 1; TC++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(br.readLine());
            E = Integer.parseInt(br.readLine());
            p = new int[V];
            rank = new int[V];
            answer = 0;
            pq = new PriorityQueue<>();
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(br.readLine());
                int e = Integer.parseInt(br.readLine());
                long w = Long.parseLong(br.readLine());
                pq.offer(new Edge(s, e, w));
            }

            makeSet();
            kruskal();
            System.out.printf("#%d %d\n", TC, answer);
        }

    }

    static void makeSet() {
        for (int i = 0; i < V; i++) {
            p[i] = i;
            rank[i] = 1;
        }
    }

    static void kruskal() {

        int cnt = 0;

        while (cnt != V - 1) {
            Edge edge = pq.poll();
            if (union(edge.s, edge.e)) {
                answer += edge.w;
            }
        }

    }

    static int find(int x) {
        if (x == p[x])
            return x;
        return p[x] = find(p[x]);
    }

    static boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py)
            return false;
        if (rank[px] >= rank[py]) {
            rank[px]++;
            p[py] = px;
        } else {
            rank[py]++;
            p[px] = py;
        }
        return true;
    }

}
