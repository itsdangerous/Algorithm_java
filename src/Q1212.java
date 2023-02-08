import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1212 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        if (s.equals("0")) {
            System.out.println(s);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            solve(s.charAt(i));
        }

        if (sb.charAt(0) == '0') {
            if (sb.charAt(1) == '0') {
                System.out.println(sb.substring(2));
            } else {
                System.out.println(sb.substring(1));
            }
        } else {
            System.out.println(sb);
        }

    }

    public static void solve(char s) { // 8진수의 한 자리 수 321코드로 변환
        int n = s - '0';
        int k = 8;
        for (int i = 0; i < 3; i++) {
            k = k >> 1;
            sb.append(n / k);
            n = n % k;
        }
    }
}