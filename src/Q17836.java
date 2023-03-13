import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17836 {

    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static boolean haveSward;
    static int[] dr = new int[] {-1, 0, 1, 0};
    static int[] dc = new int[] {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        map = new int[N][M];

        //map 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = bfs(0, 0);
        if (0 <= time && time<= K) {
            System.out.println(time);
        }
        else {
            System.out.println("Fail");
        }
    }
    public static int bfs(int r, int c) {

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r, c});
        map[r][c] = 3;
        int cnt = 0;
        while (true) {
            int k = que.size();
            if (k == 0) break;
            cnt++;
            while (k-- > 0) {
                int[] p = que.poll();
                assert p != null;
                r = p[0];
                c = p[1];
                for (int i = 0; i < 4; i++) {
                    int nr = p[0] + dr[i];
                    int nc = p[1] + dc[i];
                    if (!check(nr, nc)) continue;
                    if (map[nr][nc] == 0) {
                        que.offer(new int[]{nr, nc});
                        map[nr][nc] = map[r][c];
                        if (nr == N - 1 && nc == M - 1) {
                            return cnt;
                        }
                    }
                    if(map[nr][nc] == 1) {
                        if(map[r][c] != 4) continue;
                        if(map[r][c] == 4) {
                            que.offer(new int[]{nr, nc});
                            map[nr][nc] = 4;
                        }
                    }
                    if (map[nr][nc]== 2) {
                        que.offer(new int[]{nr, nc});
                        map[nr][nc] = 4;
                    }
                    if (map[nr][nc] == 3) {
                        if (map[r][c] == 4) {
                            que.offer(new int[]{nr, nc});
                            map[nr][nc] = 4;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

}