package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//방향 전환 -- dp
//SWEA-8382
public class swea_8382_3dimension {

    //flag = 0 : 세로만 이동 가능
    //flag = 1 : 가로만 이동 가능
    static class Point {
        int flag;
        int dir;
        int x;
        int y;

        public Point(int flag, int dir, int x, int y) {
            this.flag = flag;
            this.dir = dir;
            this.x = x;
            this.y = y;
        }
    }
    static int[][][] direction = {
            {{-1, 0}, {1, 0}},
            {{0, 1}, {0, -1}}
    };
    static boolean[][][] visited;
    static int x1,x2,y1, y2;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken()) + 100;
            y1 = Integer.parseInt(st.nextToken()) + 100;
            x2 = Integer.parseInt(st.nextToken()) + 100;
            y2 = Integer.parseInt(st.nextToken()) + 100;

            int min = bfs();
            System.out.printf("#%d %d\n", t, min);
        }
    }

    static int bfs() {
        int cnt = 0;
        visited = new boolean[2][201][201];
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, x1, y1));
        q.offer(new Point(1, 1, x1, y1));
        visited[0][x1][y1] = true;
        visited[1][x1][y1] = true;

        if (x1 == x2 && y1 == y2) return cnt;
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            while (size-- > 0) {
                Point point = q.poll();
                int flag = point.flag;
                int dir = point.dir;
                int x = point.x;
                int y = point.y;
                for (int i = 0; i < 2; i++) {
                    int ndir = (dir + 1) % 2;
                    int nx = x + direction[ndir][i][0];
                    int ny = y + direction[ndir][i][1];
                    if(!check(nx,ny)) continue;
                    if(visited[flag][nx][ny]) continue;
                    if(nx == x2 && ny == y2) return cnt;
                    visited[flag][nx][ny] = true;
                    q.offer(new Point(flag, ndir, nx, ny));
                }
            }
        }
        return cnt;
    }

    static boolean check(int x, int y) {
        return 0 <= x && x <= 200 && 0 <= y && y <= 200;
    }

}