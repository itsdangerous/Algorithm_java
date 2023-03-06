/*
BOJ - 16236 : 아기상어
https://www.acmicpc.net/problem/16236
*/



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16236 {
    static int N;
    static int[][] map;
    static Shark shark;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
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
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

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

