import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N, R 한줄 입력 --> nPr

public class Permutation {

    static int[] p;
    static int N;
    static int R;
    static int[] nums;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        R = Integer.parseInt(str[1]);

        p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i+1;
        }

        nums = new int[R];

        visited = new boolean[N];
        count = 0;
        perm(0);

    }
    static void perm(int cnt) {
        if (cnt == R) {

            for (int i : nums) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            nums[cnt] = p[i];
            perm(cnt + 1);
            nums[cnt] = 0;
            visited[i] = false;
        }
    }
}
