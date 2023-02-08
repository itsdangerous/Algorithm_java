import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2630 {
    private static int n;
    private static int[][] map;
    private static int blue;
    private static int white;

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

        shagi_cut(0, 0, n);

        System.out.println(white);
        System.out.println(blue);

    }

    public static void shagi_cut(int r, int c, int n) {


        int tmp = map[r][c];
        boolean check = true;
        a:
        for (int i = r; i < r+n; i++) {
            for (int j = c; j < c+n; j++) {
                if (map[i][j] != tmp) {
                    check = false;
                    break a;
                }
            }
        }

        if (check) {
            if (tmp == 1) {
                blue++;
                return;
            } else {
                white++;
                return;
            }
        }

        n = n / 2;

        shagi_cut(r, c, n);
        shagi_cut(r, c + n, n);
        shagi_cut(r + n, c, n);
        shagi_cut(r + n, c + n, n);
    }
}