/*
swea_4193 : 수영대회(완전탐색 + 구현)
https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AWKaG6_6AGQDFARV
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_4193 {
    static int[][] map;
    static int N;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    static int A,B,C, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int TC = 1; TC < T + 1; TC++) {

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            System.out.printf("#%d %d\n", TC, bfs());
        }
    }

    static int bfs() {
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        que.offer(new int[]{A, B});
        visited[A][B] = true;
        int time = -1;
        while (!que.isEmpty()) {
            int size = que.size();
            time++;
            if (time % 3 < 2) { // 소용돌이 있을 때
                while (size-- > 0) {
                    int[] point = que.poll();
                    int r = point[0];
                    int c = point[1];
                    if (r == C && c == D) return time;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if(!check(nr, nc)) continue;
                        if(visited[nr][nc]) continue;
                        if(map[nr][nc] == 1) continue;
                        if(map[nr][nc] == 2) {
                            que.offer(new int[]{r, c});
                            continue;
                        }
                        que.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;

                    }

                }
            }
            if (time % 3 == 2) { // 소용돌이가 없을 때
                while (size-- > 0) {
                    int[] point = que.poll();
                    int r = point[0];
                    int c = point[1];
                    if (r == C && c == D) return time;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if(!check(nr, nc)) continue;
                        if(visited[nr][nc]) continue;
                        if(map[nr][nc]==1) continue;
                        que.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }

            }

        }

        return -1;
    }

    static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}