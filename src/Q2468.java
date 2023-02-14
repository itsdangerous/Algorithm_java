import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2468 {
    static int N;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(map);
    }

    static void solve(int[][] arr) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            visited = new boolean[N][N];
            int t = dfs(arr, i, visited, 0, 0);
            if (cnt < t) {
                cnt = t;
            }
        }
        System.out.println(cnt);
    }

    static int dfs(int[][] arr,int n, boolean[][] visited, int r, int c) {

        if (!visited[r][c]) {
            visited[r][c] = true;
            if (arr[r][c] > n) {
                for (int i = 0; i < 4; i++) {
                    if (0 <= r + dr[i] && r + dr[i] <= N) {
                        dfs(arr, n, visited, r + dr[i], c + dc[i]);
                    }
                }
            }

        }


    }
}
