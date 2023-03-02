import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2468_2 {
    static int[][] map;
    static int N;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int max_h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        max_h = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max_h = Math.max(max_h, map[i][j]);
            }
        }
        int answer = solve();
        System.out.println(answer);

    }

    // 높이 h에 따른 getIsland 호출 후, 최대값 찾기
    static int solve() {
        int result = 0;
        for (int i = 0; i < max_h; i++) {
            result = Math.max(result, getIsland(i));
        }
        return result;
    }


    // 비가 h만큼 왔을 때 섬의 개수를 반환하는 메서드
    static int getIsland(int h) {
        //배열 복사
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] <= h) continue;
                tmp[i][j] = 1;
            }
        }

        int cnt = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && tmp[i][j] != 0) {
                    cnt++;
                    bfs(tmp, i, j);
                }
            }
        }
        return cnt;
    }

    static void bfs(int[][] arr, int r, int c) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r, c});
        visited[r][c] = true;

        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            int r1 = tmp[0];
            int c1 = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nr = r1 + dr[i];
                int nc = c1 + dc[i];
                if(!check(nr,nc)) continue;
                if(visited[nr][nc]) continue;
                if(arr[nr][nc] == 0) continue;
                que.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }

    static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

}