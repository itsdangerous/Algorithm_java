import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//방향 전환 -- dp
//SWEA-8382
public class swea_8382_2bfs {

    //flag = 0 : 세로만 이동 가능
    //flag = 1 : 가로만 이동 가능
    static int[][][] direction = {
            {{-1, 0}, {1, 0}},
            {{0, 1}, {0, -1}}
    };
    static boolean[][] visited;
    static int flag;
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

            int min;

            min = Math.min(bfs(0), bfs(1));
            System.out.printf("#%d %d\n", t, min);
        }
    }

    static int bfs(int flag) {
        int cnt = 0;
        visited = new boolean[201][201];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x1, y1});
        visited[x1][y1] = true;
        if (x1 == x2 && y1 == y2) return cnt;
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            flag = (flag + 1) % 2;
            while (size-- > 0) {
                int[] point = q.poll();
                int x = point[0];
                int y = point[1];
                for (int i = 0; i < 2; i++) {
                    int dx = x + direction[flag][i][0];
                    int dy = y + direction[flag][i][1];
                    if(!check(dx,dy)) continue;
                    if(visited[dx][dy]) continue;
                    if(dx == x2 && dy == y2) return cnt;
                    visited[dx][dy] = true;
                    q.offer(new int[]{dx, dy});
                }
            }
        }
        return cnt;
    }

    static boolean check(int x, int y) {
        return 0 <= x && x <= 200 && 0 <= y && y <= 200;
    }

}