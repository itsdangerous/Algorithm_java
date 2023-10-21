package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_4008 {
    static ArrayList<Character> calc;
    static char[] cc = new char[]{'+', '-', '*', '/'};
    static char[] result;
    static int[] nums;
    static int N,R;
    static int calc_cnt;
    static boolean[] visited;
    static int max;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
           max = Integer.MIN_VALUE;
           min = Integer.MAX_VALUE;

            calc = new ArrayList<>();
            N = Integer.parseInt(br.readLine());
            nums = new int[N];
            result = new char[N - 1];
            visited = new boolean[N - 1];

            //부호 배열 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                int c = Integer.parseInt(st.nextToken());
                for (int j = 0; j < c; j++) {
                    calc.add(cc[i]);
                }
            }
            calc_cnt = calc.size();
            // 숫자 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            perm(0);
            System.out.printf("#%d %d\n",t, max-min);

        }

    }

    static void perm(int cnt) {
        if (cnt == calc_cnt) {
            int total = nums[0];


            for (int i = 0; i < result.length; i++) {
                switch (result[i]) {
                    case '+':
                        total += nums[i + 1];
                        break;
                    case '-':
                        total -= nums[i + 1];
                        break;
                    case '*':
                        total *= nums[i + 1];
                        break;
                    case '/':
                        total /= nums[i + 1];
                        break;
                }
            }
            max = Math.max(max, total);
            min = Math.min(min, total);
            return;
        }

        for (int i = 0; i < calc_cnt; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            result[cnt] = calc.get(i);
            perm(cnt+1);
            result[cnt] = 0;
            visited[i] = false;

        }
    }
}
