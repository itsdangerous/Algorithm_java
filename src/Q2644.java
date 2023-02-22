import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Q2644 {
    private static int N, M, a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            list.get(parent).add(child);
        }

        solve(list);

    }

    static void solve(ArrayList<ArrayList<Integer>> list) {
        ArrayList<Integer> list_A = new ArrayList<>();
        ArrayList<Integer> list_B = new ArrayList<>();
        list_A.add(a);
        list_B.add(b);

        //a 부모 리스트
        int A = a;
        int count = 1;
        while (count <= N) {
            if (list.get(count).contains(A)) {
                list_A.add(count);
                A = count;
                count = 1;
                continue;
            }
            count++;
        }
        //b 부모 리스트
        int B = b;
        count = 1;
        while (count <= N) {
            if (list.get(count).contains(B)) {
                list_B.add(count);
                B = count;
                count = 1;
                continue;
            }
            count++;
        }

        System.out.println(calc(list_A, list_B));
    }

    static int calc(ArrayList<Integer> a, ArrayList<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                if (Objects.equals(a.get(i), b.get(j))) {
                    return i + j;
                }
            }
        }
        return -1;
    }



}