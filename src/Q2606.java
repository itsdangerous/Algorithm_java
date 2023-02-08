import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q2606 {
    static boolean[] visited;
    static int count = 0;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];

        list = new ArrayList[N+1];

        //2차원 배열 생성
        for (int i = 1; i < N+1; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i < M+1; i++) {
            String[] str = br.readLine().split(" ");

            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

//            int from = Math.min(a, b);
//            int to = Math.max(a,b);
            if (!list[a].contains(b)) {
                list[a].add(b);
            }
            if (!list[b].contains(a)) {
                list[b].add(a);
            }

        }
        solve(1);
        System.out.println(count);
    }
    static void solve(int index) {

        for (int i = 0; i < list[index].size(); i++) {
            visited[index] = true;
            int node = list[index].get(i);
            if (!visited[node]) {
                visited[node] = true;
                count++;
                solve(node);
            }
        }
    }
}