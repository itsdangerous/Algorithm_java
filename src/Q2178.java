import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q2178 {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static String[][] map;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        map = new String[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
        }
    }

    public static void bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[]{0, 0});

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();

            for (int i = 0; i < 4; i++) {
                int row = cur[0] + dx[i];
                int col = cur[1] + dy[i];

                if (row < 0 || row >= n || col < 0 || col >= m) {
                    continue;
                }

                if (!map[row][col].equals("1")) {
                    continue;
                }

                map[row][col] = String.valueOf(Integer.parseInt(map[cur[0]][cur[1]]) + 1);
                dq.offerLast(new int[]{row, col});
            }
        }
    }
}
