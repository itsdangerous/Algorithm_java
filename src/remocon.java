import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class remocon {

    static Deque<Integer> deque;
    static boolean[] visited;
    static int[] dx = new int[] {-1, 1, -5, 5, -10, 10};

    static int N, K;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        deque = new LinkedList<>();
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);
        visited = new boolean[100001];

        if (N >= K) {
            System.out.println(N - K);
            return;
        }
        solve(N);
        System.out.println(count);

    }

    static void solve(int n) {
        deque.add(n);
        visited[n] = true;

        while (true) {
            count++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int node = deque.poll();
                visited[node] = true;
                int k =0;
                while (k < 6) {
                    if (node + dx[k] == K) {
                        return;
                    }
                    if (0 <= node + dx[k] && node + dx[k] <= 40 && !visited[node + dx[k]]) {
                        visited[node + dx[k]] = true;
                        deque.add(node + dx[k]);
                    }

                    k++;
                }
            }
        }
    }
}