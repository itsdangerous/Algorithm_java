package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q17136 {

    static final int N = 10;
    static final int INF = Integer.MAX_VALUE;
    static int [][] map;
    static int min = Integer.MAX_VALUE;
    static int[] papers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[N][N];
        papers = new int[6];
        for (int i = 1; i <= 5; i++) {
            papers[i] = 5;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
        if (min == INF) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    private static void dfs(int r, int c, int tot) {
        if(tot > min) {
            return;
        }
        boolean isEntry = false;

        for (int i = r; i < N; i++) {
            int tmp = (i==r) ? c : 0;
            for (int j = tmp; j < N; j++) {
                if (map[i][j] == 1) {
                    for (int k = 1; k <= 5; k++) {
                        if (isDrawing(i, j, k)) {
                            if (papers[k] <= 0) continue;
                            papers[k]--;
                            Drawing(i, j, k, 0);
                            dfs(i, j, tot + 1);
                            Drawing(i, j, k, 1);
                            papers[k]++;
                        }
                    }
                    return;
                }
            }
        }
        if(!isEntry){
            min = Math.min(min,tot);
        }

    }

    private static boolean isDrawing(int r, int c, int k) {
        for (int i = r; i < r + k; i++) {
            for (int j = c; j < c + k; j++) {
                if(!check(i, j)) return false;
                if (map[i][j] != 1) return false;
            }
        }
        return true;
    }

    private static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    private static void Drawing(int r, int c, int k, int num) {
        for (int i = r; i < r + k; i++) {
            for (int j = c; j < c + k; j++) {
                map[i][j] = num;
            }
        }
    }
}
