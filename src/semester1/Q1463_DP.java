package semester1;

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

        Arrays.fill(dp, N);

        solveDp(N, 0);
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[1]);
    }

    static void solveDp(int n, int cnt) {
        if (n == 0) return;
        if (n == 1) {
            dp[n] = cnt;
            return;
        }

        if (n % 3 == 0 && dp[n / 3] > cnt + 1) {
            dp[n/3] = cnt+1;
            solveDp(n / 3, cnt + 1);
        }
        if (n % 2 == 0 && dp[n / 2] > cnt + 1) {
            dp[n/2] = cnt+1;
            solveDp(n / 2, cnt + 1);
        }
        if (dp[n-1] > cnt + 1) {
            dp[n-1] = cnt+1;
            solveDp(n -1, cnt + 1);
        }

    }
}