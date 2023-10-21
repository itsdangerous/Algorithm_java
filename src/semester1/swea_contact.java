package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class swea_contact {

    static ArrayList<Integer>[] list;
    static int V, start;
    static Queue<Integer> que;
    static boolean[] visited;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            visited = new boolean[101];
            result = 0;

            list = new ArrayList[101];
            for (int i = 0; i < 101; i++) {
                list[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < V; i = i + 2) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                list[from].add(to);
            }

            System.out.printf("#%d %d\n", t, bfs());

        }

    }

    static int bfs() {
        que = new LinkedList<>();
        que.add(start);
        visited[start] = true;

        int maxValue = -1;
        while (!que.isEmpty()) {

            int size = que.size();
            maxValue = calc(que);
            for (int i = 0; i < size; i++) {
                int cur = que.poll();
                for (int next : list[cur]) {
                    if(visited[next]) continue;
                    que.add(next);
                    visited[next] = true;
                }
            }
        }
        return maxValue;
    }

    static int calc(Queue<Integer> que) {
        int max = -1;
        for (int n : que) {
            max = Math.max(max, n);
        }
        return max;
    }

}