import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Q2178_2 {

    static Deque<int[]> deque;
    static int[][] map;
    static boolean[][] visited;

    static int N, M;
    static int cnt;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        // bfs 수행
        cnt = bfs(map, 0, 0, 1);
        System.out.println(cnt);
    }

    static int bfs(int[][] arr, int r, int c, int count) {

        deque = new LinkedList<>();
        deque.add(new int[]{r, c, count});

        while (!deque.isEmpty()) {
            int[] point = deque.poll();
            r = point[0];
            c = point[1];
            count = point[2];
            if (r == N - 1 && c == M - 1) {
                return count;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (check(nr, nc) && arr[nr][nc] == 1) {
                    arr[nr][nc] = 2;
                    deque.add(new int[]{nr, nc, count + 1});
                }
            }
        }
        return 0;
    }
    static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}