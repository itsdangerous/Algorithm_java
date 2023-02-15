import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PermTest {
    static int[] p = {1, 2, 3, 4, 5};
    static int N = p.length;
    static int R;
    static int[] nums;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        R=3;
        count=0;
        nums = new int[R];
        visited = new boolean[N];
        perm(0); // count나 depth. parameter를 뭘로 받을거냐?만 잘 정해도 70퍼는 끝남.
        System.out.println(count);

    }

    static void perm(int cnt) {
        if (cnt == R) { // base (end) condition 명시.
            //로직
            count++;
            System.out.println(Arrays.toString(nums));
            System.out.println(Arrays.toString(visited));
            return;
        }

//        perm(cnt + 1);
//        perm(cnt + 1);
//        perm(cnt + 1);
//
        for (int i = 0; i < N; i++) {
            if(!visited[i]) continue;
            visited[i] = true;
            nums[cnt] = p[i];
            perm(cnt + 1);
            nums[cnt] = 0;
            visited[i] = false;

        }

    }
}
