//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Q2636 {
//    int[] dr = {-1, 0, 1, 0};
//    int[] dc = {0, 1, 0, -1};
//    static int[][] map;
//    static int N, M;
//    static int[][] copy_map;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        map = new int[N][M];
//
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < M; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        while(true) {
//            if (isAllmelt()) break;
//
//            copy_map = copyMap(map);
//
//            bfs();
//            cnt++;
//        }
//
//
//    }
//
//    static void bfs(int r, int c) {
//
//
//        Queue<Integer> q = new LinkedList<>();
//        q.a
//
//    }
//
//    static boolean isAllmelt() {
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if (map[i][j] == 1) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    static int[][] copyMap(int[][] arr) {
//        int[][] tmp = new int[arr.length][arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            System.arraycopy(arr[i], 0, tmp[i], 0, arr[i].length);
//        }
//        return tmp;
//    }
//
//    static void bfs_airTo2(int[][] arr, int r, int c) {
//        Queue<Integer> q = new LinkedList<>();
//
//
//    }
//
//    static boolean check(int r, int c) {
//        return 0 <= r && r <= N && 0 <= c && c <= M;
//    }
//
//
//
//}
