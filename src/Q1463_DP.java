import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1463_DP {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        Arrays.fill(dp, -1);

        solveDp(N);
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[1]);
    }

    static int solveDp(int n) {
        if (dp[n] != -1) {
            return dp[n];
        }

        if (n % 3 == 0) {
            dp[n] = Math.min(dp[n], solveDp(n / 3));
        }
        if (n % 2 == 0) {
            dp[n] = Math.min(dp[n], solveDp(n / 2));
        }
        dp[n] = Math.min(dp[n], solveDp(n - 1));

        return dp[n];
    }
}