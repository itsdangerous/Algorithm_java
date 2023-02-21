//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Q2630_2 {
//    private static int N, R, C;
//    private static int[][] map;
//    static int count = 0;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(br.readLine());
//        R = Integer.parseInt(st.nextToken());
//        C = Integer.parseInt(st.nextToken());
//
//        N = 1 << n;
//        map = new int[N][N];
//        for (int i = 0; i < N; i++) {
//            String[] str = br.readLine().split(" ");
//            for (int j = 0; j < n; j++) {
//                map[i][j] = Integer.parseInt(str[j]);
//            }
//        }
//        solve(n, 0, 0);
//    }
//
//    static void solve(int cnt, int r, int c) {
//
//        if (R <= r && C <= c) {
//
//        }
//
//        solve(cnt / 2, r, c);
//        solve(cnt / 2, r, c + cnt / 2);
//        solve(cnt / 2, r + cnt / 2, c);
//        solve(cnt / 2, r + cnt / 2, c + cnt / 2);
//    }
//
//    static boolean check(int cnt, int r, int c ) {
//        int tmp = map[r][c];
//        for (int i = r; i < r+cnt; i++) {
//            for (int j = c; j < c+cnt; j++) {
//                if (map[i][j] != tmp) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//
//}