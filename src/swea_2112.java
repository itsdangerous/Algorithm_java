import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2112 {
    static int[][] map;
    static int N,M,K;
    static int answer;
    static boolean[] A;
    static boolean[] B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            A = new boolean[N];
            B = new boolean[N];

            map = new int[N][M];
            answer = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            combi(0, 0);

            System.out.println("#"+t+" "+answer);
        }
    }

    static void combi(int cnt, int start) {
        if (cnt == K + 1) {
            return;
        }

        if (isValid()) {
            answer = Math.min(answer, cnt);
        }

        for (int i = start; i < N; i++) {
            if (A[i]) continue;
            A[i] = true;
            combi(cnt + 1, i + 1);
            A[i] = false;

            if (B[i]) continue;
            B[i] = true;
            combi(cnt + 1, i + 1);
            B[i] = false;
        }
    }

    private static boolean isValid() {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            if (M >= 0) System.arraycopy(map[i], 0, tmp[i], 0, M);
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i]) {
                change(tmp, i, 0);
            }
        }

        for (int i = 0; i < B.length; i++) {
            if (B[i]) {
                change(tmp, i, 1);
            }
        }

        if (check_all(tmp)) {
            return true;
        }
        return false;
    }


    static boolean check_col(int[][] arr, int c) {
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i][c] == arr[i - 1][c]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt >= K) {
                return true;
            }
        }
        return false;
    }

    static boolean check_all(int[][] arr) {
        for (int i = 0; i < M; i++) {
            if (!check_col(arr, i)) {
                return false;
            }
        }
        return true;
    }

    static void change(int[][] arr, int row, int color) {
        for (int i = 0; i < M; i++) {
            arr[row][i] = color;
        }
    }
}
