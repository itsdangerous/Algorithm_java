/*
[BOJ-10974] 모든 순열
 https://www.acmicpc.net/problem/10974
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q10974 {
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        solve(list);
    }

    static void solve(List list) {
        if (list.size() == N) {
            for (Object o : list) {
                System.out.print(o + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!list.contains(i)) {
                list.add(i);
                solve(list);
                list.remove(list.size() - 1);
            }
        }
    }
}