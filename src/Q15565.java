import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15565 {
    static int N, K;
    static ArrayList<Integer> list;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n == 1) {
                list.add(i);
            }
        }

        solve();
    }
    public static void solve() {
        int size = list.size();
        if (size < K) {
            System.out.println(-1);
            return;
        }
        int min = Integer.MAX_VALUE;
        int p = 0;
        while (p + K - 1 < size) {
            int point1 = list.get(p);
            int point2 = list.get(p + K - 1);
            min = Math.min(min, point2 - point1 + 1);
            p++;
        }
        System.out.println(min);
    }
    
}
