package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2615 {

    static int[][] map = new int[21][21];

    // 오른 위 대각, 오른 가로, 오른 아래 대각, 아래 세로
    static int[] dr = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dc = new int[]{1, 1, 1, 0, -1, -1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 19; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 1; j <= 19; j++) {
                map[i][j] = Integer.parseInt(str[j - 1]);
            }
        }
        omok();
    }

    static void omok() {
        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                if (map[i][j] != 0 && search(i, j)) {
                    System.out.printf("%d\n%d %d\n", map[i][j], i, j);
                    return;
                }
            }
        }
        System.out.println(0);
    }

    static boolean search(int r, int c) {
        for (int i = 0; i < 4; i++) {
            if (map[r][c] != map[r + dr[i + 4]][c + dc[i + 4]]) {
                int cnt = 1;
                int nr = r;
                int nc = c;
//                System.out.println("r = " + r + ", c = " + c);
                while (true) {
                    nr = nr + dr[i];
                    nc = nc + dc[i];
//                    System.out.println("nr = " + nr + ", nc = " + nc);
                    if (map[r][c] == map[nr][nc]) {
                        cnt++;
                        continue;
                    }
                    if (map[r][c] != map[nr][nc]) {
                        if (cnt == 5) {
                            return true;
                        }
                        break;
                    }
                }
            }
        }
        return false;
    }
}