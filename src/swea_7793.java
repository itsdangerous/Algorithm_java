import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_7793 {
    static char[][] map;
    static int N, M;
    static int dst_r;
    static int dst_c;
    static Queue<int[]> devils;
    static Queue<int[]> sooyeon;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            devils = new LinkedList<>();
            sooyeon = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == 'D') {
                        dst_r = i;
                        dst_c = j;
                    }
                    if (map[i][j] == '*') {
                        devils.add(new int[]{i, j});
                    }
                    if (map[i][j] == 'S') {
                        sooyeon.add(new int[]{i, j, 0});
                    }
                }
            }

            System.out.printf("#%d ",t);
            solve();

        }

    }

    static void solve() {

        while (true) {
            if (sooyeon.size() == 0) {
                System.out.println("GAME OVER");
                return;
            }
            moveDevil();
            int cnt = moveSooyeon();
            if (cnt > 0) {
                System.out.println(cnt);
                return;
            }
        }
    }

    static int moveSooyeon() {

        int size = sooyeon.size();
        while (size-- > 0) {
            int[] point = sooyeon.poll();
            int r = point[0];
            int c = point[1];
            int distance = point[2];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(!check(nr, nc)) continue;
                if (nr == dst_r && nc == dst_c) {
                    return distance + 1;
                }
                if (map[nr][nc] == '.') {
                    map[nr][nc] = 'S';
                    sooyeon.add(new int[]{nr, nc, distance+1});
                }
            }

        }
        return -1;

    }

    static void moveDevil() {

        int size = devils.size();
        while (size-- > 0) {
            int[] point = devils.poll();
            int r = point[0];
            int c = point[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(!check(nr, nc)) continue;
                if (map[nr][nc] == '.'||map[nr][nc] == 'S') {
                    map[nr][nc] = '*';

                    devils.add(new int[]{nr, nc});
                }
            }
        }
    }




    static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}
