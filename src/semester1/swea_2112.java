package semester1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_2112 {
    static final int A_COLOR = 0;
    static final int B_COLOR = 1;
    static final int NO = 2;

    static int[] p;
    static boolean[] visited;
    static int N;
    static int D,W, K;
    static int[][] film;
    static boolean isS;
    static int[] color;
    static int min;
//
//    public static void setInput(String path, String fileName) throws FileNotFoundException {
//        String projectPath = System.getProperty("user.dir");
//        System.setIn(new FileInputStream(projectPath + path + fileName));
//    }
    public static void main(String[] args) throws IOException {
//        String path = "//src//tc//";
//        String file = "test.txt";
//        setInput(path, file);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int TC = 1; TC < T+1; TC++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            min = D;
            visited = new boolean[D];
            film = new int[D][W];
            p = new int[D];
            color = new int[D];
            for (int i = 0; i < D; i++) {
                p[i] = i;
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            power(0, 0);
            System.out.printf("#%d %d\n", TC, min);
        }

    }


    static void power(int cnt, int colorCnt) {
        if (colorCnt >= min) return;

        if (cnt == D) {
            System.out.println(Arrays.toString(color));
            if (isS(color)) {
                min = Math.min(min, colorCnt);
            }
            return;
        }

        color[cnt] = A_COLOR;
        power(cnt+1, colorCnt+1);
        color[cnt] = B_COLOR;
        power(cnt+1, colorCnt+1);
        color[cnt] = NO;
        power(cnt+1, colorCnt);
    }

    private static boolean isS(int[] color) {
        int[][] copied = copyArr(film);
        drawing(copied, color);
        for (int c = 0; c < W; c++) {
            int r = 0;
            int cnt = 1;
            while (r < D-1) {
                if (cnt >= K) break;
                r++;
                if (copied[r][c] == copied[r-1][c]) cnt++;
                else cnt = 1;
            }
            if (cnt < K) return false;
        }
        return true;
    }

    private static void drawing(int[][] arr, int[] color) {
        for (int i = 0; i < D; i++) {
            if (color[i] <= 1) {
                Arrays.fill(arr[i], color[i]);
            }
        }
    }


    static int[][] copyArr(int[][] arr) {
        int[][] tmp = new int[D][W];
        for (int i = 0; i < D; i++) {
            if (W >= 0) System.arraycopy(arr[i], 0, tmp[i], 0, W);
        }
        return tmp;
    }

}