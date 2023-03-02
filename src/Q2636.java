/*
BOJ-2636 : 치즈
https://www.acmicpc.net/problem/2636
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2636 {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static int N, M;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answerCnt = 0;
        int cheese = 0;
        int answerCheese = 0;
        do {
            cheese = calcCheese();
            if (cheese != 0) {
                answerCheese = cheese;
            }
            answerCnt++;
            convertAir();
            melt();
            cheese = calcCheese();
        } while (cheese != 0);

        System.out.println(answerCnt);
        System.out.println(answerCheese);

    }

    //치즈 주변에 2면 녹이기
    static void melt() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int r = i;
                int c = j;
                if(map[r][c] != 1) continue;
                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if(!check(nr, nc)) continue;
                    if(map[nr][nc] == 2) map[r][c] = 0;
                }
            }
        }
    }

    static void convertAir() {
        visited = new boolean[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0});

        map[0][0] = 2;

        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            int r = tmp[0];
            int c = tmp[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(!check(nr, nc)) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 1) continue;
                que.offer(new int[]{nr, nc});
                map[nr][nc] = 2;
                visited[nr][nc] = true;
            }
        }
    }

    static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    static void printMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }
    }

    static int calcCheese() {
        int t = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                  t++;
                }
            }
        }
        return t;
    }
}
