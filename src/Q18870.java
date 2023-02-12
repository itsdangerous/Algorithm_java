import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q18870 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][3];
        arr[0] = new int[]{Integer.MIN_VALUE, -1};

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
        }

        Arrays.sort(arr, Comparator.comparingInt(e -> e[0])); // x값에 기준 오름차순 정렬

        // 좌표 압축
        int k = -1;
        for (int i = 1; i < N+1; i++) {
            if (arr[i][0] != arr[i -1][0]) {
                arr[i][2] = ++k;
            }
            else {
                arr[i][2] = k;
            }
        }

        Arrays.sort(arr, Comparator.comparingInt(e -> e[1])); // index를 기준으로 정렬


        for (int i = 1; i < N + 1; i++) {
            sb.append(arr[i][2]).append(" ");
        }
        System.out.println(sb);
    }
}
