import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2609 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        // 입력된 두 정수 중 큰 것을 a, 작은것을 b
        int a = Math.max(N, M);
        int b = Math.min(N, M);

        gcd(a, b);
        lcm(a, b);
    }

    // 최대공약수
    public static void gcd(int a, int b) {
        for (int i = b; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                System.out.println(i);
                break;
            }
        }
    }
    //최대 공배수
    public static void lcm(int a, int b) {
        for (int i = a; i <= a*b; i++) {
            if (i % a == 0 && i % b == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}