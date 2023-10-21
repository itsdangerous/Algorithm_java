package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1976 {

    static int N, M;
    static int[] parent;
    static int[][] graph;
    static int[] plan;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N];
        plan = new int[M];
        graph = new int[N][N];
        makeSet();

        //그래프 입력 받기
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                graph[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 그래프는 y=-x 그래프를 기준(?)으로 대칭이기 때문에, 오른쪽 삼각형에 대해서만 비교하여 1이면 union해줌
        for (int r = 0; r < N; r++) {
            for (int c = r+1; c < N; c++) {
                if(graph[r][c] == 1) {
                    union(r, c);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(st.nextToken())-1;
        }

        Trip();
    }

    private static void makeSet() {
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }

    private static int find(int x) {
        if (x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int py = find(y);
        parent[py] = find(x);
    }

    // 그래프가 연결되어있는지 판단하는 메서드
    private static void Trip() {
        int flag = find(parent[plan[0]]);
        for (int i = 1; i < M; i++) {
            if (find(parent[plan[i]]) != flag) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    
}
