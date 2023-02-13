import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2468 {
    static int N;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (max < num) {
                    max = num;
                }
            }
        }
        solve(map);
    }

    static void solve(int[][] arr) {

        int result = 0;
        for (int h =0; h <= max; h++) {
            boolean[][] visited = new boolean[N][N];
            int cnt = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (dfs(arr, h, r, c, visited, 0)) {
                        cnt++;
                    }
                }
            }
            if (result < cnt) {
                result = cnt;
            }

        }
        System.out.println(result);

    }

    static boolean dfs(int[][] arr, int h, int r, int c, boolean[][] visited, int t) {

        if (!visited[r][c]) {
            visited[r][c] = true;
            if (arr[r][c] > h) {
                t++;
                // dfs 드가즈아
                for (int i = 0; i < 4; i++) {
                    if (check(i, r, c)) {
                        dfs(arr, h, r + dr[i], c + dc[i], visited, t);
                    }
                }
            }

        }
        return t > 0;
    }

    static boolean check(int i, int r, int c) {
        return 0 <= r + dr[i] && r + dr[i] < N && 0 <= c + dc[i] && c + dc[i] < N;
    }
}
