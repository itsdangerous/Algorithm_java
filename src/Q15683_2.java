import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15683_2 {
    static int N, M;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;
    static ArrayList<CCTV> cctvs;

    static class CCTV {
        private int r, c, type;
        private int[][] direction;


        public CCTV(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;

            if (type == 1) {
                direction = new int[][] {{dr[1],dc[1]}};
            }
            if (type == 2) {
                direction = new int[][]{{dr[1], dc[1]}, {dr[3], dc[3]}};
            }
            if (type == 3) {
                direction = new int[][]{{dr[0], dc[0]}, {dr[1], dc[1]}};
            }
            if (type == 4) {
                direction = new int[][]{{dr[0], dc[0]}, {dr[1], dc[1]}, {dr[2], dc[2]}};
            }
            if (type == 5) {
                direction = new int[][]{{dr[0], dc[0]}, {dr[1], dc[1]}, {dr[2], dc[2]}, {dr[3], dc[3]}};
            }
        }

        public void rotate(int n) {

            if (this.type == 1) {
                int a = (1 + n) % 4;
                direction = new int[][]{{dr[a], dc[a]}};
            }
            if (this.type == 2) {
                int a = (1 + n) % 4;
                int b = (3 + n) % 4;
                direction = new int[][]{{dr[a], dc[a]}, {dr[b], dc[b]}};
            }
            if (this.type == 3) {
                int a = n % 4;
                int b = (1 + n) % 4;
                direction = new int[][]{{dr[a], dc[a]}, {dr[b], dc[b]}};
            }
            if (this.type == 4) {
                int a = n % 4;
                int b = (n + 1) % 4;
                int c = (n + 2) % 4;
                direction = new int[][]{{dr[a], dc[a]}, {dr[b], dc[b]}, {dr[c], dc[c]}};
            }
            if (this.type == 5) {
                int a = n % 4;
                int b = (n + 1) % 4;
                int c = (n + 2) % 4;
                int d = (n + 3) % 4;
                direction = new int[][]{{dr[a], dc[a]}, {dr[b], dc[b]}, {dr[c], dc[c]}, {dr[d], dc[d]}};
            }
        }

    }

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        cctvs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= map[i][j] && map[i][j] <= 5) {
                    cctvs.add(new CCTV(i, j, map[i][j]));
                }
            }
        }
        dfs(0, map);
        System.out.println(answer);
    }

    static void dfs(int cnt, int[][] arr){
        if(cnt == cctvs.size()) {
            answer = Math.min(answer, countZero(arr));
            return;
        }

        CCTV cctv = cctvs.get(cnt);
        int[][] tmp;
        if (cctv.type == 1 || cctv.type == 3 || cctv.type == 4) {
            for (int i = 0; i < 4; i++) {
                cctv.rotate(i);
                tmp = copyArr(arr);
                execute(cctv, tmp);
                dfs(cnt + 1, tmp);
            }
        }
        if (cctv.type == 2) {

            for (int i = 0; i < 2; i++) {
                cctv.rotate(i);
                tmp = copyArr(arr);
                execute(cctv, tmp);
                dfs(cnt + 1, tmp);
            }
        }
        if (cctv.type == 5) {
            tmp = copyArr(arr);
            execute(cctv, tmp);
            dfs(cnt + 1, tmp);
        }

    }
    static int countZero(int[][] arr) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void execute(CCTV t, int[][] arr) {
        for (int j = 0; j < t.direction.length; j++) { // 방향 개수(this.direction.length) 만큼 direction = {{}}..
            int nr = t.r;
            int nc = t.c;
            while(true){
                nr += t.direction[j][0];
                nc += t.direction[j][1];
                if(!check(nr,nc)) break;
                if(arr[nr][nc] == 6) break;
                arr[nr][nc] = 7;
            }
        }
    }

    static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    static int[][] copyArr(int[][] arr) {

        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            if (M >= 0) System.arraycopy(arr[i], 0, tmp[i], 0, M);
        }
        return tmp;
    }

}
