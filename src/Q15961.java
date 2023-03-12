import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15961 {
    static int N, D, K, C;
    static int[] arr;
    static int[] selected;
    static int count = 0;
    static int result;
    static PriorityQueue<HashSet<ArrayList<Integer>>> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        selected = new int[D+1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        select();
        result = count;
        for (int i = 0; i < N; i++) {
            selected[arr[i]]--;
            if (selected[arr[i]] == 0 && arr[i] != C) count--;
            selected[arr[(K + i) % N]]++;
            if (selected[arr[(K + i) % N]] == 1 && arr[(K + i) % N] != C) count++;

            result = Math.max(result, count);
        }

        System.out.println(result);
    }

    public static void select() {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < K; i++) {
            selected[arr[i]]++;
        }

        for (int i = 0; i < K; i++) {
            if (selected[arr[i]] >=1) set.add(arr[i]);
        }
        set.add(C);
        count = set.size();
    }

}
