/*swea_1949 : 등산로 조정
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PoOKKAPIDFAUq
*/

import java.io.*;
import java.util.StringTokenizer;

public class swea_1949 {
    static int N, K;
    static int[][] map;
    static int answer;
    static int max;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void setInputFile(String path, String fileName) throws FileNotFoundException {
            String curWorkingDir = System.getProperty("user.dir");
            System.setIn(new FileInputStream(curWorkingDir + path + fileName));
        }
    public static void main(String[] args) throws IOException {
        String remainPath = "\\src\\tc\\";
        String fileName = "swea_1949.txt";
        setInputFile(remainPath, fileName);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int TC = 1; TC <= T; TC++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            max = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, map[i][j]);
                }
            }
//            printArr(map);
            solve();
            System.out.printf("#%d %d\n", TC, answer);

        }
    }

    private static void solve() {
        answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != max) continue;
//                System.out.println(max+" " + map[i][j] + ", " + i + " " + j);
                visited = new boolean[N][N];
                visited[i][j] = true;
                dfs(0, i, j, true);
            }
        }
    }

    static void dfs(int cnt, int r, int c, boolean possible) {

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (!check(nr, nc)) continue;
            if (visited[nr][nc]) continue;
            if (!possible && map[r][c] <= map[nr][nc]) continue; // 탐색할 곳이 더 높은 경우인데 못깎을 경우
            if (possible && map[r][c] <= map[nr][nc] && map[nr][nc] - map[r][c] > K) continue;

            if (map[r][c] > map[nr][nc]) {
                int tmp = map[nr][nc];
                map[nr][nc] = map[r][c] -1;
                visited[nr][nc] = true;
                dfs(cnt + 1, nr, nc, possible);
                visited[nr][nc] = false;
                map[nr][nc] = tmp;
            }
            else if (map[r][c] <= map[nr][nc] && map[nr][nc] - map[r][c] <= K && possible) {
                int tmp = map[nr][nc];
                map[nr][nc] = map[r][c] -1;
                visited[nr][nc] = true;
                dfs(cnt + 1, nr, nc, false);
                visited[nr][nc] = false;
                map[nr][nc] = tmp;
            }
            else {
                System.out.println('ㅋ');
            }
        }
        answer = Math.max(answer, cnt + 1);

    }

    private static boolean check(int nr, int nc) {
        return 0 <= nr && nr < N && 0 <= nc && nc < N;
    }

    static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
