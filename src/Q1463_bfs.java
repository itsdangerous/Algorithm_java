import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q1463_bfs {

    static int N;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[1000001];
        int answer = bfs();
        System.out.println(answer);

    }

    static int bfs() {

        Queue<Integer> que = new LinkedList<>();
        que.offer(N);
        visited[N] = true;
        int count = -1;

        while (!que.isEmpty()) {
            count++;
            int size = que.size();
            while (size-- > 0) {
                int k = que.poll();
                if (k == 1) {
                    return count;
                }
                if (k % 3 == 0) {
                    int tmp = k / 3;
                    if (visited[tmp]) continue;
                    que.offer(tmp);
                }
                if (k % 2 == 0) {
                    int tmp = k / 2;
                    if (visited[tmp]) continue;
                    que.offer(tmp);
                }
                int tmp = k - 1;
                if (visited[tmp]) continue;
                que.offer(tmp);
            }
        }
        return -1;
    }
}