package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1992 {
    private static int n;
    private static int[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }

        solve(n, 0, 0);
        System.out.println(sb);
    }

    static void solve(int cnt, int r, int c) {

        if (check(cnt, r, c)) {
            if (map[r][c] == 0) {
                sb.append(0);
            }
            else {
                sb.append(1);
            }
            return;
        }
        sb.append("(");
        solve(cnt / 2, r, c);
        solve(cnt / 2, r, c + cnt / 2);
        solve(cnt / 2, r + cnt / 2, c);
        solve(cnt / 2, r + cnt / 2, c + cnt / 2);
        sb.append(")");
    }

    static boolean check(int cnt, int r, int c ) {
        int tmp = map[r][c];
        for (int i = r; i < r+cnt; i++) {
            for (int j = c; j < c+cnt; j++) {
                if (map[i][j] != tmp) {
                    return false;
                }
            }
        }
        return true;
    }


}