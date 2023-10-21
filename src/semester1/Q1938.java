package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q1938 {

    static class Point{
        int r, c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static class Log{
        Point[] p;
        int direction, move; //0 수직 1 수평
        public Log(Point[] logPoints, int direction, int move){
            p = logPoints;
            this.direction = direction;
            this.move = move;
        }
    }
    /* Setting */
    static int n;
    static int[] RR = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] CC = {0, 0, -1, 1, -1, 1, -1, 1};
    static char[][] map = new char[51][51];
    static boolean[][][] visited = new boolean[51][51][2]; //0: 수직 1: 수평

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int idx = 0;
        Point[] log = new Point[3];

        for (int i = 1; i <= n; i++) {
            char[] strs = br.readLine().toCharArray();
            for (int j = 1; j <= n; j++) {
                map[i][j] = strs[j - 1];
                if (map[i][j] == 'B')
                    log[idx++] = new Point(i, j);
            }
        }
        System.out.println(bfs(log));
    }

    static int bfs(Point[] p){
        Queue<Log> que = new LinkedList<>();

        int directionStart = p[0].c == p[1].c? 0:1;
        visited[p[1].r][p[1].c][directionStart] = true;
        que.add(new Log(p, directionStart, 0));

        while(!que.isEmpty()){
            Log log = que.poll();
            Point[] cur = log.p;
            int dir = log.direction;
            int cnt = log.move;

            if(map[cur[0].r][cur[0].c] == 'E' && map[cur[2].r][cur[2].c] == 'E')
                return cnt;

            /* 위쪽 */
            if(check(cur[1], -1, 0) && !visited[cur[1].r-1][cur[1].c][dir]) {
                Point[] up = new Point[3];
                for (int i = 0; i < 3; i++) {
                    up[i] = new Point(cur[i].r - 1, cur[i].c);
                }

                if (up(up)) {
                    visited[up[1].r][up[1].c][dir] = true;
                    que.add(new Log(up, dir, cnt + 1));
                }
            }

            /* 아래쪽 */
            if(check(cur[1], 1, 0) && !visited[cur[1].r+1][cur[1].c][dir]) {
                Point[] down = new Point[3];
                for (int i = 0; i < 3; i++)
                    down[i] = new Point(cur[i].r+1, cur[i].c);

                if (down(down)) {
                    visited[down[1].r][down[1].c][dir] = true;
                    que.add(new Log(down, dir, cnt + 1));
                }
            }

            /* 왼쪽 */
            if(check(cur[1], 0, -1) && !visited[cur[1].r][cur[1].c-1][dir]) {
                Point[] left = new Point[3];
                for (int i = 0; i < 3; i++)
                    left[i] = new Point(cur[i].r, cur[i].c-1);

                if (left(left)) {
                    visited[left[1].r][left[1].c][dir] = true;
                    que.add(new Log(left, dir, cnt + 1));
                }
            }

            /* 오른쪽 */
            if(check(cur[1], 0, 1) && !visited[cur[1].r][cur[1].c+1][dir]) {
                Point[] right = new Point[3];
                for (int i = 0; i < 3; i++)
                    right[i] = new Point(cur[i].r, cur[i].c+1);

                if (right(right)) {
                    visited[right[1].r][right[1].c][dir] = true;
                    que.add(new Log(right, dir, cnt + 1));
                }
            }

            /* 회전 */
            int nDir = dir == 0 ? 1 : 0;
            if(!visited[cur[1].r][cur[1].c][nDir]) {
                Point[] rotate = new Point[3];
                for (int i = 0; i < 3; i++)
                    rotate[i] = new Point(cur[i].r, cur[i].c);

                if (rotate(rotate, dir)) {
                    visited[rotate[1].r][rotate[1].c][nDir] = true;
                    que.add(new Log(rotate, nDir, cnt + 1));
                }
            }
        }
        return 0;
    }
    static boolean up(Point[] p){
        for (Point log : p) {
            if (log.r < 1 || map[log.r][log.c] == '1')
                return false;
        }

        return true;
    }

    static boolean down(Point[] p){
        for (Point log : p) {
            if (log.r > n || map[log.r][log.c] == '1')
                return false;
        }

        return true;
    }

    static boolean left(Point[] p){
        for (Point log : p) {
            if (log.c < 1 || map[log.r][log.c] == '1')
                return false;
        }

        return true;
    }

    static boolean right(Point[] p){
        for (Point log : p) {
            if (log.c > n || map[log.r][log.c] == '1')
                return false;
        }

        return true;
    }

    static boolean rotate(Point[] p, int dir) {
        if(p[1].r-1 < 1 || p[1].r+1 > n || p[1].c-1 < 1 || p[1].c+1 > n)
            return false;

        for(int a=0; a<8; a++)
            if(map[p[1].r+ RR[a]][p[1].c+ CC[a]] == '1')
                return false;

        if(dir == 0){
            p[0].r++;
            p[0].c--;
            p[2].r--;
            p[2].c++;
        }
        else{
            p[0].r--;
            p[0].c++;
            p[2].r++;
            p[2].c--;
        }
        return true;
    }
    static boolean check(Point p, int r, int c){
        return p.r + r >= 1 && p.r + r <= n && p.c + c >= 1 && p.c + c <= n;
    }
}