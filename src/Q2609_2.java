import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2609_2 {
    static int N;
    static int M;
    static int a;
    static int b;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        a = Math.max(N, M);
        b = Math.min(N, M);

        System.out.println(gcd(a,b));
        System.out.println(lcm(a,b));
    }
    // 최대공약수
    public static int gcd(int a, int b) {
        int answer = 0;
        for (int i = b; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    //최소 공배수
    public static int lcm(int a, int b) {
        return  a * b / gcd(a, b); //공식 : (두 수의 곱) / (최대 공약수)
    }
}