import java.io.*;
import java.util.*;

public class Test {
    static final int[][] DIR = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static final int EMPTY = -1;
    static final int ISLAND = -2;
    static final int GOAL_ISLAND = 0;
    static final int LENGTH = 1;
    static int N, M;
    static int[][] map;
    static int[] parent;
    static int numOfIsland = 0;
    static int[][] dist;
    static boolean[][] hasBridge;
    static Map<Integer, List<Point>> islandInfo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int element = Integer.parseInt(st.nextToken());
                if (element == 0) {
                    map[i][j] = EMPTY;
                } else {
                    map[i][j] = ISLAND;
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == ISLAND) {
                    islandInfo.put(numOfIsland, new ArrayList<>());
                    bfs(i, j, numOfIsland++);
                }
            }
        }

        dist = new int[numOfIsland][numOfIsland];
        hasBridge = new boolean[numOfIsland][numOfIsland];
        initParent();
        initDist();

        for (int i=0; i<numOfIsland; i++) {
            updateDistance(i);
        }

        PriorityQueue<Bridge> pq = new PriorityQueue<>();
        for (int i=0; i<numOfIsland; i++) {
            for (int j=i+1; j<numOfIsland; j++) {
                if (hasBridge[i][j]) {
                    pq.add(new Bridge(i, j));
                }
            }
        }


        int connectedIsland = 1;
        int totalLength = 0;
        while (!pq.isEmpty() && connectedIsland < numOfIsland) {
            Bridge bridge = pq.poll();
            if (union(bridge.v1, bridge.v2)) {
                connectedIsland++;
                totalLength += bridge.length;
            }
        }

        sb.append(connectedIsland == numOfIsland ? totalLength : -1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void initDist() {
        for (int i=0; i<numOfIsland; i++) {
            for (int j=0; j<numOfIsland; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    private static void updateDistance(int island) {
        for (Point point : islandInfo.get(island)) {
            findBridge(point, island);
        }
    }

    private static void findBridge(Point point, int island) {
        for (int d=0; d<4; d++) {
            int nextX = point.x + DIR[d][0];
            int nextY = point.y + DIR[d][1];
            if (isInRange(nextX, nextY) && map[nextX][nextY] == EMPTY) {
                int[] bridgeInfo = findOneWayBridge(point.x, point.y, d);
                if (bridgeInfo[GOAL_ISLAND] != EMPTY && bridgeInfo[GOAL_ISLAND] != island && bridgeInfo[LENGTH] >= 2) {
                    dist[island][bridgeInfo[GOAL_ISLAND]] = Math.min(dist[island][bridgeInfo[GOAL_ISLAND]], bridgeInfo[LENGTH]);
                    dist[bridgeInfo[GOAL_ISLAND]][island] = dist[island][bridgeInfo[GOAL_ISLAND]];
                    hasBridge[island][bridgeInfo[GOAL_ISLAND]] = true;
                    hasBridge[bridgeInfo[GOAL_ISLAND]][island] = true;
                }
            }
        }
    }

    private static int[] findOneWayBridge(int x, int y, int d) {
        int count = 0;
        int nextX = x + DIR[d][0];
        int nextY = y + DIR[d][1];

        while (isInRange(nextX, nextY) && map[nextX][nextY] == EMPTY) {
            count++;
            nextX += DIR[d][0];
            nextY += DIR[d][1];
        }

        if (!isInRange(nextX, nextY)) {
            return new int[]{EMPTY, EMPTY};
        }
        return new int[]{map[nextX][nextY], count};
    }

    private static void initParent() {
        parent = new int[numOfIsland + 1];
        for (int i = 1; i <= numOfIsland; i++) {
            parent[i] = i;
        }
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
        return true;
    }

    private static void bfs(int i, int j, int numOfIsland) {
        Deque<Point> q = new ArrayDeque<>();
        q.add(new Point(i, j));
        map[i][j] = numOfIsland;
        islandInfo.get(numOfIsland).add(new Point(i, j));

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int[] d : DIR) {
                int nextX = now.x + d[0];
                int nextY = now.y + d[1];
                if (isInRange(nextX, nextY) && map[nextX][nextY] == ISLAND) {
                    map[nextX][nextY] = numOfIsland;
                    islandInfo.get(numOfIsland).add(new Point(nextX, nextY));
                    q.add(new Point(nextX, nextY));
                }
            }
        }
    }

    private static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static class Bridge implements Comparable<Bridge> {
        int v1, v2;
        int length;

        public Bridge(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
            this.length = dist[v1][v2];
        }

        @Override
        public int compareTo(Bridge o) {
            return this.length - o.length;
        }
    }


    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}