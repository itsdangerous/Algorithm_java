import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2206 {
    static int[][] map;
    static int N, M;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        int answer = bfs();
        System.out.println(answer);

    }

    static int bfs() {
        Queue<int[]> que = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][2];
        que.offer(new int[]{0, 0, 1});
        visited[0][0][1] = true;

        int cnt = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            cnt++;
            while (size-- > 0) {
                int[] point = que.poll();
                assert point != null;
                int r = point[0];
                int c = point[1];
                int possible = point[2];
                if (r == N-1 && c == M-1) return cnt;
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (!check(nr, nc)) continue;
                    if (visited[nr][nc][possible]) continue;
                    if (possible == 1) {
                        if (map[nr][nc] == 1) {
                            que.offer(new int[]{nr, nc, 0});
                            visited[nr][nc][0] = true;
                            visited[nr][nc][1] = true;
                        }
                        else {
                            que.offer(new int[]{nr, nc, 1});
                            visited[nr][nc][1] = true;
                        }
                    }
                    else { // possible == 0
                        if(map[nr][nc] == 1) continue;
                        que.offer(new int[]{nr, nc, 0});
                        visited[nr][nc][0] = true;
                    }

                }
            }
        }
        return -1;
    }

    static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

}