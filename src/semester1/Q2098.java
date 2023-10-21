//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Q2098 {
//    static int N;
//    static int [][] dist;
//    static int [][] dp;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//
//        N = Integer.parseInt(br.readLine());
//        dist = new int[N][N];
//        dp = new int[N][N];
//        for (int i = 0; i < N; i++) {
//            Arrays.fill(dp[i], Integer.MAX_VALUE);
//        }
//
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                int d = Integer.parseInt(st.nextToken());
//                if (d == 0) {
//                    dist[i][j] = Integer.MAX_VALUE;
//                }
//                else {
//                    dist[i][j] = d;
//                }
//            }
//        }
//
//        solveDP(0, 0, 0, 0);
//        printArr(dp);
//
//    }
//
//    private static void solveDP(int visited, int cur, int start, int distance) {
//        if (visited == 1<<N -1) {
//            answer = Math.min(answer, dist[cur][start]);
//            return;
//        }
//
//        for (int i = 0; i < N; i++) {
//            if (isVisited(visited, i)) continue;
//
//            int changedVisited = setVisit(visited, i);
//            solveDP(changedVisited, i, start, distance + dist[cur][i]);
//        }
//    }
//
//    private static int setVisit(int visited, int i) {
//        return visited + (1 << i);
//    }
//
//    private static boolean isVisited(int visited, int index) {
//        return (1 << index & visited) == 1 << index;
//    }
//
//    private static void printArr(int[][] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
//    }
//}
