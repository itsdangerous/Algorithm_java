import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17144 {
    static int R,C, T;
    static int[][] map;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    static boolean[] visited;
    static Queue<int[]> que;
    static ArrayList<int[]> conditioner;
    static int count;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         R = Integer.parseInt(st.nextToken());
         C = Integer.parseInt(st.nextToken());
         T = Integer.parseInt(st.nextToken());

         map = new int[R][C];
         conditioner = new ArrayList<>();

         que = new LinkedList<>();
         count = 0;
         for (int i = 0; i < R; i++) {
             st = new StringTokenizer(br.readLine());
             for (int j = 0; j < C; j++) {
                 map[i][j] = Integer.parseInt(st.nextToken());
                 if (map[i][j] == -1) {
                     conditioner.add(new int[]{i, j});
                 }
             }
         }
         solve();
        System.out.println(count);
     }

    static void solve() {

        bfs();
        printArr(map);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) continue;
                count += map[i][j];
            }
        }
    }


    static void bfs() {
         int time = 0;
         while (time < T) {
             que = new LinkedList<>();
             inputQueue();
             time++;
             int size = que.size();
             while (size-- > 0) {
                 int[] point = que.poll();
                 int r = point[0];
                 int c = point[1];
                 int value = point[2];
                 if (value == 1) continue;
                 for (int i = 0; i < 4; i++) {
                     int nr = r + dr[i];
                     int nc = c + dc[i];
                     if (!check(nr, nc)) continue;
                     if (nr == conditioner.get(0)[0] && nc == conditioner.get(0)[1]) continue;
                     if (nr == conditioner.get(1)[0] && nc == conditioner.get(1)[1]) continue;
                     int dust = value / 5;
                     map[r][c] -= dust;
                     map[nr][nc] += dust;
                     que.offer(new int[]{r, c, map[r][c]});
                     que.offer(new int[]{nr, nc, map[nr][nc]});
                 }
             }
             initRotateTop();
             initRotateBottom();
         }
     }

    private static void inputQueue() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0 || map[i][j] == -1) continue;
                que.offer(new int[]{i, j, map[i][j]});
            }
        }
    }

    static void initRotateTop() {
        int startR1 = conditioner.get(0)[0];
        int curR1 = conditioner.get(0)[0]-1;
        int curC1 = conditioner.get(0)[1];
        int c = startR1 + 1;
        int cnt = 0;
        int i;
        while (cnt < 2 * R + 2 * (c-1) - 3) {
            if (cnt < startR1 - 1) i = 0;
            else if (cnt < startR1 - 1 + C - 1) i = 1;
            else if (cnt < startR1 - 1 + C - 1 + c - 1) i = 2;
            else i = 3;
//            System.out.printf("curR1 = %d, curC1 = %d, i = %d\n",curR1, curC1, i);

            map[curR1][curC1] = map[curR1 + dr[i]][curC1 + dc[i]];
            curR1 = curR1 + dr[i];
            curC1 = curC1 + dc[i];
            cnt++;
        }
        map[conditioner.get(0)[0]][conditioner.get(0)[1]+1] = 0;

    }

    static void initRotateBottom() {
        int startR2 = conditioner.get(1)[0];
        int curR2 = conditioner.get(1)[0]+1;
        int curC2 = conditioner.get(1)[1];
        int c = R - startR2 + 1;
        int cnt = 0;
        int i;
        while (cnt < 2 * R + 2 * (c-1) -3) {
            if (0 <= cnt && cnt < R - startR2 - 2) i = 2;
            else if (R - startR2 - 2 <= cnt && cnt < R - startR2 - 2 + C -1) i = 1;
            else if (R - startR2 - 2 + C - 1 <= cnt && cnt < R - startR2 - 2 + C - 1 + R - startR2+1) i = 0;
            else  i = 3;

//            System.out.printf("curR2 = %d, curC2 = %d, i = %d\n",curR2, curC2, i);
            map[curR2][curC2] = map[curR2 + dr[i]][curC2 + dc[i]];
            curR2 = curR2 + dr[i];
            curC2 = curC2 + dc[i];
            cnt++;
        }
        map[conditioner.get(1)[0]][conditioner.get(1)[1]+1] = 0;
    }

    static boolean check(int nr, int nc) {
        return 0 <= nr && nr < R && 0 <= nc && nc < C;
    }

    static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
