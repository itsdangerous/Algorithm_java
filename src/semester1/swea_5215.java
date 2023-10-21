package semester1;// nPr 서로다른 n 개에서 서로다른 r개를 선택후 나열
// 5p3 = 5*4*3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5215 {
    static int max_calorie;
    static int max;
    static int N;
    static int[] taste;
    static int[] calory;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            max_calorie = Integer.parseInt(st.nextToken());

            taste = new int[N];
            calory = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                taste[i]= Integer.parseInt(st.nextToken());
                calory[i] = Integer.parseInt(st.nextToken());

            }
            max = -1;
            //-----------------
            power(0,0,0);
            System.out.printf("#%d %d\n",t, max);

        }
    }

    static void power(int cnt, int cal_total, int score) {
        if (cal_total > max_calorie) {
            return;
        }

        if(cnt==N) {
            max = Math.max(max, score);
            return;
        }
        power(cnt + 1, cal_total + calory[cnt], score + taste[cnt]);

        power(cnt + 1, cal_total, score);

    }
}