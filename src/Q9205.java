import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q9205 {
    static int N;
    static int[][] graph;
    static Point[] points;
    static int INF = Integer.MAX_VALUE;

    static class Point {
        int x;
        int y;
        int index;

        public Point(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int TC = 1; TC < T + 1; TC++) {
            N = Integer.parseInt(br.readLine());
            graph = new int[N + 2][N + 2];
            points = new Point[N + 2];
            for (int i = 0; i < N + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[i] = new Point(x, y, i);

            }

            for (int i = 0; i < N+2; i++) {
                for (int j = 0; j < N+2; j++) {
                    int d = distance(points[i], points[j]);
                    if (d > 1000 || i == j) {
                        graph[i][j] = INF;
                        graph[j][i] = INF;
                    } else {
                        graph[i][j] = d;
                        graph[j][i] = d;
                    }
                }
            }

//            printGraph(graph);
            if (bfs()) {
                System.out.println("happy");
            }
            else {
                System.out.println("sad");
            }

        }

    }

    static boolean bfs() {
        Queue<Point> que = new LinkedList<>();
        boolean[][] visited = new boolean[N+2][N+2];
        que.offer(points[0]);

        while (!que.isEmpty()) {
            Point p = que.poll();
            if (p.index == N+1) return true;
            for (int i = 0; i < N + 2; i++) {
                if (visited[p.index][i]) continue;
                if (graph[p.index][i] > 1000) continue;
                if (p.index == i) continue;
                que.offer(points[i]);
//                System.out.printf("points[i].x = %d, points[i].y = %d, points[i].index = %d\n", points[i].x, +points[i].y, points[i].index);
                visited[p.index][i] = true;
                visited[i][p.index] = true;
            }
        }
        return false;
    }

    static int distance(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    static void printGraph(int[][] graph) {
        for (int i = 0; i < N + 2; i++) {
            for (int j = 0; j < N + 2; j++) {
                System.out.print(graph[i][j]+" ");

            }
            System.out.println();
        }
    }
}
