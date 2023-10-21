package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Q2178 {

    static Deque<int[]> deque;
    static int[][] map;
    static boolean[][] visited;

    static int N, M;
    static int cnt;
    static int[] dh = {-1, 0, 1, 0};
    static int[] dw = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        deque = new LinkedList<>();
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i+1][j+1] = s.charAt(j)-'0';
            }
        }

        deque.add(new int[]{1, 1}); // start 인덱스를 큐에 삽입 후 bfs 수행
        visited[1][1] = true;

        // bfs 수행
        solve();
    }

    static void solve() {

        while (true) {
//            // deqeue 출력
//            for (int i = 0; i < deque.size(); i++) {
//                System.out.print(deque.peek()[0] + " " + deque.peek()[1]);
//            }
//            System.out.println();


            cnt++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] point = deque.poll();
                visited[point[0]][point[1]] = true;
                if (point[0] == N && point[1] == M) {
                    System.out.println(cnt);
                    return;
                }

                // 상 탐색
                if (point[0] + dh[0] >= 1 && !visited[point[0] + dh[0]][point[1] + dw[0]] && map[point[0] + dh[0]][point[1] + dw[0]] == 1) {
                    visited[point[0] + dh[0]][point[1] + dw[0]] = true;
                    deque.add(new int[]{point[0] + dh[0], point[1] + dw[0]});
                }

                // 우 탐색
                if (point[1] + dw[1] <= M && !visited[point[0] + dh[1]][point[1] + dw[1]] && map[point[0] + dh[1]][point[1] + dw[1]] == 1) {

                    visited[point[0] + dh[1]][point[1] + dw[1]] = true;
                    deque.add(new int[]{point[0] + dh[1], point[1] + dw[1]});
                }

                // 하 탐색
                if (point[0] + dh[2] <= N && !visited[point[0] + dh[2]][point[1] + dw[2]] && map[point[0] + dh[2]][point[1] + dw[2]] == 1) {

                    visited[point[0] + dh[2]][point[1] + dw[2]] = true;
                    deque.add(new int[]{point[0] + dh[2], point[1] + dw[2]});
                }

                // 좌 탐색
                if (point[1] + dw[3] >= 1 && !visited[point[0] + dh[3]][point[1] + dw[3]] && map[point[0] + dh[3]][point[1] + dw[3]] == 1) {

                    visited[point[0] + dh[3]][point[1] + dw[3]] = true;
                    deque.add(new int[]{point[0] + dh[3], point[1] + dw[3]});
                }
            }

////            visited 상황
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(visited[i][j]+"\t");
//
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
    }
}