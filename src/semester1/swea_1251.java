package semester1;/*swea_1251 : 하나로
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD*/

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class swea_1251 {
    static final double INF = Double.MAX_VALUE;
    static int N;
    static double E;
    static double[][] cost;
    static int[][] points;

    static int[] p;
    static int[] rank;
    static double answer;

    static class Edge implements Comparable<Edge> {
        int s,e;
        double w;

        public Edge(int s, int e, double w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.w, o.w);
        }
    }

    public static void setInputFile(String path, String fileName) throws FileNotFoundException {
        String curWorkingDir = System.getProperty("user.dir");
        System.setIn(new FileInputStream(curWorkingDir + path + fileName));
        }
    public static void main(String[] args) throws IOException {
        String remainPath = "\\src\\tc\\";
        String fileName = "swea_1251.txt";
        setInputFile(remainPath, fileName);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int TC = 1; TC < T + 1; TC++) {

            N = Integer.parseInt(br.readLine());
            cost = new double[N][N];
            points = new int[N][2];
            p = new int[N];
            rank = new int[N];
            answer = 0;
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    points[j][i] = Integer.parseInt(st.nextToken());
                }
            }
            E = Double.parseDouble(br.readLine());

            makeCost();
            makeSet();
            kruskal();
            System.out.printf("#%d %.0f\n", TC, answer);
        }
    }

    private static void kruskal() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                pq.offer(new Edge(i, j, cost[i][j]));
            }
        }

        int cnt = 0;
        while (cnt < N -1) {
            Edge edge = pq.poll();
            if (union(edge.s, edge.e)) {
                answer += edge.w;
                cnt++;
            }
        }
    }

    private static void makeSet() {
        for (int i = 0; i < N; i++) {
            p[i] = i;
            rank[i] = 1;
        }
    }

    private static int find(int x) {
        if (x == p[x]) {
            return x;
        }
        return p[x] = find(p[x]);
    }

    private static boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if(px == py) return false;

        if (rank[px] >= rank[py]) {
            rank[px]++;
            p[py] = px;
        }
        else {
            rank[py]++;
            p[px] = py;
        }
        return true;
    }

    private static void makeCost() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cost[i][j] = distance(points[i], points[j]);
            }
        }
    }

    static double distance(int[] point1, int[] point2) {
        double xx = Math.pow(Math.abs(point1[0] - point2[0]), 2);
        double yy = Math.pow(Math.abs(point1[1] - point2[1]), 2);

        return (xx + yy) * E;
    }

}
