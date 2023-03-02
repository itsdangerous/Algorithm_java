import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class swea_5644 {
    static int M, A;
    static int[] dr = {0, -1, 0, 1, 0};
    static int[] dc = {0, 0, 1, 0, -1};
    static int[][] Cs;

    static int[] moving_A;
    static int[] moving_B;

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            moving_A = new int[M];
            moving_B = new int[M];

            for (int i = 0; i < M; i++) {
                moving_A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                moving_B[i] = Integer.parseInt(st.nextToken());
            }
            Cs = new int[A][4];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                Cs[i][1] = Integer.parseInt(st.nextToken()) - 1; // c
                Cs[i][0] = Integer.parseInt(st.nextToken()) - 1; // r
                Cs[i][2] = Integer.parseInt(st.nextToken()); // capacity
                Cs[i][3] = Integer.parseInt(st.nextToken()); // Performance

            }
            answer = 0;
            System.out.printf("#%d ",t);
            solve();

        }
    }

    static void solve() {
        int r1 = 0;
        int c1 = 0;

        int r2 = 9;
        int c2 = 9;
        int tmp1 = 0;
        int tmp2 = 0;
        for (int i = 0; i < A; i++) {
            if (distance(r1, c1, i) <= Cs[i][2]) {
                tmp1 = Math.max(tmp1, Cs[i][3]);
            }
            if (distance(r2, c2, i) <= Cs[i][2]) {
                tmp2 = Math.max(tmp2, Cs[i][3]);
            }
        }
        answer += tmp1 + tmp2;

        for (int i = 0; i < M; i++) {
            r1 += dr[moving_A[i]];
            c1 += dc[moving_A[i]];

            r2 += dr[moving_B[i]];
            c2 += dc[moving_B[i]];
            ArrayList<Integer> BCS_A = new ArrayList<>();
            ArrayList<Integer> BCS_B = new ArrayList<>();
            for (int j = 0; j < A; j++) {
                if (distance(r1, c1, j) <= Cs[j][2]) {
                    BCS_A.add(j);

                }
                if (distance(r2, c2, j) <= Cs[j][2]) {
                    BCS_B.add(j);
                }
            }


            int now = 0;
            if (BCS_A.size() != 0) {
                if (BCS_B.size() != 0) {
                    for (Integer value : BCS_A) {
                        for (Integer integer : BCS_B) {
                            if (!Objects.equals(value, integer)) {
                                now = Math.max(now, Cs[value][3] + Cs[integer][3]);
                            } else {
                                now = Math.max(now, Cs[value][3]);
                            }
                        }
                    }
                }
                else {
                    // A만 걸렸을 때
                    for (Integer integer : BCS_A) {
                        now = Math.max(now, Cs[integer][3]);
                    }
                }
            }
            else {
                // B만 걸렸을 때
                if (BCS_B.size() != 0) {
                    for (Integer integer : BCS_B) {
                        now = Math.max(now, Cs[integer][3]);
                    }
                }
            }
//            System.out.print(BCS_A+" "+BCS_B+" ");
//            System.out.printf("%d, %d, %d, %d\n", r1, c1, r2, c2);

            answer += now;
        }
        System.out.println(answer);
    }

    static int distance(int r, int c, int k) {
        return Math.abs(Cs[k][0] - r) + Math.abs(Cs[k][1] - c);
    }
}
