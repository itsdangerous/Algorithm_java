/*
[BOJ-22864] 피로도
 https://www.acmicpc.net/problem/22864
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q22864 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 피로도 일률 -피로도   피로도 맥시멈
        String[] s = br.readLine().split(" ");
        int A = Integer.parseInt(s[0]); // 일당 피로도
        int B = Integer.parseInt(s[1]); // 일률
        int C = Integer.parseInt(s[2]); // 시간당 -피로도
        int M = Integer.parseInt(s[3]); // 최대 피로도

        int a = 0; // 현재 피로도
        int answer = 0; // 일의 양
        int time = 0; //시간
        if (A > M) {
            System.out.println(answer);
        } else {
            while (time < 24) {

                if (a + A > M) {
                    time++;
                    a -= C;
                    if (a < 0) a = 0;
                } else {
                    answer += B;
                    time++;
                    a += A;
                }

            }
            System.out.println(answer);
        }
    }
}  