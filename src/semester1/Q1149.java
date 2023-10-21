package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1149 {

    static int N;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            map[i][0] += Math.min(map[i - 1][1], map[i - 1][2]);
            map[i][1] += Math.min(map[i - 1][0], map[i - 1][2]);
            map[i][2] += Math.min(map[i - 1][0], map[i - 1][1]);
        }
        System.out.println(Math.min(map[N - 1][0], Math.min(map[N - 1][1], map[N - 1][2])));



    }
}
