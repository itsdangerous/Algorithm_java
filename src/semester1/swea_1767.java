package semester1;/*
[swea_1767] 프로세서 연결하기
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4suNtaXFEDFAUf&
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_1767 {
    static int N, R, cntProcess, cntLines;
    static int[][] map;
    static ArrayList<int[]> processors;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            cntLines = Integer.MAX_VALUE;
            cntProcess = Integer.MIN_VALUE;
            R = 0;

            // 프로세서 입력 받기
            processors = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
//                        if(i == 0 || j == 0 || i == N-1 || j == N-1) continue;
                        processors.add(new int[]{i, j});
                        R++;
                    }
                }
            }

            dfs(0, 0, 0);

            System.out.printf("#%d %d\n", t, cntLines);
        }
    }

    static void dfs(int cnt, int connected, int total) {

        if (connected + (R - cnt) < cntProcess) return;

        if (cnt == R) {
            if (cntProcess < connected) {
                cntProcess = connected;
                cntLines = total;

            }
            else if (cntProcess == connected) {
                cntLines = Math.min(cntLines, total);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int t = markLine(processors.get(cnt)[0], processors.get(cnt)[1], i, cnt + 2);
            if (t != -1) {
                dfs(cnt + 1, connected + 1, total + t);
            }
            else {
                dfs(cnt + 1, connected, total);
            }
            unmarkLine(processors.get(cnt)[0], processors.get(cnt)[1], i, cnt + 2);
        }
    }

    static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    static int markLine(int r, int c, int d, int mark) {
        int cnt = 0;
        if (r == 0 || c == 0 || r == N-1 || c == N-1) return cnt;

        int nr = r + dr[d];
        int nc = c + dc[d];

        while (check(nr, nc)) {
            if (map[nr][nc] != 0) {
                unmarkLine(r, c, d, mark);
                return -1;
            }
            map[nr][nc] = mark;
            cnt++;
            nr += dr[d];
            nc += dc[d];
        }
        return cnt;
    }

    static void unmarkLine(int r, int c, int d, int mark) {
        if (r == 0 || c == 0 || r == N-1 || c == N-1) {
            return;
        }
        int nr = r + dr[d];
        int nc = c + dc[d];
        while (check(nr, nc)) {
            if (map[nr][nc] != mark) return;
            map[nr][nc] = 0;
            nr += dr[d];
            nc += dc[d];
        }
    }
}
