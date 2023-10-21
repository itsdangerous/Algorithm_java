package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2138 {
    static int N;
    static int[] cur;
    static int[] tar;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cur = new int[N];
        tar = new int[N];

        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            cur[i] = s.charAt(i) - '0';
        }

        s = br.readLine();
        for (int i = 0; i < N; i++) {
            tar[i] = s.charAt(i) - '0';
        }

        solve();
    }

    static void solve() {
        // 첫 번째 전구를 누르지 않는 경우
        int cnt1 = 0;
        int[] prev = copy(cur);
        for (int i = 1; i < N; i++) {
            if (prev[i - 1] != tar[i - 1]) {
                cnt1 += 1;
                for (int j = i-1; j < i+2; j++) {
                    if (j < N) {
                        prev[j] ^=1 ;
                    }
                }
            }
        }
        // 첫 번째 전구를 누르는 경우
        int cnt2 = 1;
        cur[0] ^= 1;
        cur[1] ^= 1;
        for (int i = 1; i < N; i++) {
            if (cur[i - 1] != tar[i - 1]) {
                cnt2 += 1;
                for (int j = i - 1; j < i + 1; j++) {
                    if (j < N) {
                        cur[j] ^= 1;
                    }
                }
            }
        }

        if (Arrays.equals(cur, tar)) {
            System.out.println(Math.min(cnt1, cnt2));

        } else {
            System.out.println(-1);
        }
    }

    static int[] copy(int[] arr) {
        int[] tmp = new int[arr.length];
        System.arraycopy(arr, 0, tmp, 0, arr.length);
        return tmp;
    }
    
}