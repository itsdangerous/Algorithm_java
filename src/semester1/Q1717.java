package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1717 {

    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        makeSet();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int calc = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if (calc == 0) {
                union(num1, num2);
            }
            if (calc == 1) {
                isUnion(num1, num2);
            }

        }

    }

    private static void isUnion(int num1, int num2) {
        if (find(num1) == find(num2)) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }

    private static void makeSet() {
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
    }

    private static int find(int x) {
        if (x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int py = find(y);
        parent[py] = find(x);
    }

}
