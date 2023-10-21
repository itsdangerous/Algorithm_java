package semester1;/*
BOJ - 16236 : 아기상어
https://www.acmicpc.net/problem/16236
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.util.*;

public class Q16236 {
    static int N;
    static boolean[][] visited;
    static PriorityQueue<int[]> pq;
    static int[][] map;
    static Shark shark;
    static boolean isEat;
    static int time;
    static int countTime;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static class Shark {
        int r, c;
        int level;
        int food;
        public Shark(int r, int c, int level, int food) {
            this.r = r;
            this.c = c;
            this.level = level;
            this.food = food;
        }
        public void eat(int fish) {
            if (this.level > fish) {
                this.food++;
                if(food == level) {
                    level++;
                    food = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        time = 0;
        isEat = true;

        shark = new Shark(0, 0, 2, 0);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark.r = i;
                    shark.c = j;
                }
            }
        }
        time = 0;
        while (isEat) {
            findFood();
        }
        System.out.println(time);
    }

    public static void findFood() {

        pq = new PriorityQueue<>((e1, e2) -> {
            if (e1[0] == e2[0]) {
                if (e1[1] == e2[1]) return e1[2] - e2[2];
                else return e1[1] - e2[1];
            }
            return e1[0] - e2[0];
        });
        visited = new boolean[N][N];
        pq.offer(new int[]{0, shark.r, shark.c});
        visited[shark.r][shark.c] = true;

        isEat = false;
        countTime = 0;
        while (!pq.isEmpty()) {
            int[] point = pq.poll();
            int t = point[0];
            int r = point[1];
            int c = point[2];

            if (0 < map[r][c] && map[r][c] < shark.level) {
                sharkEat(t, r, c);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (!check(nr, nc)) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] > shark.level) continue;
                pq.offer(new int[]{t+1, nr, nc});
                visited[nr][nc] = true;
            }
        }
    }

    private static void sharkEat(int t, int r, int c) {
        isEat = true;
        shark.eat(map[r][c]);
        map[shark.r][shark.c] = 0;
        shark.r = r;
        shark.c = c;
        time += t;
        map[r][c] = 0;

        visited = new boolean[N][N];
        visited[shark.r][shark.c] = true;
        pq.clear();
        pq.offer(new int[]{0, shark.r, shark.c});

    }

    private static boolean check(int nr, int nc) {
        return 0 <= nr && nr < N && 0 <= nc && nc < N;
    }


    static void printMap(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}