import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

    static int N;
    static int[] p;
    static int[] nums;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        p = new int[N];
        visited = new boolean[N];
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i + 1;
        }
        perm(0);
    }

    static void perm(int cnt) {
        if (cnt == N) {

            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    System.out.print(nums[i]+" ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            nums[cnt] = p[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}