import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16929_rectangleVer {
    static final int K = 4;
    static char[][] map;
    static int N, M;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        solve();
    }

    static void solve() {

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (findCircle(i, j)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }

    private static boolean findCircle(int r, int c) {
        boolean isS = false;
        for (int rk = 1; rk < N - r; rk++) {
            for (int ck = 1; ck < M - c; ck++) {
                if(rotate(r, c, rk, ck)) return true;
            }
        }
        return false;
    }

    private static boolean rotate(int r, int c, int rk, int ck) {
        for (int i = 0; i <= rk; i++) {
            if (i == 0 || i == rk) {
                for (int j = 0; j <= ck; j++) {
                    if (map[r][c] != map[r + i][c + j]) return false;

                }
            } else {
                if (map[r][c] != map[r + i][c] || map[r][c] != map[r + i][c + ck]) return false;
            }

        }
        return true;
    }
}