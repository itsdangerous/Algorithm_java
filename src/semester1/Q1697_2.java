package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1697_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int next = 0;
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        int result = 0;

        if (k <= n) {
            System.out.println(n-k);
            return;
        }

        String N = Integer.toBinaryString(n);
        String K = Integer.toBinaryString(k);

        int[] power_index = new int[N.length()];

        int move = K.length() - N.length();

        for (int i = 0; i < N.length(); i++) {
            if (N.charAt(i) != K.charAt(i)) {
                power_index[N.length() - 1 - i] = 1;
            }
        }
        for (int i = 0; i < power_index.length; i++) {
            if (power_index[i] == 1) {
                result += 1 << i;
            }
        }
        for (int i = N.length(); i < K.length(); i++) {
            if (K.charAt(i) == '1') {
                result++;

            }
            result++;

        }
        System.out.println(result);
    }
}
