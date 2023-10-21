package semester1;/*SWEA_1263 사람 네트워크2
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18P2B6Iu8CFAZN*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1263 {
    static int N;
    static int[][] graph;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int TC = 1; TC < T + 1; TC++) {


            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            graph = new int[N][N];
            arr = new int[N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                    if (graph[i][j] == 0) {
                        if (i!=j) graph[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
            floyid();
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int hap = 0;
                for (int j = 0; j < N; j++) {
                    hap += graph[i][j];
                }
                min = Math.min(min, hap);
            }

            System.out.printf("#%d %d\n", TC, min);
        }
    }

    static void floyid() {
        for (int via = 0; via < N; via++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if(graph[r][via] + graph[via][c] < graph[r][via]) continue;
                    if(graph[r][via] + graph[via][c] < graph[via][c]) continue;
                    graph[r][c] = Math.min(graph[r][c], graph[r][via] + graph[via][c]);

                }
            }
        }
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
