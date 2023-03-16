import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15565 {
    static int N, K;
    static ArrayList<Integer> list;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        //라이언의 인덱스를 받을 list
        list = new ArrayList<>();

        //list 입력받기
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n == 1) {
                list.add(i);
            }
        }
        solve();
    }
    public static void solve() {
        int size = list.size();
        if (size < K) { // 라이언의 개수가 문제에서 주어진 K개보다 작다면 -1 리턴
            System.out.println(-1);
            return;
        }
        int min = Integer.MAX_VALUE;
        int p = 0;
        //슬라이싱
        while (p + K - 1 < size) { // 라이언의 인덱스가 저장된 리스트를 슬라이싱하여 탐색
            // [오른쪽 끝 인덱스] - [왼쪽 끝 인덱스]의 값 중 최솟값을 찾는 로직
            int point1 = list.get(p);
            int point2 = list.get(p + K - 1);
            min = Math.min(min, point2 - point1 + 1);
            p++;
        }
        System.out.println(min);
    }
    
}
