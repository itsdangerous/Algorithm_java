package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q20010
{
    static int N, M;
    static int[][] dist;
    static PriorityQueue<Edge> pq;
    static int min;
    static int max;
    static int [] parent;
    static int [] rank;
    static boolean[][] visited;
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
        makeSet();
        kruskal();
//        printArr(dist);
        dfsFor();
        System.out.println(min);
        System.out.println(max);

    }

    private static void dfsFor() {
        for (int i = 0; i < N; i++) {
            visited = new boolean[N][N];
            dfs(i, dist, 0);
        }
    }

    private static void dfs(int r, int[][]arr, int hap) {
        int cnt = 0;
        for (int c = 0; c < N; c++) {
            if (!visited[r][c] && arr[r][c] != 0) cnt++;
        }
        if (cnt == 0) {
            max = Math.max(max, hap);
        }
        if(hap == 0 && cnt > 1) return;

        for (int c = 0; c < N; c++) {
            if (arr[r][c] == 0) continue;
            if (visited[r][c]) continue;

            visited[r][c] = true;
            visited[c][r] = true;
            dfs(c, arr, hap + arr[r][c]);
            visited[r][c] = false;
            visited[c][r] = false;
        }
    }

    private static int[][] copyArr(int[][] arr) {
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(arr[i], 0, tmp[i], 0, N);
        }
        return tmp;
    }

    private static void kruskal() {
        min = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (union(edge.s, edge.e)) {
                dist[edge.s][edge.e] = edge.w;
                dist[edge.e][edge.s] = edge.w;
                min+=edge.w;
            }
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

    private static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}