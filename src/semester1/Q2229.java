package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2229 {
    static int N;
    static int[] point;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        point = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            point[i] = Integer.parseInt(st.nextToken());
        }
        solveDp();
        System.out.println(answer);
    }
    static void solveDp() {
        int[] dp = new int[N + 1];
        dp[0] = 0;

        for (int i = 2; i < N + 1; i++) {
            int min = point[i];
            int max = point[i];
            for (int j = i; j >= 1; j--) {
                max = Math.max(max, point[j]);
                min = Math.min(min, point[j]);
                dp[i] = Math.max(dp[i], dp[j - 1] + max - min);
            }
        }
        answer = dp[N];
    }

}
