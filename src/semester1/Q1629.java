package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1629 {
    static long A,B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long answer = power(B);
        System.out.println(answer);
    }

    public static long power(long b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return A % C;
        }

        long k = power(b / 2) % C;
        if(b%2 == 0) return k * k % C;
        else return k * k % C * A % C;
    }

}
