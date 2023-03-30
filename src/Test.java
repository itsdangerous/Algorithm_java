import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {

    static int[] p;
    static int[] nums;
    static int N;
    static int R;
    static boolean[] visited;
    static int[][] dist;
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        dist = new int[N][N];
        p = new int[N];

        for (int i = 0; i < N; i++) {
            p[i] = i;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        nums = new int[N];

        perm(0);
        System.out.println(min);


    }

    static void perm(int cnt) {
        if (cnt == N) {

            int cost = 0;
            for (int i = 0; i < N-1; i++) {
                int c = dist[nums[i]][nums[i+1]];
                if (c == 0) return;
                cost += c;
            }
            int c = dist[nums[N - 1]][nums[0]];
            if (c==0) return;
            cost += c;

            min = Math.min(min, cost);
            return;
        }

        for (int i = 0; i < N; i++) {

            if (visited[i]) continue;

            visited[i] = true;
            nums[cnt] = p[i];
            perm(cnt + 1);
            nums[cnt] = 0;
            visited[i] =false;
        }
    }
}