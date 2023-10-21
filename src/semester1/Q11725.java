package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11725 {

    static int[] parent;
    static int N;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        rank = new int[N + 1];
        makeSet();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x, y);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N+1; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);

    }
    static void makeSet() {
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
            rank[0] = 1;
        }
    }

    static void union(int x, int y) {
        if (x == 1) {
            parent[y] = x;
        }
        if (y == 1) {
            parent[x] = y;
        }
        else {
            if (parent[x] == x && parent[y] != y) {
                parent[x] = y;
            }
            else {
                parent[y] = x;
            }
        }

    }

}
