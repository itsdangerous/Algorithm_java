import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_battlefield {
    static char[][] map;
    static char[] point = new char[]{'.', '*', '#', '-', '^', '>', 'v', '<'};
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static char[] move = {'U', 'R', 'D', 'L'};
    static int H,W;
    static int K;
    static String str;
    static char heading;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];

            int start_r = 0;
            int start_c = 0;

            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                for (int j = 0; j < W; j++) {
                    char c = str.charAt(j);
                    map[i][j] = c;
                    for (int k = 4; k < point.length; k++) {
                        if (c == point[k]) {
                            start_r = i;
                            start_c = j;
                            heading = move[k - 4];
                            break;
                        }
                    }
                }
            }
            K = Integer.parseInt(br.readLine());
            str = br.readLine();

            play(0, start_r, start_c);
            System.out.printf("#%d ", t);
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }

    static void play(int cnt, int r, int c) {
        if (cnt >= K) {
            return;
        }

        // 움직일 때
        for (int i = 0; i < 4; i++) {
            if (str.charAt(cnt) == move[i]) {
                int nr=r+dr[i];
                int nc=c+dc[i];
                if (check(nr, nc)) {
                    heading = move[i];
                    print(cnt, r, c, i, map[nr][nc]);
                    if (map[nr][nc] == '.') {
                        map[nc][nc] = point[i + 4]; //스
                        map[r][c] = '.'; // 왑
                        play(cnt+1, nr, nc);
                    }

                    else {
                        play(cnt+1, r, c);
                    }
                }
            }
        }

        // 쏠 수있어!!!
        if (str.charAt(cnt) == 'S') {
            if (heading == 'U') {
                int k = 1;
                while (r - k >= 0) {
                    if (map[r - k][c] == '*') {
                        map[r - k][c] = '.';
                        break;
                    }
                    play(cnt+1, r,c);
                    k++;
                }

            }

            if (heading == 'R') {
                int k = 1;
                while (c + k < W) {
                    if (map[r][c + k] == '*') {
                        map[r][c + k] = '.';
                        break;
                    }
                    play(cnt+1, r,c);
                    k++;
                }
            }

            if (heading == 'D') {
                int k = 1;
                while (r + k < W) {
                    if (map[r + k][c] == '*') {
                        map[r + k][c] = '.';
                        break;
                    }
                    play(cnt+1, r,c);
                    k++;
                }
            }

            if (heading == 'L') {
                int k = 1;
                while (c-k >= 0) {
                    if (map[r][c - k] == '*') {
                        map[r][c - k] = '.';
                        break;
                    }
                }
                play(cnt+1, r,c);
                k++;
            }

        }
    }

    static boolean check(int r, int c) {
        return 0 <= r && r  < H && 0 <= c  && c < W;
    }

    public static void print(Object... args) {
        StringBuilder sb = new StringBuilder();

        for (Object arg : args) {
            sb.append(arg).append(" ");
        }

        System.out.println(sb);
    }
}
