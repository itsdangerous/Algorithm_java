import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11724 {

    static int N, M, result;
    static boolean[] visited;
    static ArrayList<Integer>[] edge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        visited = new boolean[N + 1];
        edge = new ArrayList[N + 1];
        result = 0;

        for (int i = 0; i < edge.length; i++) {
            edge[i] = new ArrayList<>();
        }

        // edge 리스트에 양방향 노드 추가
        for (int i = 1; i <= M; i++) {
            str = br.readLine().split(" ");
            int from = Integer.parseInt(str[0]);
            int to = Integer.parseInt(str[1]);
            edge[from].add(to);
            edge[to].add(from);
        }

        solve();
        System.out.println(result);

    }

    static void solve() {
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                Deque<Integer> deque = new LinkedList<>();
                deque.add(i);
                while (!deque.isEmpty()) {
                    int node = deque.pollLast();
                    visited[node] = true;
                    for (int j = 0; j < edge[node].size(); j++) {
                        if (!visited[edge[node].get(j)]) {
                            deque.add(edge[node].get(j));
                        }
                    }
                }
                result++;
            }
        }
    }
}