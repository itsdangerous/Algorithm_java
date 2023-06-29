import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q1744 {

    static int N;
    static int[] arr;
    static int hapPlus, hapMinus;

    static ArrayList<Integer> plus, minus, zero;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        plus = new ArrayList<>();
        minus = new ArrayList<>();
        zero = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (arr[i] > 0) plus.add(arr[i]);
            else if (arr[i] < 0) minus.add(arr[i]);
            else zero.add(arr[i]);
        }

        solve();
    }


    private static void solve() {
        plus.sort(Collections.reverseOrder());
        Collections.sort(minus);

        makeHapPlus();
        makeHapMinus();

        System.out.println(hapPlus + hapMinus);
    }

    private static void makeHapMinus() {

        int i = 0;

        while (i < minus.size() - 1) {
            hapMinus += minus.get(i) * minus.get(i + 1);
            i += 2;
        }

        if (i == minus.size() - 1) {
            if (zero.size() == 0) {
                hapMinus += minus.get(i);
            }
        }
    }

    static void makeHapPlus() {
        int i = 0;
        int size = plus.size() - 1;
        while (i < plus.size() - 1) {
            if (plus.get(i) * plus.get(i + 1) > plus.get(i) + plus.get(i + 1)) {
                hapPlus += plus.get(i) * plus.get(i + 1);
                i += 2;
            } else {
                hapPlus += plus.get(i);
                i += 1;
            }
        }

        if (i == size) {
            hapPlus += plus.get(i);
        }
    }

}
