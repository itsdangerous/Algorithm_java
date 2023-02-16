import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test {

    static int[] p = {1, 2, 3, 4, 5, 6};
    static int N = p.length;
    static int R;
    static int count;
    static int[] nums;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        R = 3;
        count = 0;
        nums = new int[R];
        visited = new boolean[N];
        perm(0, 0);
        System.out.println(count);
    }

    static void perm(int cnt, int start) {
        if (cnt == R) {
            System.out.println(Arrays.toString(nums));
            count++;

            return;
        }
        for (int i = start; i < N; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            nums[cnt] = p[i];
            perm(cnt + 1, i+1);
            nums[cnt] = 0;
            visited[i] = false;
        }
    }
}