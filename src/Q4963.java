import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Q4963 {

    static int[] dx = {-1, 1, 0, 0, -1, +1, -1, +1};
    static int[] dy = {0, 0, -1, 1, -1, -1, +1, +1};
    static int w, h;
    static Deque<int[]> deque;
    static int[][] map;
    static String[] str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            str = br.readLine().split(" ");
            w = Integer.parseInt(str[0]);
            h = Integer.parseInt(str[1]);
            map = new int[h][w];
            int result = 0;


            if (w == 0 && h == 0) {
                break;
            }

            for (int i = 0; i < h; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(s[j]);
                }

            }


            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        result += 1;
                        bfs(i, j);
                    }
                }
            }
            System.out.println(result);
        }
    }

    static void bfs(int y, int x) {
        deque = new LinkedList<>();
        deque.add(new int[]{y, x});

        while (!deque.isEmpty()) {
            int[] t = deque.poll();

            for (int i = 0; i < 8; i++) {
                int nx = t[0] + dx[i];
                int ny = t[1] + dy[i];

                if (nx < 0 || nx >= w || ny < 0 || ny >= h) {
                    continue;
                }
                if (map[ny][nx] == 0) {
                    continue;
                }
                if (map[ny][nx] == 1) {
                    map[ny][nx] = 0;
                    deque.add(new int[]{ny, nx});
                }
            }
        }
        return;
    }



}
