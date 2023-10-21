package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q10026 {
    static int N;
    static char[][] map;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    static int cntA, cntB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        boolean[][] visitedA = new boolean[N][N];
        boolean[][] visitedB = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        solve();

        System.out.println(cntA + " " + cntB);

    }

    static void solve() {

        boolean[][] visitedA = new boolean[N][N];
        boolean[][] visitedB = new boolean[N][N];

        char[][] mapA = copyMap(map);
        char[][] mapB = copyMap(map);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visitedA[i][j]) {
                    bfs(mapA, map[i][j], i, j, visitedA, 0);
                    cntA++;
                }
                if (!visitedB[i][j]) {
                    bfs(mapB, map[i][j], i, j, visitedB, 1);
                    cntB++;
                }
            }
        }
    }

    static void bfs(char[][] arr, char c, int i, int j, boolean[][] visited, int flag) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!que.isEmpty()) {
            int[] tmp = que.poll();

            for (int d = 0; d < 4; d++) {
                int nr = tmp[0] + dr[d];
                int nc = tmp[1] + dc[d];
                if(!check(nr, nc)) continue;
                if(visited[nr][nc]) continue;
                if(flag == 0) {
                    if (arr[nr][nc] != c) continue;
                    que.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
                if (flag == 1) {
                    if(c == 'R' || c == 'G') {
                        if(arr[nr][nc] == 'B') continue;
                    }
                    else {
                        if (arr[nr][nc] != c) continue;
                    }
                    que.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;

                }
            }
        }

    }

    static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    static char[][] copyMap(char[][] arr) {
        char[][] tmp = new char[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(arr[i], 0, tmp[i], 0, N);
        }
        return tmp;
    }
}
