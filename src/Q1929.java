/*
[BOJ-1929] 소수 구하기
 https://www.acmicpc.net/problem/1929
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Q1929 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[1]);
        int m = Integer.parseInt(str[0]);

        for (int i = m; i <= n; i++) {
            if (IsPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean IsPrime(int n) { // 소수 판별

        if (n == 1) return false;

        for (int i = 2; i < (int)(Math.sqrt(n)+1); i++) { // 약수를 구하는데, 제곱수일 경우 까지 검사
            if (n % i == 0) return false;
        }
        return true;
    }
}