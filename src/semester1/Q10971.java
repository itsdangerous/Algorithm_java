package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10971 {

    static int[][] map;
    static int[] p, nums;
    static boolean[] visited;
    static int N,R,count;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        R = N;
        p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i + 1;
        }
        nums = new int[R];
        visited = new boolean[N];
        map = new int[N+1][N+1];
        // 비용 행렬 입력받기
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        perm(0);
        System.out.println(answer);
    }

    static void perm(int cnt) {
        if (cnt == R) {
            //로직
            count = calcDistance(nums);
            if (calcDistance(nums) == -1) return;
            answer = Math.min(answer, count);

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

    // 거리를 구할 수 있는 경우 거리 구하기
    static int calcDistance(int[] arr) {

        count = 0;

        for (int i = 0; i < N-1; i++) {
            int from = nums[i];
            int to = nums[i+1];
            if (map[from][to] == 0) return -1;
            count += map[from][to];
        }

        int from = nums[N-1];
        int to = nums[0];
        if (map[from][to] == 0) return -1;
        count += map[from][to];

        return count;
    }

}
