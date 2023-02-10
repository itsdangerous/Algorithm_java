import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Q1697 {

    static Deque<Integer> deque;
    static boolean[] visited;

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
//            System.out.println(deque);
            count++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int node = deque.poll();
                visited[node] = true;
                if (node + 1 == K || node - 1 == K || node * 2 == K) {
                    return;
                }
                if (node - 1 >= 0 && !visited[node - 1]) {
                    visited[node - 1] = true;
                    deque.add(node - 1);
                }
                if (node + 1 <= 100000 && !visited[node + 1]) {
                    visited[node + 1] = true;
                    deque.add(node + 1);
                }
                if (node * 2 <= 100000 && !visited[node * 2]) {
                    visited[node * 2] = true;
                    deque.add(node * 2);
                }

            }
        }
    }
}