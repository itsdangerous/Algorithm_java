import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1774 {
    static int N,M;
    static int[] parent;
    static int[] rank;
    static Point[] points;
    static PriorityQueue<Edge> pq;

    static class Point {
        int index;
        int x;
        int y;

        public Point(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge>{
        Point startPoint;
        Point endPoint;
        double distance;

        public Edge(Point startPoint, Point endPoint, double distance) {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.distance, o.distance);
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
        points = new Point[N+1];
        makeSet();


        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Point point = new Point(i, x, y);
            points[i] = point;
        }

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j < N + 1; j++) {
                double dist = getDistance(points[i], points[j]);
                Edge edge = new Edge(points[i], points[j], dist);
                pq.offer(edge);
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            union(p1, p2);
        }

        double min = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (union(edge.startPoint.index, edge.endPoint.index)) {
                min += edge.distance;
            }
        }

        System.out.printf("%.2f\n", min);

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

        if (px == py) return false;

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

    static double getDistance(Point a, Point b) {
        double xx = Math.pow(Math.abs(a.x - b.x),2);
        double yy = Math.pow(Math.abs(a.y - b.y),2);

        return Math.sqrt(xx + yy);
    }

}
