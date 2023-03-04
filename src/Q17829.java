import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q17829 {

    static int[][] map;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = solve(N, map);
        System.out.println(result);

    }

    static int solve(int cnt, int[][] arr) {
        if (cnt == 2) {
            return search(0, 0, arr);
        }

        return solve(cnt / 2, nextMap(cnt, arr));
    }

    public static int[][] nextMap(int n, int[][] arr) {

        int[][] tmp = new int[n/2][n/2];
        int r = 0;
        for (int i = 0; i < n; i+=2) {
            int c = 0;
            for (int j = 0; j <n; j+=2) {
                tmp[r][c] = search(i,j, arr);
                c++;
            }
            r++;
        }
        return tmp;
    }

    public static int search(int r, int c, int[][] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = r; i < r + 2; i++) {
            for (int j = c; j < c + 2; j++) {
                list.add(arr[i][j]);
            }
        }
        Collections.sort(list);
        return list.get(2);
    }
    
}
