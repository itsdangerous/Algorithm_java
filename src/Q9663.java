import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9663 {
    static int n;
    static int[] arr;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        cnt = 0;

        queen(0);
        System.out.println(cnt);
    }


    static void queen(int x) {
        if (x == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[x] = i;
            if (check(x)) {
                queen(x + 1);
            }
        }
    }
    static boolean check(int p) {
        for (int i = 0; i < p; i++) {
            if (arr[p] == arr[i] || Math.abs(arr[p] - arr[i]) == Math.abs(p - i)) {
                return false;
            }
        }
        return true;
    }





}
