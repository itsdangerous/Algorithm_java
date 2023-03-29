import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Q4195 {
    static int[] parent;
    static int[] rank;
    static HashMap<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int T = 0; T < TC; T++) {
            int F = Integer.parseInt(br.readLine());
            parent = new int[2 * F];
            rank = new int[2 * F];
            makeSet(F);
            map = new HashMap<>();

            // parent 배열의 index로 접근하기 위해 Map을 사용
            // 문자열을 입력 받으면서 새로운 문자를 받을때마다 index를 늘려줌
            // 입력받는 2개의 문자열에 대해 map에 접근해서 index를 가져오고
            // 그 인덱스로 union-find 수행
            int index = 0;
            for (int i = 0; i < F; i++) {
                String[] strArr = br.readLine().split(" ");
                //map에 String추가 로직
                for (int j = 0; j < 2; j++) {
                    if (!map.containsKey(strArr[j])) { // Map의 containsKey의 시간복잡도는 O(1)
                        map.put(strArr[j], index);
                        index++;
                    }
                }

                //왼쪽 문자열에 오른쪽 문자열 union
                union(map.get(strArr[0]), map.get(strArr[1]));

                // 왼쪽 문자열이나 오른쪽 문자열에 대해 수행해도 상관없음
                // 문자열의 root노드의 rank를 출력
                System.out.println(rank[find(map.get(strArr[0]))]);

            }

        }
    }

    private static void makeSet(int num) {
        for (int i = 0; i < 2*num; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) { // 만약 이미 연결되어 있다면 union하지 말아요
            return false;
        }

        if (rank[px] >= rank[py]) {
            parent[py] = px;
            rank[px] += rank[py];
        } else if(rank[px] < rank[py]) {
            parent[px] = py;
            rank[py] += rank[px];
        }

        return true;
    }
    
}
