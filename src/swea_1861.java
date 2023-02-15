import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1861 {
    static int[][] rooms;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N;
    static Queue<int[]> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            rooms = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int room = Integer.parseInt(st.nextToken());
                    rooms[i][j] = room;
                }
            }
            int answer_room = 0;
            int answer_cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int cnt = bfs(rooms, i, j);
                    if (answer_cnt < cnt) {
                        answer_cnt = cnt;
                        answer_room = rooms[i][j];
                    }
                    if (answer_cnt == cnt) {
                        answer_room = Math.min(rooms[i][j], answer_room);
                    }
                }
            }
            System.out.printf("#%d %d %d\n", t, answer_room, answer_cnt);
        }
    }

    static int bfs(int[][] arr, int r, int c) {
        q = new LinkedList<>();
        int cnt = 0;
        q.add(new int[]{r, c});
        cnt++;

        while (!q.isEmpty()) {
            int[] room = q.poll();
            r = room[0];
            c = room[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (check(nr, nc)) {
                    if (arr[nr][nc] - arr[r][c] == 1) {
                        q.add(new int[] {nr, nc});
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}
