package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1189 {
    static int N, M, K;
    static char[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        map[N-1][0] = 'v';

        count = 0;
        dfs(0, N-1, 0);

        System.out.println(count);
    }

    public static void dfs(int cnt, int r, int c) {

        if (cnt == K-1 && r == 0 && c == M - 1) {
            count++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (check(nr, nc)) {
                if (map[nr][nc] == '.') {

                    map[nr][nc] = 'v';
                    dfs(cnt+1, nr, nc);
                    map[nr][nc] = '.';

                }
            }
        }
    }

    public static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

}