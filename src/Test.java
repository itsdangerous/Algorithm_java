import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test {

    static int TC;
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[] point;
    static int total;
    static int[][] copyMap;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TC = Integer.parseInt(br.readLine());

        for (int T = 1; T <= TC; T++ ) {
            N = Integer.parseInt(br.readLine());
            total = 0;
            map = new int[N][N];
            visited = new boolean[N][N];
            point = new int[2];
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j< N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2) {
                        point[0] = i;
                        point[1] = j;
                    }
                }
            }
            copyMap = copyMap(map);

            dfs(0,point[0],point[1]);
            printMap(copyMap);
            int result =0;
            for (int i =0; i< N; i++) {
                for (int j=0; j<N; j++) {
                    if (copyMap[i][j] == 3) result++;
                }
            }
            System.out.println(result);

        }
    }

    public static void dfs(int cnt, int r, int c) {
        if (cnt == 4) {

            for(int i=0; i< N; i++) {
                for(int j=0; j<N; j++) {
                    if(map[i][j]== 3) copyMap[i][j] =3;
                }
            }
            return;
        }

        for (int i=0; i<4; i++) {

            int nr = r;
            int nc = c;

            int count = 0;
            while(true) {
                nr += dr[i];
                nc += dc[i];

                if(!check(nr, nc)) break;

                if(count == 1 && (map[nr][nc] == 0 || map[nr][nc] == 3)) {
//                    dfs(cnt+1, nr, nc);
                    continue;
                }

                if(count == 1 && map[nr][nc] == 1) {

                    map[nr][nc] = 2;
                    map[r][c] = 0;
                    dfs(cnt+1, nr, nc);
                    map[nr][nc] = 3;
                    map[r][c] = 0;
                }
                if(count == 0 && (map[nr][nc] == 1 || map[nr][nc] == 3)) {
                    count++;
                }
            }

        }
    }

    public static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    public static int[][] copyMap(int[][] arr) {
        int[][] tmp = new int [N][N];
        for (int i = 0; i < N; i++) {
            for (int j =0; j < N; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        return tmp;

    }
    public static void printMap(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j =0; j < N; j++) {
                System.out.print(arr[i][j]+" ");
            }System.out.println();
        }
        System.out.println();

    }
}
