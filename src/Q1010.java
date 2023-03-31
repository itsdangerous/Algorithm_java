import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q1010 {

    static int[][] dp;
    static int N, R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            dp = new int[N + 1][N + 1];
            dp[0][0] = 1;
            for (int r = 1; r <= N; r++) {
                dp[r][0] = 1;
                dp[r][r] = 1;
                for (int c = 1; c < r; c++) {
                    dp[r][c] = dp[r - 1][c - 1] + dp[r - 1][c];
                }
            }
            System.out.println(dp[N][R]);
        }

    }

}
