package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    if (j == 0) {
                        map[i][j] = value;
                    }
                    else { // j > 0
                        map[i][j] = value + map[i][j-1];
                    }
                }
                else{
                    if (j ==0) {
                        map[i][j] = value + map[i - 1][j];
                    }
                    else {
                        map[i][j] = value + map[i - 1][j] + map[i][j - 1] -map[i-1][j-1];
                    }
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            int answer = 0;
            if (x1 == 0) {
                if (y1 == 0) {
                    answer = map[x2][y2];
                }
                else {
                    answer = map[x2][y2] - map[x2][y1-1];
                }
            }
            else {
                if (y1 == 0) {
                    answer = map[x2][y2] - map[x1-1][y2];
                }
                else {
                    answer = map[x2][y2] - map[x1-1][y2] - map[x2][y1-1] + map[x1-1][y1-1];
                }
            }


            System.out.println(answer);
        }

    }

}