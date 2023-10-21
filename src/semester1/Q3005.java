package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q3005 {
    static int N, M;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        PriorityQueue<String> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != '#') {
                    if ((check(i - 1, j) && map[i-1][j] =='#') || i==0) {
                        StringBuilder s = new StringBuilder();
                        int k = i;
                        while(k <= N-1 && map[k][j] != '#') {
                            s.append(map[k][j]);
                            k++;
                        }
                        if (s.length()>1) pq.add(s.toString());
                    }
                    if ((check(i, j-1) && map[i][j-1] =='#') || j==0) {
                        StringBuilder s = new StringBuilder();
                        int k = j;
                        while(k <= M-1 && map[i][k] != '#') {
                            s.append(map[i][k]);
                            k++;
                        }
                        if (s.length()>1) pq.add(s.toString());
                    }
                }
            }
        }
        System.out.println(pq.poll());
    }

    public static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

}
