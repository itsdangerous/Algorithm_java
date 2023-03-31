import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14502 {
    static int[][] map;
    static int N, M;
    static ArrayList<Point> list;
    static ArrayList<Point> viruses;
    static boolean[] visited;
    static Point[] selectedPoint;
    static int max = -1;
    static int walls = 0;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        list = new ArrayList<>();
        selectedPoint = new Point[3];
        viruses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    list.add(new Point(i, j));
                }
                if (map[i][j] == 1) {
                    walls++;
                }
                if (map[i][j] == 2) {
                    viruses.add(new Point(i, j));
                }
            }
        }
        visited = new boolean[list.size()];
        combi(0, 0);

        System.out.println(max);

    }

    static void combi(int cnt, int start) {
        if (cnt == 3) {
            //로직
            int[][] tmpMap = copyMap(map);
            for (int i = 0; i < 3; i++) {
                int r = selectedPoint[i].r;
                int c = selectedPoint[i].c;
                tmpMap[r][c] = 1;
            }
            max = Math.max(max, bfs(tmpMap));
            return;
        }

        for (int i = start; i < list.size(); i++) {
            if (visited[i]) continue;

            visited[i] = true;
            selectedPoint[cnt] = list.get(i);
            combi(cnt + 1, i + 1);
            selectedPoint[cnt] = null;
            visited[i] = false;
        }
    }

    static int bfs(int[][] arr) {
        Queue<Point> que = new LinkedList<>();
        int cnt = 0;

        for (Point virus : viruses) {
            que.offer(virus);
            cnt++;
        }

        while (!que.isEmpty()) {
            Point p = que.poll();
            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                if (!check(nr, nc)) continue;
                if (arr[nr][nc] == 0) {
                    arr[nr][nc] = 2;
                    que.offer(new Point(nr, nc));
                    cnt++;
                }
            }
        }
        return N * M - walls - 3 - cnt;
    }

    static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }


    static int[][] copyMap(int[][] map) {
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            if (M >= 0) System.arraycopy(map[i], 0, arr[i], 0, M);
        }
        return arr;
    }


}
