import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q11651 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][2];
        int[] tmp = new int [2];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            points[i][0] = x;
            points[i][1] = y;

        }

        // Arrays.sort의 Compaator 사용
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) { // 비교할 대상 : 배열1, 배열2
                if (o1[1] == o2[1]) { // 만약 비교할 대상의 배열의 2번째 인덱스가 같다면
                    return Integer.compare(o1[0], o2[0]); // 1번째 인덱스로 비교해라 //
                }
                return Integer.compare(o1[1], o2[1]); // 아니면 그냥 2번째 인덱스로만 비교해라
            }
        });

        // Integer.Compare
//        public static int compare(int x, int y) {
//            return (x < y) ? -1 : ((x == y) ? 0 : 1);
//        }

        // 람다식 표현
//        Arrays.sort(points, (e1, e2) -> {
//            if (e1[1] == e2[1]) {
//                return e1[0] - e2[0];
//            }
//            return e1[1] - e2[1];
//        });



        for (int i = 0; i < N; i++) {
            System.out.println(points[i][0] + " " + points[i][1]);
        }

    }
}
