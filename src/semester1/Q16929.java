package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16929 {
    static final int K = 4;
    static char[][] map;
    static int N, M;
    static int answer;
    static int[] startPoint;
    static boolean[][] visited;

    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        solve();
    }

    static void solve() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                startPoint = new int[]{i, j};
                visited = new boolean[N][M];
                if (dfs(1, i, j)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }

    private static boolean dfs(int cnt, int r, int c) {
        if(r == startPoint[0] && c == startPoint[1]) {
            if(cnt > 3)  {
                return true;
            }
        }
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (!check(nr, nc)) continue;
            if (visited[nr][nc]) continue;
            if (map[nr][nc] != map[startPoint[0]][startPoint[1]]) continue;
            visited[nr][nc] = true;
            if (dfs(cnt + 1, nr, nc)) {
                return true;
            }
        }
        return false;
    }

    private static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}