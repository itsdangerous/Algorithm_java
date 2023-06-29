import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2512 {
    static int[] budgets;
    static int N;
    static int M;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        budgets = new int[N];
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());


        solve();



    }
    static void solve() {
        Arrays.sort(budgets);

        int start = 0;
        int end = budgets[N-1];

        while (start <= end) {
            int mid = (start + end) / 2;
            int cur = 0;
            for (int i = 0; i < N; i++) {
                cur += Math.min(budgets[i], mid);
            }
            if (cur <= M) {
                start = mid +1;
            }
            else {
                end = mid -1;
            }
        }
        System.out.println(end);
    }
    public static void print ( int[] arr){
        for (int i : arr) {
            System.out.println(i + " ");
        }
    }

}
