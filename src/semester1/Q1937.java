package semester1;/*
BOJ Q1937 : 욕심쟁이 판다
https://www.acmicpc.net/problem/1937
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1937 {
    static int N;
    static int[][] map;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] dp;
    static int max;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

    }
    static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }
        System.out.println(answer);
    }
//            System.out.printf("cnt = %d, r = %d, c = %d, startR = %d, startC = %d, cnt + dp[r][c] = %d\n", cnt, r, c, rr, cc, cnt + dp[r][c]);

    static int dfs(int r, int c) {

        if(dp[r][c] > 0) return dp[r][c];
        dp[r][c] = 1;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!check(nr, nc)) continue;
            if (map[nr][nc] <= map[r][c]) continue;
            dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
        }
        return dp[r][c];
    }

    static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    static void printArr(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}