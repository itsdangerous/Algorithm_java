package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2606_dfs {
    static int N;
    static int M;
    static int[][] map;
    static int[] distance;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            map[from][to] = 1;
            map[to][from] = 1;

        } // 읽기 끝
        distance = new int[N];
        count = 0;
        dfs(0);
        result();
    }

    static void result() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (distance[i] == 2) count++;
        }
        System.out.println(count - 1);
    }
    //  소설을 쓰자 : 0(s)에서 시작하여 연결된 다른 한점을 선택한다. e
    // e를 다시 시작점으로 e를 구한다. 같은 방법을 게속해서연결된 노드(숫자)에 2를 표시한다.


    static void dfs(int s) {
        distance[s] = 2;
        for (int e = 0; e < N; e++) {
            if (distance[e] != 0) continue;
            if (map[s][e] == 1) {
                dfs(e);
            }
        }
    }
}