//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class Q1922 {
//    static int V,E;
//    static int[] p;
//    static int[] r;
//    static int min;
//
//    static PriorityQueue<Edge> points;
//
//    static int s,e, w;
//
//    static class Edge {
//        int s;
//        int e;
//        int w;
//
//        public Edge(int s, int e, int w) {
//            super();
//            this.s = s;
//            this.e = e;
//            this.w = w;
//        }
//        public int compareTo(Edge o) {
//            return Integer.compare(this.w, o.w);
//        }
//
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        V = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());
//        E = Integer.parseInt(st.nextToken());
//        points = new PriorityQueue<Edge>();
//        for (int i = 0; i < E; i++) {
//            st = new StringTokenizer(br.readLine());
//            int s = Integer.parseInt(st.nextToken());
//            int e = Integer.parseInt(st.nextToken());
//            int w = Integer.parseInt(st.nextToken());
//            points.offer(new Edge(s, e, w));
//        }
//        makeSet();
//        min = 0;
//        int cnt = 0;
//        while (cnt != V - 1) {
//            Edge edge = points.poll();
//            if (union(edge.s, edge.e)) {
//                cnt++;
//                min += edge.w;
//            }
//        }
//    }
//
//    static void makeSet() {
//        for (int i = 0; i < N; i++) {
//            p[i] = i;
//            r[i] = 1;
//        }
//    }
//
//    static boolean union(int x, int y) {
//        x = find(x);
//        y = find(y);
//        if(x==y) return false;
//        if (r[x] < r[y]) {
//            p[x] = y;
//            p[y] += r[x];
//        }else {
//            p[y] = x;
//            p[x] +=r[y];
//        }
//
//        return false;
//    }
//
//    static int find(int x) {
//        if(x==p[x]) return x;
//        else return p[x] = find(p[x]);
//    }
//}
