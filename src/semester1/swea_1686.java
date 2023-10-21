//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class swea_1868 {
//    static class Info {
//        int x, y;
//        public Info(int y, int x) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//    static boolean check[][];
//    static char arr[][];
//    static int mine[][];
//    static int num, result;
//    final static int dx[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
//    final static int dy[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int test = Integer.parseInt(br.readLine().trim());
//        for (int t = 1; t <= test; t++) {
//            num = Integer.parseInt(br.readLine().trim());
//            // 초기화
//            result = 0;
//            arr = new char[num][num];
//            check = new boolean[num][num];
//            mine = new int[num][num];
//            for (int i = 0; i < num; i++)
//                arr[i] = br.readLine().toCharArray();
//
//            for (int i = 0; i < num; i++) {
//                for (int j = 0; j < num; j++) {
//                    if (arr[i][j] == '*') {
//                        for (int k = 0; k < 8; k++) {
//                            int nx = j + dx[k];
//                            int ny = i + dy[k];
//                            if (nx >= 0 && ny >= 0 && nx < num && ny < num)
//                                mine[ny][nx]++;
//                        }
//                        check[i][j] = true;
//                    }
//                }
//            }
//            Info ii;
//            // 0인것부터 다 구하기
//            for (int i = 0; i < num; i++) {
//                for (int j = 0; j < num; j++) {
//                    if (mine[i][j] == 0 && !check[i][j]) {
//                        result++;
//                        check[i][j] = true;
//                        Queue<Info> q = new LinkedList<>();
//                        q.offer(new Info(i, j));
//                        while (!q.isEmpty()) {
//                            ii = q.poll();
//                            int cx = ii.x;
//                            int cy = ii.y;
//                            for (int k = 0; k < 8; k++) {
//                                int nx = cx + dx[k];
//                                int ny = cy + dy[k];
//                                if (nx >= 0 && ny >= 0 && nx < num && ny < num && arr[ny][nx] != '*'&& !check[ny][nx]) {
//                                    check[ny][nx] = true;
//                                    if (mine[ny][nx] == 0)
//                                        q.offer(new Info(ny, nx));
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            for (int i = 0; i < num; i++) {
//                for (int j = 0; j < num; j++) {
//                    if (arr[i][j] != '*' && !check[i][j]) {
//                        check[i][j] = true;
//                        result++;
//                    }
//                }
//            }
//            System.out.println("#"+t+" "+result);
//        }
//    }
//}