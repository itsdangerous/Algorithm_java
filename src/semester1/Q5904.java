package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5904 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int len = 3;
        int nn = 0;

        while (N > len) {
            nn++;
            len = len*2+nn+3;
        }
        char answer = moo(len, nn + 3, N);
        System.out.println(answer);
    }

    static public char moo(int len, int current, int N) {
        int prev = (len - current) / 2;
        if (N <= prev) {
            return moo(prev, current - 1, N);
        }
        if (N > prev + current) {
            return moo(prev, current - 1, N - prev - current);
        }
        else {
            if (N - prev - 1 == 0) {
                return 'm';
            }
            return 'o';
        }
    }
    
}
