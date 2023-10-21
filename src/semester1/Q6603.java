package semester1;/*
[BOJ-6603] 로또
 https://www.acmicpc.net/problem/6603
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q6603{
    static int R = 6;
    static boolean[] visited;
    static int[] nums = new int[R];
    static int count;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {

            String[] s = br.readLine().split(" ");
            if (s[0].equals("0")) return;

            N = Integer.parseInt(s[0]);
            visited = new boolean[N];

            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 1; i < s.length; i++) {
                list.add(Integer.parseInt(s[i]));
            }

            combi(0, 0, list);  // 재귀 -> 자신이 자신호출 ->while -> dfs -> 끝나는 조건 필요
            System.out.println();
        }


    }

    static void combi(int depth, int start, ArrayList<Integer> list) {
        if(depth==R) {
            for (int i = 0; i < N; i++) {
                if(visited[i]) {
                    System.out.print(list.get(i)+" ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i]=true;
            nums[depth]=list.get(i);
            combi(depth+1, i+1, list);
            nums[depth]=0;
            visited[i]=false;
        }
    }

}
