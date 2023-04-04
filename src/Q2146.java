import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2146 {
    static final int INF = Integer.MAX_VALUE;
    static int N;
    static int[][] map;
    static int answer = INF;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    static ArrayList<Island> islandList; // 섬을 담을 리스트
    static int size;
    static int[][] dist;

    // 섬의 정보를 담을 클래스
    // 섬은 섬이 갖고 있는 point의 개수 : size
    // 그 point의 정보를 담을 배열 : points
    // 해당 섬이 map에서 몇 번째 번호로 표시되는지 : value
    static class Island {
        int size;
        ArrayList<Point> points;
        int value;

        public Island(int value) {
            this.value = value;
            this.points = new ArrayList<>();
            this.size = 0;
        }

        public void addPoint(Point p) {
            this.size++;
            this.points.add(p);
        }
    }

    static class Point {
        int r;
        int c;
        int num;

        public Point(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N= Integer.parseInt(br.readLine());
        islandList = new ArrayList<>();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //1. floodFill을 통해 주어진 입력에 따라 섬을 구분 할 수 있도록 map에 마킹
        floodFill();

        size = islandList.size();

        //2. 섬과 섬 사이의 거리를 구한 뒤 dist배열을 업데이트할 메서드
        findMinDist();

        System.out.println(answer-1);

    }

    static void findMinDist() {
        for (int island1 = 0; island1 < size; island1++) {
            for (int island2 = island1 + 1; island2 < size; island2++) {
                updateDist(island1, island2);
            }
        }
    }

    static void updateDist(int num1, int num2) {
        Island island1 = islandList.get(num1);
        Island island2 = islandList.get(num2);

        for (int i = 0; i < island1.size; i++) {
            for (int j = 0; j < island2.size; j++) {
                getPointDist(island1.points, island2.points);
            }
        }
    }

    private static void getPointDist(ArrayList<Point> points1, ArrayList<Point> points2) {
        for (int i = 0; i < points1.size(); i++) {
            for (int j = 0; j < points2.size(); j++) {
                answer = Math.min(answer, Math.abs(points1.get(i).r - points2.get(j).r) + Math.abs(points1.get(i).c - points2.get(j).c));
                if (answer == 0) {
                    System.out.println(answer);
                    System.exit(0);
                }
            }
        }
    }

    static void floodFill() {
        int k = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j, ++k);
                }
            }
        }
    }

    static void bfs(int r, int c, int k) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r, c});
        Island ls = new Island(k + 1);
        Point p = new Point(r, c, k + 1);
        ls.addPoint(p);
        map[r][c] = k+1;

        while (!que.isEmpty()) {
            int[] point = que.poll();
            for (int d = 0; d < 4; d++) {
                int nr = point[0] + dr[d];
                int nc = point[1] + dc[d];
                if(!check(nr, nc)) continue;
                if(map[nr][nc] != 1) continue;
                que.offer(new int[]{nr, nc});
                p = new Point(nr, nc, k + 1);
                ls.addPoint(p);
                map[nr][nc] = k + 1;

            }
        }
        islandList.add(ls);
    }
    private static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    private static void printArr(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

}
