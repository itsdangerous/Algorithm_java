import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Q2961 {
    static int N;
    static List<List<Integer>> list;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        p = new int[N];
        list = new LinkedList<>();
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            p[i] = i + 1;
            List<Integer> tmp = new LinkedList<>();
            String[] str = br.readLine().split(" ");
            tmp.add(Integer.parseInt(str[0]));
            tmp.add(Integer.parseInt(str[1]));
            list.add(tmp);

        }
        power(0);
        System.out.println(min);

    }

    static void power(int cnt) {
        if (cnt == N) {
            boolean hasTrue = false;
            for (boolean v : visited) {
                if (v) {
                    hasTrue = v;
                    break;
                }
            }

            if (hasTrue) {
                int calc = calc();
                if (calc < min) {
                    min = calc;
                }
            }
            return;
        }
        visited[cnt] = true; //선택한게 뭔지 알고 싶을때는 visited 이용.
        power(cnt + 1);
        visited[cnt] = false;
        power(cnt + 1);
    }

    static int calc() {
        int a = 1;
        int b = 0;
        for (int i = 0; i < p.length; i++) {
            if (visited[i]) {
                a *= list.get(p[i]-1).get(0);
                b += list.get(p[i]-1).get(1);
            }
        }
        return Math.abs(a-b);
    }
}
