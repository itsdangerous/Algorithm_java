/*
[BOJ-15654] N과 M (5)
 https://www.acmicpc.net/problem/15654
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Q15654 {
    static int N, M;
    static boolean[] visited;
    static int[] nums;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        visited = new boolean[N];
        answer = new int[N];
        nums = new int[M];

        ArrayList<Integer> list = new ArrayList<>();

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(str[i]));
        }

        Collections.sort(list);

        solve(0, list);
        System.out.print(sb.toString());
    }
    static void solve(int depth, ArrayList<Integer> list) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {

                visited[i] = true;
                answer[depth] = list.get(i);
                solve(depth + 1, list);
                visited[i] = false;

            }
        }
    }

}
