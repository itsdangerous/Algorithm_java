import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
BOJ Q17086 : 아기상어2
https://www.acmicpc.net/problem/17086
*/
public class Q17086 {
    static int R, C;
    static int[][] map;
    static int[] dr = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        System.out.println(answer);

    }

    private static void solve() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0) {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }
    }

    private static int bfs(int i, int j) {
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        que.offer(new int[]{i, j});
        visited[i][j] = true;

        int count = -1;
        while (!que.isEmpty()) {
            count++;
            int size = que.size();
            while (size-- > 0) {
                int[] point = que.poll();
                int r = point[0];
                int c = point[1];
                if(map[r][c] == 1) {
                    return count;
                }
                for (int d = 0; d < 8; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(!check(nr, nc)) continue;
                    if(visited[nr][nc]) continue;
                    que.offer(new int[]{nr, nc});
                    visited[nr][nc] =true;
                }
            }
        }
        return -1;
    }

    static boolean check(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

}
