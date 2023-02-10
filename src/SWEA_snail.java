import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_snail {
    static int[] dr = new int[] {0, 1, 0, -1};
    static int[] dc = new int[] {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            int row = 0;
            int col = -1;
            int t = 0;
            int k = 0;
            while (k < N * N) {
                k++;
                if (0 > row + dr[t] || row+dr[t] >= N || 0 > col+dc[t] || col+dc[t] >= N || map[row+dr[t]][col+dc[t]] != 0) {
                    t += 1;
                    if (t >= 4) {
                        t = t % 4;
                    }
                }
                map[row+dr[t]][col+dc[t]] = k;

                row+=dr[t];
                col+=dc[t];
            }

            System.out.printf("#%d\n", i);

            for (int j = 0; j < N; j++) {
                for (int l = 0; l < N; l++) {
                    System.out.print(map[j][l]+" ");
                }
                System.out.println();
            }
        }
    }

}
