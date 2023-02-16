import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Permutation_bitMasking {
    static int[] numbers, input;
    static int N,R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int R = Integer.parseInt(br.readLine());

        input = new int[N];
        numbers = new int[R];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(R);
        permutation(0,0);

    }

    static void permutation(int cnt, int flag) {
        if (cnt == R) {
            System.out.println(Arrays.toString(numbers));
        }
        for (int i = 0; i < N; i++) {
            if ((flag & (1<<i)) != 0) continue;

            numbers[cnt] = input[i];
            permutation(cnt + 1, flag | (i<<1));
            numbers[cnt] = 0;

        }
    }
}
