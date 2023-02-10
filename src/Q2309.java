import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// nPr 서로다른 n 개에서 서로다른 r개를 선택후 나열
// 5p3 = 5*4*3

public class Q2309 {
    static int[] p;
    static int N;
    static int R;
    static boolean[] visited;
    static int[] nums;
    static int count;
    static int check = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        R = 7;
        p = new int[9];
        for (int i = 0; i < 9; i++) {
            p[i] = Integer.parseInt(br.readLine());
        }

        N = p.length;
        visited = new boolean[N];
        nums = new int[R];

        //-----------------
        combi(0, 0);  // 재귀 -> 자신이 자신호출 ->while -> dfs -> 끝나는 조건 필요

    }

    // 123 124 125 ...
    static void combi(int cnt, int start) {
        if (check == 0) {
            if (cnt == R) {
                int sum = 0;
                for (int i : nums) {
                    sum += i;
                }
                if (sum == 100) {
                    Arrays.sort(nums);
                    for (int i : nums) {
                        System.out.println(i);
                    }
                    check = 1;
                }
                return;
            }
            for (int i = start; i < N; i++) {
//            if(visited[i]) continue;
                // 방문한적 없다. 12 3 12 ㅁ4 12 5
                visited[i] = true; // visited 지워도 댐 but,선택 안한거 볼때 필요.
                nums[cnt] = p[i];
                combi(cnt + 1, i + 1);
                nums[cnt] = 0; // 날려도 됨
                visited[i] = false;
            }
        }
    }
}