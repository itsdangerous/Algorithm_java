/*
[BOJ-1212] 8진수 2진수
 https://www.acmicpc.net/problem/1212
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1212 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        if (s.equals("0")) { // 입력 값이 0이면 0찍고 리턴
            System.out.println(s);
            return;
        }

        for (int i = 0; i < s.length(); i++) { // 입력받은 문자열을 character 하나씩 읽어서 321코드로
            solve(s.charAt(i));
        }

        // 구한 2진수 문자열의 첫번째와 두번째 인덱스가 0일 경우를 고려하여 문자열 출력
        if (sb.charAt(0) == '0') {
            if (sb.charAt(1) == '0') {
                System.out.println(sb.substring(2));
            }
            else {
                System.out.println(sb.substring(1));
            }
        }
        else {
            System.out.println(sb);
        }

    }

    public static void solve(char s) {   // 8진수의 한 자리마다 321코드로 2진수 변환
        int n = s - '0';                 // 문자열 s를 정수로 반환
        int k = 8;                       // 2진수 변환시 2^2 자리값부터 2^0 자리값을 계산하기 위한 초기화
        for (int i = 0; i < 3; i++) {
            k = k >> 1;                  // 오른쪽으로 1비트 이동
            sb.append(n / k);            // static 변수 sb에 321코드 저장
            n = n % k;
        }
    }
}