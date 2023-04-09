import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1987 {
    static int R, C;
    static boolean[] visited;
    static char[][] map;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[26];

        //map 입력 받기
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        dfs(0,0,map[0][0]-'0'-17, 0);
        System.out.println(max);
    }

    static void dfs(int r, int c, int alpha, int tot) {

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!check(nr,nc)) continue;
            if (visited[alpha]) continue;

            visited[alpha] = true;
            dfs(nr, nc, map[nr][nc]-'0'-17, tot+1);
            visited[alpha] = false;
        }
        max = Math.max(max, tot);
    }

    static boolean check(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

}
