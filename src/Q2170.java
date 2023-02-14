import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

        Arrays.sort(arr, (e1, e2)-> {
            if (e1[0] == e2[0]) {
                return e1[1] - e2[1];
            }
            return e1[0] - e2[0];
        });

        int start = arr[0][0];
        int end = arr[0][1];
        int result = 0;

        for (int i = 1; i < N; i++) {
            if (arr[i][0] <= end) {
                if (arr[i][1] > end) {
                    end = arr[i][1];
                }
            }
            else {
                result += end - start;
                start = arr[i][0];
                end = arr[i][1];
            }
        }

        result += end-start;

        print(result);
        }

    public static void print(Object... args) {
        StringBuilder sb = new StringBuilder();

        for (Object arg : args) {
            sb.append(arg).append(" ");
        }

        System.out.println(sb);
    }
}
