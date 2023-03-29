import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q20010
{
    static int N, M;
    static int[][] dist;
    static PriorityQueue<Edge> pq;
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
    static int min;
    static int [] parent;
    static int [] rank;

    static int[] pp;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(s, e, w));
        }

        parent = new int[N];
        rank = new int[N];
        dist = new int[N][N];
        pp = new int[N];

        makeSet();
        min = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (union(edge.s, edge.e)) {
                dist[edge.s][edge.e] = edge.w;
                dist[edge.e][edge.s] = edge.w;
                pp[edge.e] = edge.s;
                System.out.println(Arrays.toString(pp));

            }
        }
        System.out.println(Arrays.toString(parent));

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(dist[i][j] + "\t\t");
            }
            System.out.println();
        }

    }
    //1~N까지
    private static void makeSet() {
        for (int i = 0; i < N; i++) {
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
        if (x== parent[x]) return parent[x];

        return parent[x] = find(parent[x]);
    }
}