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
        selected = new int[D+1]; // 각 번호의 초밥의 개수를 카운팅 할 배열

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        select(); // 첫 번째 경우의 수
        result = count; // 첫 번째 경우의 수 counting

        // 인덱스를 1씩 증가시키며 모든 인덱스에 대하여 벨트를 조사.
        // 인덱스를 증가시킬 때마다 가장 왼쪽 초밥 번호의 개수를 줄여주고
        // 새로 추가될 초밥 번호의 개수를 추가하여 max값 찾기

        for (int i = 0; i < N; i++) {
            selected[arr[i]]--;
            if (selected[arr[i]] == 0 && arr[i] != C) count--;
            selected[arr[(K + i) % N]]++;
            if (selected[arr[(K + i) % N]] == 1 && arr[(K + i) % N] != C) count++;

            result = Math.max(result, count);
        }

        System.out.println(result);
    }

    // 제일 처음 벨트의 위치부터 시작하여 K개 + 쿠폰을 set에 저장하고, 그때의 count를 기준으로 슬라이싱 하여 max값을 찾음
    // selected 배열에 초밥 번호의 개수 카운팅하여 저장.
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
