import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q2805 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        long max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (max < num) {
                max = num;
            }
            arr[i] = num;
        }

        long left = 0;
        long right = max;

        while (left <= right) {
            long hap = 0;
            long mid = (left + right) / 2;
            for (int j : arr) {
                if (j > mid) {
                    hap += j - mid;
                }
            }
            if (hap < M) {
                right = mid - 1;
            }
            else {
                left = mid +1;
            }
        }
        System.out.println(right);



        // 시간 초과 코드
//        Integer[] trees = Arrays.stream(arr).boxed().toArray(Integer[]::new);
//        Arrays.sort(trees, Collections.reverseOrder());
//
//        int h = trees[0];
//
//        while (true) {
//            int hap = 0;
//            int i = 0;
//            while (trees[i] > h) {
//                hap += trees[i] - h;
//                i++;
//            }
//            if (hap >= M) {
//                System.out.println(h);
//                return;
//            }
//            else {
//                h--;
//            }
//        }
    }
}
