import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10816 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] plus_arr = new int[10000001];
        int[] minus_arr = new int[10000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num >= 0) {
                plus_arr[num]++;
            }
            else {
                minus_arr[-num]++;
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num >= 0) {
                sb.append(plus_arr[num] + " ");
            }
            else {
                sb.append(minus_arr[-num] + " ");
            }
        }
        System.out.println(sb);
    }
}