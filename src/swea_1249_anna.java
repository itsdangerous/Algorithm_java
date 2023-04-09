import java.io.*;
import java.util.*;

public class swea_1249_anna {
    static int T;
    static int N;
    static int map[][];
    static int newmap[][];
    static boolean visited[][];
    static int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    static int min;
    static class Point implements Comparable<Point>{
        int r;
        int c;
        public Point(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }
        @Override
        public int compareTo(Point o) {
            return Integer.compare(newmap[this.r][this.c], newmap[o.r][o.c]);
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String temp = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = (int)temp.charAt(j) - '0';
                }
            }

//          for (int i = 0; i < N; i++) {
//              System.out.println(Arrays.toString(map[i]));
//          }
            min = Integer.MAX_VALUE;
            newmap = new int[N][N];
            bfs();
//          visited[0][0] = true;
//          dfs(0,0, 0);


            System.out.printf("#%d %d\n", t,newmap[N-1][N-1] );
        }


    }

    static void bfs() {
        for (int i = 0; i < newmap.length; i++) {
            Arrays.fill(newmap[i],1000);
        }
        newmap[0][0]=0;
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(0, 0));
        visited[0][0] = true;
        int time= 0;
        while (!q.isEmpty()) {
            Point p = q.poll();
            if(p.r == N-1 && p.c ==N-1) {
//              min = Math.min(time, min);
                break;
            }
            visited[p.r][p.c] = true;

            for (int i = 0; i < 4; i++) {
                int nr = p.r+dir[i][0];
                int nc = p.c+dir[i][1];
                if(isInRange(nr,nc) && !visited[nr][nc]) {
//                  time += map[nr][nc];
                    newmap[nr][nc] = Math.min(newmap[nr][nc], newmap[p.r][p.c]+map[nr][nc]);
                    q.add(new Point(nr, nc));
                }
            }

//          for (int i = 0; i < newmap.length; i++) {
//              System.out.println(Arrays.toString(newmap[i]));
//          }
//          for (int i = 0; i < newmap.length; i++) {
//              System.out.println(Arrays.toString(visited[i]));
//          }
//          System.out.println("==========");

        }

    }

    static boolean isInRange(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc <N;
    }


}