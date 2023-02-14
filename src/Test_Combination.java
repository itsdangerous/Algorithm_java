import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test_Combination {

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
        combi(0, 0);
        System.out.println(count);
    }

    static void combi(int cnt, int start) {
        if (cnt == R) {
            System.out.println(Arrays.toString(nums));
            count++;
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            nums[cnt] = p[i];
            combi(cnt+1, i+1);
            nums[cnt] = 0;
            visited[i] = false;
        }
    }
}