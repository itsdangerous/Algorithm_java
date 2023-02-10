import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Q1012 {

    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {0, 0, -1, 1};
    static int N,M, K;
    static Deque<int[]> deque;
    static int[][] map;
    static String[] str;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int k = 0; k < T; k++) {
            result = 0;
            str = br.readLine().split(" ");
            M = Integer.parseInt(str[0]);
            N = Integer.parseInt(str[1]);
            K = Integer.parseInt(str[2]);
            map = new int[N][M];
            int result = 0;

            for (int i = 0; i < K; i++) {
                String[] s = br.readLine().split(" ");
                map[Integer.parseInt(s[1])][Integer.parseInt(s[0])] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        result += 1;
                        bfs(i, j);
                    }
                }
            }
            System.out.println(result);
        }
    }

    static void bfs(int r, int c) {
        deque = new LinkedList<>();
        deque.add(new int[]{r, c});

        while (!deque.isEmpty()) {
            int[] t = deque.poll();

            for (int i = 0; i < 4; i++) {
                int nc = t[1] + dc[i];
                int nr = t[0] + dr[i];

                if (nc < 0 || nc >= M || nr < 0 || nr >= N) {
                    continue;
                }
                if (map[nr][nc] == 0) {
                    continue;
                }
                if (map[nr][nc] == 1) {
                    map[nr][nc] = 0;
                    deque.add(new int[]{nr, nc});
                }
            }
        }
        return;
    }



}
