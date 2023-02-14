import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num > 0) {
                arr[i][0] = num;
                arr[i][1] = 1; // 양수 라벨링
            }
            else {
                arr[i][0] = -num;
                arr[i][1] = -1; // 음수 라벨링 결과적으로 양수만 들어가지만, 음수 라벨을 갖고있음
            }
        }

        Arrays.sort(arr, Comparator.comparingInt(e -> e[0])); // 라벨링 배열 정렬

        int result = Math.abs(arr[0][0]*arr[0][1] + arr[1][0]*arr[1][1]); // 비교가 될 절대값
        int[] answer = new int[] {arr[0][0]*arr[0][1], arr[1][0]*arr[1][1]}; // 정답 배열 초기화

        // 정렬된 배열을 순차적으로 탐색하면서 인접한 두 수의 라벨이 다르면 두 수의 합의 절대값으로 비교
        for (int i = 0; i < N-1; i++) {
            if (arr[i][1] != arr[i + 1][1]) { // 옆에 계신 수의 부호 라벨이 반대라면
                int tmp = Math.abs(arr[i][0]*arr[i][1] + arr[i + 1][0]*arr[i+1][1]); // 두 수를 더하고 result랑 비교
                if (result > tmp) { // 0과 가깝니~?
                    result = tmp; // 두 수의 차이(절대값)를 result에 저장
                    answer[0] = arr[i][0] * arr[i][1]; // 두 수를 정답 배열에 저장 후 아래에서 정렬 및 출력
                    answer[1] = arr[i + 1][0] * arr[i + 1][1];
                }
            }
        }

        Arrays.sort(answer);
        System.out.println(answer[0]+" "+ answer[1]);

    }
}