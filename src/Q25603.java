import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q25603 {
    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int startIndex = 0;
        int max = 0;
        while (startIndex < N - K+1) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = startIndex; i < startIndex + K; i++) {
                //슬라이스를 startIndex부터 탐색하면서 슬라이스 내의 min값을 갱신

                //만약 min이 이전 max보다 작다면 그것을 선택하고 그것의 인덱스를 시작으로

                // 만약 슬라이스를 모두 돌면서 슬라이스 내의 min값을 갱신 한 후 이전 max보다 작은 게 없다면..
                // 슬라이스 내의 가장 작은 것을 인덱스로 하고 다시 돌자
                if (min > arr[i]) {
                    min = arr[i];
                    index = i;
                    if (max > min) {
                        break;
                    }
                }
            }
            if (max < min) max = min;
            startIndex = index+1;
//            System.out.printf("startIndex = %d, index = %d  arr[index] = %d, max = %d\n", startIndex, index, arr[index], max);
        }
        System.out.println(max);
    }
}