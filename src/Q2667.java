import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class Q2667 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Deque<int[]> deque;
    static ArrayList<Integer> cnt = new ArrayList<>();
    static int N;
    static int[][] map;
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    result += 1;
                    bfs(i, j);
                }
            }
        }
        System.out.println(result);
        Collections.sort(cnt);
        for (int i = 0; i < cnt.size(); i++) {
            System.out.println(cnt.get(i));
        }
    }


    static void bfs(int y, int x) {
        deque = new LinkedList<>();
        deque.add(new int[]{y, x});
        int c = 1;

        while (!deque.isEmpty()) {
            int[] tmp = deque.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp[1] + dx[i];
                int ny = tmp[0] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (map[ny][nx] == 0) {
                    continue;
                }
                if (map[ny][nx] == 1) {
                    c++;
                    map[ny][nx] = 0;
                    deque.add(new int[]{ny, nx});
                }
            }
        }

        if(c!=1)
            c--;
        cnt.add(c);
    }
}
