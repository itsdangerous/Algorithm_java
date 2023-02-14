import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test_Subset {

    static int[] p = {1, 2, 3, 4, 5};
    static int N = p.length;
    static int R;
    static int[] nums;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("R 값 입력 : >>");
        R = Integer.parseInt(br.readLine());
        nums = new int[R];
        visited = new boolean[N];
        count = 0;
        subset(0, 0, 1);
        System.out.println(count);
    }

    static void subset(int cnt, int tot, int mul) {

        if (cnt == R) {
            count++;
            System.out.print(tot + " ");
            System.out.println(mul);
            return;
        }

        visited[cnt] = true;
        subset(cnt + 1, tot + p[cnt], mul * p[cnt]); // 선택 될때
        visited[cnt] = false;
        subset(cnt + 1, tot + p[cnt], mul * p[cnt]); // 선택 안될때
    }
}