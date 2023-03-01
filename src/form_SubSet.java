import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class form_SubSet {

    static int[] p;
    static boolean[] visited;
    static int N, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i + 1;
        }
        visited = new boolean[N];
        count = 0;
        power(0);
        System.out.println(count);

    }

    static void power(int cnt) {
        if (cnt == N) {
            count++;
            //로직
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    System.out.print(p[i]+" ");
                }
            }
            System.out.print("\t");

            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    System.out.print(p[i]+" ");
                }
            }
            System.out.println();
            return;
        }

        visited[cnt] = true;
        power(cnt + 1);
        visited[cnt] = false;
        power(cnt + 1);
    }

}