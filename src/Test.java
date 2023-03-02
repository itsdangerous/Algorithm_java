import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Test {

    static int V, E;

    static class Edge implements Comparable<Edge> {
        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static boolean[] checked;
    static List<Edge>[] adj;
    static PriorityQueue<Edge> points;
    static long min;
    static int MM = Integer.MAX_VALUE / 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        checked = new boolean[V + 1];
        adj = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) { // 간선의 개수만큼이다. 기억하기.
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj[from].add(new Edge(to, weight));
            adj[to].add(new Edge(from, weight));
        }

        points = new PriorityQueue<>();
        points.offer(new Edge(1, 0));
        int cnt = 0;
        while (!points.isEmpty()) {// for문은 한개 인거 암기
            Edge edge = points.poll();
            if (checked[edge.v]) continue;
            min += edge.w;
            checked[edge.v] = true;
            if(++cnt == V) break; // cnt 잊지 말고
            for (int i = 0; i < adj[edge.v].size(); i++) {
                Edge next = adj[edge.v].get(i);
                if(checked[next.v]) continue;
                points.offer(next);
            }
        }
        System.out.println(min);
    }
}