import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2109 {
    static int N;
    static int[][] list;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        list = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        // 배열 정렬
        // 1차원 : 내림차순
        // 2차원 : 오름차순
        Arrays.sort(list, (e1, e2) -> {
            return e2[0] - e1[0];
        });
        printArr(list);
        solve();

    }
    static void solve() {
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            if (cnt <= list[i][1]) {
                answer += list[i][0];
                cnt++;
            }
        }
        System.out.println(answer);
    }

    static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void initMap() {

    }

}
