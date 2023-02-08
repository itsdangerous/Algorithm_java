import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2448 {
    static int[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());

        map = new int[n][2 * n - 1];
        star(0, 0, n);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                if (map[i][j] == 1) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");

        }
        System.out.println(sb.toString());

    }

    public static void star(int r, int c, int n) {
        if (n == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    if (i == 0) {
                        if (j!=2) {
                            continue;
                        }
                    } else if (i == 1) {
                        if(j%2==0) {
                            continue;
                        }
                    }
                    map[r+i][c+j] = 1;
                }
            }
        } else {
            star(r,c+n/2, n/2);
            star(r+n/2, c, n/2);
            star(r+n/2, c+n, n/2);
        }
    }
}