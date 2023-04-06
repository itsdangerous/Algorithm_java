/*
BOJ - 16236 : 아기상어
https://www.acmicpc.net/problem/16236
*/



import java.io.*;
import java.util.*;

public class Q16236 {
    static int N;
    static int[][] map;
    static Shark shark;
    static boolean isEat;
    static int time;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static class Shark {
        int r, c;
        int level;
        int food;
        public Shark(int r, int c, int level, int food) {
            this.r = r;
            this.c = c;
            this.level = level;
            this.food = food;
        }
        public void eat(int fish) {
            if (this.level > fish) {
                this.food++;
                if(food == level) {
                    level++;
                    food = 0;
                }
            }
        }
    }
    public static void setInputFile(String path, String fileName) throws FileNotFoundException {
        String curWorkingDir = System.getProperty("user.dir");
        System.setIn(new FileInputStream(curWorkingDir + path + fileName));
    }
    public static void main(String[] args) throws IOException {
        String remainPath = "\\src\\tc\\";
        String fileName = "Q16236.txt";
        setInputFile(remainPath, fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int T = 0; T < 7; T++) {

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            time = 0;
            isEat = true;

            shark = new Shark(0, 0, 2, 0);
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 9) {
                        shark.r = i;
                        shark.c = j;
                    }
                }
            }
            time = 0;
            while (isEat) {
                findFood();
            }
            System.out.println(time);
        }
    }

    public static void findFood() {
        Queue<int[]> pq = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        pq.offer(new int[]{shark.r, shark.c});
        visited[shark.r][shark.c] = true;
        ArrayList<int[]> list = new ArrayList<>();
        isEat = false;
        int cnt = -1;
        while (!pq.isEmpty()) {
            int size = pq.size();
            cnt++;
            while (size-- > 0) {
                int[] point = pq.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = point[0] + dr[i];
                    int nc = point[1] + dc[i];
                    if (!check(nr, nc)) continue;
                    if (visited[nr][nc]) continue;
                    if (map[nr][nc] == 0 || map[nr][nc] == shark.level) {
                        pq.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                    if (map[nr][nc] != 0 && map[nr][nc] < shark.level) {
                        isEat = true;
                        list.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }

        list.sort((e1, e2) -> {
            if (e1[0] == e2[0]) {
                return e1[1] - e2[1];
            }
            return e1[0] - e2[0];
        });

        if (isEat) {
            int[] p = list.get(0);
            shark.eat(map[p[0]][p[1]]);
            shark.r = p[0];
            shark.c = p[1];
            map[p[0]][p[1]] = 0;
            time += cnt;
            System.out.printf("r = %d, c = %d, cnt = %d, time = %d\n", p[0], p[1], cnt, time);

        }
    }
    private static boolean check(int nr, int nc) {
        return 0 <= nr && nr < N && 0 <= nc && nc < N;
    }


    static void printMap(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}

