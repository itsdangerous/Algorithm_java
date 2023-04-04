import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17472 {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static int[] p;
    static int[] rank;
    static int[][] map;
    static int answer;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    static ArrayList<Island> islandList;
    static int size;
    static int[][] dist;

    static class Edge implements Comparable<Edge> {
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
    }

    static class Island {
        int size;
        ArrayList<Point> points;
        int index;

        public Island(int index) {
            this.index = index;
            this.points = new ArrayList<>();
            this.size = 0;
        }

        public void addPoint(Point p) {
            this.size++;
            this.points.add(p);
        }
    }

    static class Point {
        int r;
        int c;
        int num;

        public Point(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        islandList = new ArrayList<>();
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        floodFill();
//        printArr(map);

        size = islandList.size();
        p = new int[size];
        rank = new int[size];

        dist = new int[size][size];
        makeDist();
//        printArr(dist);
        makeSet();
        kruskal();

        if (answer == 0) {
            System.out.println(-1);
        }
        else System.out.println(answer);
    }

    private static void kruskal() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (dist[i][j] == INF) continue;
                if (i >= j) continue;
                pq.offer(new Edge(i, j, dist[i][j]));
            }
        }

        int cnt = 0;
        answer = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (union(edge.s, edge.e)) {
                answer += edge.w;
                cnt++;
            }
        }
    }

    private static void makeSet() {
        for (int i = 0; i < size; i++) {
            p[i] = i;
            rank[i] = 1;
        }
    }

    private static int find(int x) {
        if(x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    private static boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return false;
        if (rank[px] >= py) {
            p[py] = px;
            rank[px]++;
        } else {
            p[px] = py;
            rank[py]++;
        }
        return true;
    }

    private static void makeDist() {

        for (int i = 0; i < size; i++) {
            int[] distance = findOtherDistance(islandList.get(i));
            System.arraycopy(distance, 0, dist[i], 0, distance.length);
        }
    }

    private static int[] findOtherDistance(Island island) { // 한 섬으로부터 다른섬까지의 거리 배열을 반환하는 메서드
        int[] distance = new int[size]; // 거리 배열 index : 0 == island.num : 2 부터시작
        Arrays.fill(distance, INF);

        Queue<Point> que = new LinkedList<>();
        for (int i = 0; i < island.size; i++) {
            que.offer(island.points.get(i));
        }
        while (!que.isEmpty()) {
            Point p = que.poll();
            for (int d = 0; d < 4; d++) {
                int[] info = findOtherPoint(p, dr[d], dc[d]); // info = ['도착 지점 번호', '거리']
                if(info[1] >= 2) distance[info[0]] = Math.min(distance[info[0]], info[1]);
            }
        }
        return distance;
    }

    private static int[] findOtherPoint(Point p, int dr, int dc) {
        int[] info = new int[2];
        int distance = 0;
        int nr = p.r + dr;
        int nc = p.c + dc;
        if(!check(nr, nc)) return info;
        while(map[nr][nc] == 0) {
            nr += dr;
            nc += dc;
            if(!check(nr, nc)) return info;
            distance++;
        }
        info[0] = map[nr][nc] - 2;
        info[1] = distance;
        return info;
    }

    static void floodFill() {
        int k = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j, ++k);
                }
            }
        }
    }

    static void bfs(int r, int c, int k) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r, c});
        Island ls = new Island(k + 1);
        Point p = new Point(r, c, k + 1);
        ls.addPoint(p);
        map[r][c] = k+1;

        while (!que.isEmpty()) {
            int[] point = que.poll();
            for (int d = 0; d < 4; d++) {
                int nr = point[0] + dr[d];
                int nc = point[1] + dc[d];
                if(!check(nr, nc)) continue;
                if(map[nr][nc] != 1) continue;
                que.offer(new int[]{nr, nc});
                p = new Point(nr, nc, k + 1);
                ls.addPoint(p);
                map[nr][nc] = k + 1;

            }
        }

        islandList.add(ls);
    }
    private static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    private static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}
