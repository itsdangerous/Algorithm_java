import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class form_DupliCombination {

    static int[] p, nums;
    static int N, R, count;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        R = 6;
        p = new int[N];
        nums = new int[R];
        visited = new boolean[N];
        count = 0;
        for (int i = 0; i < N; i++) {
            p[i] = i+1;
        }
        perm(0, 0);
        System.out.println(count);

    }

    static void perm(int cnt, int start) {
        if (cnt == R) {
            count++;
            //로직
            printArr(nums);
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            nums[cnt] = p[i];
            perm(cnt + 1, i);
            nums[cnt] = 0;
            visited[i] = false;
        }
    }

    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
