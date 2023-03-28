import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11726 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 1001;
        int[] pibo = new int[N];
        pibo[0] = 1;
        pibo[1] = 1;

        int K = Integer.parseInt(br.readLine());
        for (int i = 2; i <= K; i++) {
            pibo[i] = (pibo[i-2] + pibo[i-1])%10007;
        }
        System.out.println(pibo[K]);

    }
}
