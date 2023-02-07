/*
[BOJ-1182] 부분수열의 합
 https://www.acmicpc.net/problem/1182
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1182 {
    static int N, S;
    static int hap, cnt;
    static boolean[] visited = new boolean[20];
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        S = Integer.parseInt(str[1]);

        list = new ArrayList<>();
        String[] s = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(s[i]));
        }

        solve(0, 0);
        System.out.println(cnt);

    }

    static void solve(int depth, int x) {
        if (hap == S) {
            if (depth != 0) {
                cnt++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] || x > i) {
                continue;
            }
            visited[i] = true;
            hap += list.get(i);
            solve(depth + 1, i);
            hap -= list.get(i);
            visited[i] = false;
        }
    }
}