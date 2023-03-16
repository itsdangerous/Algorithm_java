import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q25603 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            arr[i][0] = tmp;
            arr[i][1] = i;
        }
        int k = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i - 1][0] < arr[i][0]) {
                k++;

            }
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        System.out.println(Arrays.deepToString(arr));

        for (int i = 0; i < N; i++) {
            arr[i][0] = i+1;
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));
        System.out.println(Arrays.deepToString(arr));


    }
}
