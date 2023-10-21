package semester1;

import java.io.*;
import java.util.*;

/*
SWEA-5656 : 벽돌 깨기
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRQm6qfL0DFAUo
*/
public class swea_5656 {

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int N, W, H;
    static int min;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            int[][] map = new int[H][W];
            for (int r = 0; r < H; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < W; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            min = Integer.MAX_VALUE;
            go(0, map);
            System.out.println("#" + tc + " " + min);
        }
    }

    // 구슬 한번 던지기
    static boolean go(int count, int[][] map) { // 구슬이 던져진 횟수, 벽돌 맵
        // 벽돌 개수 파악
        int result = getRemain(map);

        if(result == 0) {
//            System.out.printf("\n###### %d번 만에 다 부쉈음!\n", count+1);
            min = 0;
            return true; // 다 부쉈어
        }

        if(count == N) {
//            System.out.println("\n###### 구슬 다 쐈다!!!");
//            prinMap(map);
            min = Math.min(min, result);
            return false; // 기저조건에 도달하긴 했는데, 다 부수진 못했어
        }

        int[][] newMap = new int[H][W]; // 배열 복사
        // 모든 열에 구슬 던져보기

        for (int c = 0; c < W; c++) {
            //구슬에 처음 맞는 벽돌 찾기(위쪽에서)
            int r = 0;
            while (r < H && map[r][c] == 0) ++r;

            if(r==H) continue; // 맞는 벽돌이 없으면 다음 열에 던져보기

            copy(map, newMap);
            //벽돌 부수기
            boom(newMap, r, c);

            //벽돌 내리기
            down(newMap);

            //다음 구슬 던지러 가기
            if(go(count + 1, newMap)) return true; //pruning
        }
        return false;
    }

    private static Stack<Integer> stack = new Stack<>();
    private static void down(int[][] map) {
        // 맨 아래행부터 위쪽 들여다보며 빈 칸 만날 때마다 내려놓을 벽돌 찾기
        for (int c = 0; c < W; c++) {
            for (int r = 0; r < H; r++) {
                if (map[r][c] > 0) {
                    stack.push(map[r][c]);
                    map[r][c] = 0;
                }
            }
            int r = H-1;
            while (!stack.isEmpty()) {
                map[r--][c] = stack.pop();
            }
        }
    }

    //BFS
    private static void boom(int[][] map, int r, int c) {
        // que에는 (r,c,cnt)를 저장하고싶음
        Queue<Point> queue = new ArrayDeque<>();
        if (map[r][c] > 1) {
            queue.offer(new Point(r, c, map[r][c]));
        }
        map[r][c] = 0; // 방문 체크 : 빈 공간으로 만든다.

        Point current;
        while (!queue.isEmpty()) {
            current = queue.poll();

            // 현 벽돌의 cnt-1만큼 4방을 체크
            for (int d = 0; d < 4; d++) {
                int nr = current.r;
                int nc = current.c;
                for (int i = 0; i < current.cnt-1; i++) {
                    nr += dr[d];
                    nc += dc[d];
                    if(!check(nr, nc)) continue;
//                    if(map[nr][nc] <= 1) continue;
                    queue.offer(new Point(nr, nc, map[nr][nc]));
                    map[nr][nc] = 0;
                }
            }

        }
    }

    private static boolean check(int r, int c) {
        return 0 <= r && r < H && 0 <= c && c < W;
    }

    private static int getRemain(int[][] map) {
        int count = 0;
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (map[r][c] != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    static void copy(int[][] map, int[][] newMap) {
        for (int r = 0; r < H; r++) {
            if (W >= 0) System.arraycopy(map[r], 0, newMap[r], 0, W);
        }
    }

    static void prinMap(int[][] arr) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
