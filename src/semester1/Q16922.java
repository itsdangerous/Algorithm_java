package semester1;/*
[BOJ-16922] 로마 숫자 만들기
 https://www.acmicpc.net/problem/16922
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Q16922 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        solve(n);
    }

    public static void solve(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {                       // i를 n개 까지 뽑을게요
            for (int j = 0; j < n - i + 1; j++) {               // j를 n-i개 까지 뽑을게요
                for (int k = 0; k < n - j - i + 1; k++) {       // k를 n-j-i개 까지 뽑을게요
                    int l = n - k - j - i;                      // l은 n-k-j-i개
                    arr.add(i + j * 5 + k * 10 + l * 50);       // 개수만큼 가중치 곱한 후 리스트에 저장
                }
            }
        }
        Set<Integer> answer = new HashSet<>(arr);               // 리스트를 set으로 변환
        System.out.println(answer.size());

    }
}
