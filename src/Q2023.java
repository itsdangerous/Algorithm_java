import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 완탐 - 순조부
// nPr - n!/(n-r)! 6p3=6*5*3
// 재귀 - call stack end condition - dfs(끝가지간다: 유사식) - 분할정복/백트랙킹
// 백트랙킹 - 데이터 + prunning
//          dfs
//          최기화
// 분할정복 - 10, 11, Z, 색종이
public class Q2023 {
    static int[] p = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int N = p.length;
    static int R;
    static int count;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        R = Integer.parseInt(br.readLine());

        nums = new int[R];
        count = 0;
        piperm(0);
    }

    static void piperm(int cnt) {
        if (cnt == R) {
            //로직
            int t = 0;
            for (int i : nums) {
                t = t * 10 + i;
                if (!isPrime(t)) {
                    return;
                }
            }
            System.out.println(t);
            return;
        }
        for (int i = 0; i < N; i++) {
            //if(visited[i])continue;
//            visited[i]=true;
            nums[cnt] = p[i];
            piperm(cnt + 1);
//            nums[cnt]=0;
//            visited[i]=false;
        }
    }

    public static boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}