import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_snail {
    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];

            int row = 0;
            int col = 0;

            int t = 0;
            int k = 1;
            while (k < N * N) {

                map[row+dx[t%4]][col+dy[t%4]] = k++;

                if (row + dx[t % 4] >= N || row+dx[t%4] < 0 || col+dy[t%4] >=N || col+dy[t%4] < 0 || map[row+dx[t%4]][col+dy[t%4]] != 0) {
                    t++;

                }
                row+=dx[t%4];
                col+=dy[t%4];

            }
            for (int j = 0; j < N; j++) {
                for (int l = 0; l < N; l++) {
                    System.out.print(map[j][l]+" ");
                }
                System.out.println();
            }


        }




    }

}
