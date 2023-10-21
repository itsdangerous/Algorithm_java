package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Q7576 {

    static Deque<int[]> deque;
    static int[][] map;
    static boolean[][] visited;

    static int N, M;
    static int OK = 0;
    static int CANT = 0;
    static int WHOLE;
    static int cnt;
    static int[] dh = {-1, 0, 1, 0};
    static int[] dw = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        deque = new LinkedList<>();
        String[] str = br.readLine().split(" ");
        M = Integer.parseInt(str[0]);
        N = Integer.parseInt(str[1]);
        map = new int[N][M];
        visited = new boolean[N][M];
        WHOLE = N * M;

        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if (map[i][j] == 1) {
                    OK++;
                }
                if (map[i][j] == -1) {
                    CANT++;
                }
            }
        }
        if (WHOLE - CANT == OK) {
            System.out.println(0);
            return;
        }

        // bfs 수행
        solve();


        // bfs수행 후 탐색하지 못한 곳(토마토가 익을 수 있는데 못익은 곳)이 있다면 -1리턴. 아니면 cnt리턴
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && visited[i][j] == false) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(cnt-1);

    }

    static void solve() {

        // 제일 처음에 1로 입력 된 곳의 인덱스를 배열형식으로 queue에 넣고, visited 확인
        OK = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    deque.add(new int[]{i, j});
                    OK++;
                }
            }
        }

        while (true) {

            if (deque.isEmpty()) {
                return;
            }

//            // deqeue 출력
//            for (int i = 0; i < deque.size(); i++) {
//                System.out.print(deque.peek()[0] + " " + deque.peek()[1]);
//            }
//            System.out.println();
            //
            cnt++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] point = deque.poll();
                visited[point[0]][point[1]] = true;
                OK++;

                // 상 탐색
                if (point[0] + dh[0] >= 0 && !visited[point[0] + dh[0]][point[1] + dw[0]] && map[point[0] + dh[0]][point[1] + dw[0]] != -1) {

                    visited[point[0] + dh[0]][point[1] + dw[0]] = true;
                    deque.add(new int[]{point[0] + dh[0], point[1] + dw[0]});
                }

                // 우 탐색
                if (point[1] + dw[1] < M && !visited[point[0] + dh[1]][point[1] + dw[1]] && map[point[0] + dh[1]][point[1] + dw[1]] != -1) {

                    visited[point[0] + dh[1]][point[1] + dw[1]] = true;
                    deque.add(new int[]{point[0] + dh[1], point[1] + dw[1]});
                }

                // 하 탐색
                if (point[0] + dh[2] < N && !visited[point[0] + dh[2]][point[1] + dw[2]] && map[point[0] + dh[2]][point[1] + dw[2]] != -1) {

                    visited[point[0] + dh[2]][point[1] + dw[2]] = true;
                    deque.add(new int[]{point[0] + dh[2], point[1] + dw[2]});
                }

                // 좌 탐색
                if (point[1] + dw[3] >= 0 && !visited[point[0] + dh[3]][point[1] + dw[3]] && map[point[0] + dh[3]][point[1] + dw[3]] != -1) {

                    visited[point[0] + dh[3]][point[1] + dw[3]] = true;
                    deque.add(new int[]{point[0] + dh[3], point[1] + dw[3]});
                }
//                System.out.printf("WHOLE = %d, OK = %d, CANT = %d\n", WHOLE, OK, CANT);


            }

            //visited 상황
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