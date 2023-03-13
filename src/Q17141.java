import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17141 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static boolean[] isSelected;
    static ArrayList<int[]> virusPoints;
    static int R; // 바이러스 개수
    static int[] dr = new int[] {-1, 0, 1, 0};
    static int[] dc = new int[] {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        virusPoints = new ArrayList<>();
        map = new int[N][N];
        //map 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virusPoints.add(new int[]{i, j});
                }
            }
        }
        R = virusPoints.size(); // R개중 M개 뽑아야 함.
        isSelected = new boolean[R];

        combi(0, 0);
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);

    }
    public static int bfs(int[][] arr, ArrayList<int[]> points) {

        Queue<int[]> que = new LinkedList<>();

        for (int[] point : points) {
            int r = point[0];
            int c = point[1];
            que.offer(new int[]{r, c});
        }

        int cnt = 0;
        while(true) {
            int k = que.size();
            while (k-- > 0) {
                int[] p = que.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = p[0] + dr[i];
                    int nc = p[1] + dc[i];
                    if (!check(nr, nc)) continue;
                    if (arr[nr][nc] >= 1) continue;
                    que.offer(new int[]{nr, nc});
                    arr[nr][nc] = cnt+1;
                }
            }
            if(que.size() == 0) {
                if (isOk(arr)) {
                    return cnt;
                }
                else {
                    return Integer.MAX_VALUE;
                }
            }
            cnt++;

        }
    }
    
    public static void combi(int cnt, int start) {
        if (cnt == M) {
            ArrayList<int[]> point = new ArrayList<>();
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                System.arraycopy(map[i], 0, arr[i], 0, N);
            }

            for (int i = 0; i < R; i++) {
                if(isSelected[i]) {
                    point.add(virusPoints.get(i));
                }
                if (!isSelected[i]) {
                    arr[virusPoints.get(i)[0]][virusPoints.get(i)[1]] = 0;
                }
            }
            answer = Math.min(answer, bfs(arr, point));
            //로직
            return;
        }

        for (int i = start; i < R; i++) {
            if (isSelected[i]) continue;

            isSelected[i] = true;
            combi(cnt + 1, i + 1);
            isSelected[i] = false;
        }
    }

    public static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    public static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean isOk(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
