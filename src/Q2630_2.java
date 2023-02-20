import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2630_2 {
    private static int n;
    private static int[][] map;
    static int count = 0;
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        solve(n, 0, 0);

        System.out.println(white);
        System.out.println(blue);
    }

    static void solve(int cnt, int r, int c) {

        if (check(cnt, r, c)) {
            if (map[r][c] == 0) {
                white++;
            }
            else {
                blue++;
            }
            return;
        }

        solve(cnt / 2, r, c);
        solve(cnt / 2, r, c + cnt / 2);
        solve(cnt / 2, r + cnt / 2, c);
        solve(cnt / 2, r + cnt / 2, c + cnt / 2);
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