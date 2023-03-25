import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11562 {

    static int N, M, K;
    static long[][] dist;
    static long INF = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new long[N+1][N+1];

        // 그래프 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i==j) continue;
                dist[i][j] = INF;
            }
        }
        //그래프 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (weight == 0) {
                dist[from][to] = 0;
                dist[to][from] = 1;
            }
            if (weight == 1) {
                dist[from][to] = 0;
                dist[to][from] = 0;
            }
        }
        K = Integer.parseInt(br.readLine());

        floydWarshall();
//        printArr(dist);
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            System.out.println(dist[from][to]);
        }

    }

    private static void floydWarshall() {

        for (int via = 1; via <= N; via++) {
            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= N; c++) {
                    if (dist[r][via] + dist[via][c] < dist[r][via]) continue;
                    if (dist[r][via] + dist[via][c] < dist[via][c]) continue;
                    dist[r][c] = Math.min(dist[r][c], dist[r][via] + dist[via][c]);
                }
            }
        }
    }
}