import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class Test{
    static class Edge implements Comparable<Edge>{
        int u, v, w;

        public Edge(int u, int v, int w) {
            super();
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }

    }
    static int N, K, ans1, ans2;
    static PriorityQueue<Edge> pq;
    static int[] p, r;
    static ArrayList<Edge>[] lists;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        lists = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            lists[i] = new ArrayList<>();
        }
        pq = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            pq.add(new Edge(a, b, c));
        }

        //최소 스패닝 트리 만들기
        makeSet();
        int cnt = 0;
        while(cnt != N-1) {
            Edge edge = pq.poll();
            if(union(edge.u, edge.v)) {
                cnt++;
                ans1 += edge.w;
                //최소 스패닝 트리를 이루는 간선을 리스트 배열에 저장
                lists[edge.u].add(edge);
                lists[edge.v].add(new Edge(edge.v, edge.u, edge.w));
            }
        }

        for (int i = 0; i < N; i++) {
            //각 마을에 대해서 다른 마을로 가는 가장 먼 거리를 구하고 그 중 최대를 갱신해나감
            visited = new boolean[N];
            visited[i] = true;
            ans2 = Math.max(ans2,  dfs(i));
        }
        System.out.println(ans1);
        System.out.println(ans2);
    }

    static int dfs(int start) {
        //start번 마을에서 갈 수 있는 경로들을 완전 탐색
        int sum = 0;
        int size = lists[start].size();
        for (int i = 0; i < size; i++) {
            Edge edge = lists[start].get(i);
            //이미 지나온 마을이면 다시 못 가도록 처리
            if(visited[edge.v]) continue;
            visited[edge.v] = true;
            //지나오지 않은 마을이면 그 마을을 인자로 하는 재귀 메서드 실행
            sum = Math.max(sum, dfs(edge.v) + edge.w);
        }
        return sum;
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) return false;
        if(r[x] < r[y]) {
            r[y]++;
            p[x] = y;
        }else {
            r[x]++;
            p[y] = x;
        }
        return true;
    }

    static int find(int x) {
        if(x == p[x]) return x;
        return p[x] = find(p[x]);
    }
    static void makeSet() {
        p = new int[N];
        r = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;
            r[i] = 1;
        }
    }
}