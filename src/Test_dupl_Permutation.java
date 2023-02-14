import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test_dupl_Permutation {
    // 11111 &
    // 00000 | 1 => 00001

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
        perm(0, 0);
        System.out.println(count);
    }

    static void perm(int cnt, int flag) {
        if (cnt == R) {
            System.out.println(Arrays.toString(nums));
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if ((flag & (1 << i)) != 0) {
                continue;
            }

            nums[cnt] = p[i];
            perm(cnt + 1, (flag | (1 << i))); // 이거 하면 그냥 순열
//            perm(cnt+1, flag); // 이거하면 중복 순열
            nums[cnt] = 0;

        }
    }
}