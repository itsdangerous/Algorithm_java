import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q6497 {
    static int V, E;
    static PriorityQueue<Edge> points;
    static class Edge implements Comparable<Edge>{
        int s;
        int e;
        int w;
        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
        @Override
        public String toString() {
            return "Edge [s=" + s + ", e=" + e + ", w=" + w + "]";
        }

    }
    static long min;
    static int [] parent;
    static int [] rank;
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            if(V == 0) return;
            points = new PriorityQueue<>();
            total = 0;
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                total += w;
                points.offer(new Edge(s, e, w));
            }
            parent = new int[V];
            rank = new int[V];
            makeSet();
            int cnt = 0;
            min = 0;
            while (cnt != V - 1) {
                Edge edge = points.poll();
                //System.out.println(edge);
                assert edge != null;
                if (union(edge.s, edge.e)) {
                    cnt++;
                    min += edge.w;
                }
            }
            System.out.println(total - min);

        }
    }
    //1~N까지
    private static void makeSet() {
        for (int i = 0; i < V; i++) {
            parent[i]=i;
            rank[i] = 1;
        }
    }
    private static boolean union(int x, int y) {
        int px=find(x);
        int py=find(y);
        if(px==py) return false; //이미 연결 되었을 경우
        if (rank[px]< rank[py]) {
            rank[py]+= rank[px];
            parent[px]=py;
        } else {
            rank[px]+= rank[py];
            parent[py]=px;
        }
        return true;
    }

    private static int find(int x) {
        if (x== parent[x])return parent[x];
        else return parent[x]=find(parent[x]);
    }
}