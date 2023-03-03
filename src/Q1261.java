import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1261 {

    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    static final int INF = Integer.MAX_VALUE;
    static int[][] map;
    static int N;
    static int M;
    static boolean[][] visited;
    static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        answer = 0;
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }

        bfs();
        System.out.println(answer);

    }

    static void bfs(){
        Queue<int[]> que = new PriorityQueue<>((v1, v2) -> v1[2]-v2[2]);
        int[][] cost = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cost[i][j] = INF;
            }
        }

        int r = 0;
        int c = 0;
        int w = map[0][0];
        cost[r][c] = map[r][c];
        que.offer(new int[]{r, c, w});

        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            r = tmp[0];
            c = tmp[1];
            w = tmp[2];
            visited[r][c] = true;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(!check(nr,nc)) continue;
                int nw = w + map[nr][nc];
                if (nw < cost[nr][nc]) {
                    cost[nr][nc] = nw;
                    que.offer(new int[]{nr, nc, nw});
                }
            }
        }
        answer = cost[N - 1][M - 1];

    }

    private static boolean check(int nr, int nc) {
        return 0 <= nr && nr < N && 0 <= nc && nc < M;
    }

    static void printMap(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(Arrays.toString(arr[i]) + " ");
            }
            System.out.println();
        }
    }
}
