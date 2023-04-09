/*swea_1247 : 최적 경로
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD
*/

import java.io.*;
import java.util.StringTokenizer;

public class swea_1247 {
    static int [][] dist;
    static int N;
    static int answer;
    static int[][] points;
    static int[] p;
    static int[] nums;
    static boolean[] visited;

    public static void setInputFile(String path, String fileName) throws FileNotFoundException {
        String curWorkingDir = System.getProperty("user.dir");
        System.setIn(new FileInputStream(curWorkingDir + path + fileName));
    }
    public static void main(String[] args) throws IOException {
        String remainPath = "\\src\\tc\\";
        String fileName = "swea_1247.txt";
        setInputFile(remainPath, fileName);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int TC = 1; TC < T + 1; TC++) {
            N = Integer.parseInt(br.readLine());
            answer = Integer.MAX_VALUE;
            dist = new int[N+2][N+2];
            points = new int[N + 2][N + 2];
            visited = new boolean[N + 2];
            p = new int[N];
            nums = new int[N];
            for (int i = 0; i < N; i++) {
                p[i] = i+2;
            }
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N+2; i++) {
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
            }

            makeDist();
            dfs(0,0);
            System.out.printf("#%d %d\n", TC, answer);
        }

    }

    private static void dfs(int cnt, int tot) {
        if (tot > answer) return;
        if (cnt == N) {
            int hap = tot;
            hap += dist[nums[0]][0];
            hap += dist[nums[N-1]][1];
            answer = Math.min(answer, hap);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            nums[cnt] = p[i];
            if(cnt > 0) dfs(cnt + 1, tot + dist[nums[cnt-1]][nums[cnt]]);
            else dfs(cnt + 1, 0);
            nums[cnt] = 0;
            visited[i] = false;
        }
    }
    private static void makeDist() {

        for (int i = 0; i < N + 2; i++) {
            for (int j = 0; j < N + 2; j++) {
                dist[i][j] = distance(points[i], points[j]);
            }
        }
    }

    private static int distance(int[] point, int[] point1) {
        return Math.abs(point[0] - point1[0]) + Math.abs(point[1] - point1[1]);
    }

    static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}