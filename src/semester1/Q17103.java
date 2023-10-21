package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17103 {

    static boolean[] primes;
    static int K = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        primes = new boolean[K * 2 + 1];
        makeEratos(K);

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int cnt = 0;

            for (int j = 2; j < N/2+1; j++) {
                if (!isPrime(j)) {
                    if (!isPrime(N - j)) {
                        cnt++;
//                        System.out.println(N+" "+ (N-j)+" "+ j);
                    }
                }
            }
            System.out.println(cnt);

        }


    }

    public static void makeEratos(int K) {
        primes[1] = true;
        for (int i = 2; i <= K; i++) {
            for (int j = 2; i * j <= K; j++) {
                primes[i * j] = true;
            }
        }
    }

    public static boolean isPrime(int n) {
        return primes[n];
    }
}
