package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_3307 {
    static int answer;
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {


            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Lis();
            System.out.printf("#%d %d\n", tc, answer);
        }
    }

    static void Lis() {
        answer = 0;
        int[] lisArr = new int[N];
        lisArr[0] = arr[0];
        int index = 0;
        for (int i = 1; i < N; i++) {
            if (lisArr[index] < arr[i]) {
                lisArr[++index] = arr[i];
            }
            else {
                int num = Arrays.binarySearch(lisArr, 0, index+1, arr[i]);
                if (num >= 0) {
                    lisArr[num] = arr[i];
                }
                else {
                    lisArr[-num-1] = arr[i];
                }
            }
        }
        answer = index + 1;
    }
}
