package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q3055 {
    static int N, M;
    static char[][] map;
    static Queue<int[]> water_que;
    static Queue<int[]> beaver_que;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int dst_r ;
    static int dst_c ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        water_que = new LinkedList<>();
        beaver_que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'S') {
                    beaver_que.add(new int[]{i, j, 0});
                }
                if (map[i][j] == '*') {
                    water_que.add(new int[]{i, j});
                }
                if (map[i][j] == 'D') {
                    dst_r = i;
                    dst_c = j;
                }
            }
        }

        solve();


    }

    static void solve() {
        while(true) {
            // 비버가 물에 싹 다 죽었니~?
            if (beaver_que.size() == 0) {
                System.out.println("KAKTUS");
                return;
            }
            waterGo();
            int cnt  = beaverGo();
            if (cnt > 0) {
                System.out.println(cnt);
                return;
            }
        }
    }

    static void waterGo(){

        int size = water_que.size();
        while (size-- >0) {
            int[] point = water_que.poll();
            int r = point[0];
            int c = point[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (check(nr, nc)) {
                    if (map[nr][nc] == '.' || map[nr][nc] =='S') {
                        map[nr][nc] = '*';
                        water_que.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }

    static int beaverGo() {

        int size = beaver_que.size();
        while (size-- >0) {
            int[] point = beaver_que.poll();
            int r = point[0];
            int c = point[1];
            int distance=point[2];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (!check(nr, nc)) continue;;
                if (nr==dst_r && nc==dst_c) {
                    return distance + 1;
                }
                if (map[nr][nc] == '.') {
                    map[nr][nc] = 'S';
                    beaver_que.add(new int[]{nr, nc,distance+1});
                }
            }

        }
        return -1;
    }


    static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

}
