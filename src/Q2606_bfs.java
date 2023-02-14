import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2606_bfs {
    static int N;
    static int M;
    static int[][] map;
    static int[] distance;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) -1;
            int to = Integer.parseInt(st.nextToken()) -1;
            map[from][to] = 1;
            map[to][from] = 1;

        } // 읽기 끝
        distance = new int[N];
        count = 0;
        bfs();
        //result();
        System.out.println(count);

    }
    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        distance[0] = 2; //방문
        while (!queue.isEmpty()) {

            int s = queue.poll();
            for (int e = 0; e < N; e++) {

                if(distance[e]!=0) continue;
                if (map[s][e] == 1) {
                    count++;
                    queue.add(e);
                    distance[e] = 2;
                }

            }
        }
    }


}
