import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16974 {

    static int N;
    static long X;
    static long[] burger = new long[51]; // 레벨 당 햄버거
    static long[] patty = new long[51]; // 레벨 당 햄버거의 패티

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Long.parseLong(st.nextToken());

        makeArr();
        long answer = eat(N, X);
        System.out.println(answer);

    }

    public static void makeArr() {
        burger[0] = 1;
        patty[0] = 1;
        for (int i = 1; i < N + 1; i++) {
            burger[i] = 1 + burger[i - 1] + 1 + burger[i - 1] + 1;
            patty[i] = patty[i-1] + 1 + patty[i-1];
        }
    }

    public static long eat(int cnt, long x) {
        if (cnt == 0) return x;
        if (x==1) return 0;
        if(x <=1 + burger[cnt-1]) return eat(cnt - 1, x - 1);
        if(x ==1 + burger[cnt-1] + 1) return patty[cnt - 1] + 1;
        if(x<=1+burger[cnt-1]+1+burger[cnt-1]) return patty[cnt - 1] + 1 + eat(cnt - 1, x - (1 + burger[cnt - 1] + 1));
        else return patty[cnt - 1] + 1 + patty[cnt - 1];
    }

}
