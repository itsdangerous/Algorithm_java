import java.util.*;

public class Q2253 {
    static int N, M;
    static ArrayList<Integer>[] check;
    static Set<Integer> smallRock;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        check = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            check[i] = new ArrayList<Integer>();
        }

        smallRock = new HashSet<Integer>();
        for (int i = 0; i < M; i++) {
            int small = sc.nextInt();
            smallRock.add(small);
        }

        int answer = solution(N, check, smallRock);

        System.out.println(answer);
    }

    public static int solution(int N, ArrayList<Integer>[] check, Set<Integer> smallRock) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{1, 0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int location = cur[0];
            int jump = cur[1];
            int n = cur[2];

            for (int x : new int[]{jump + 1, jump, jump - 1}) {
                if (x > 0) {
                    int nextLocation = location + x;
                    if (nextLocation == N) {
                        return n + 1;
                    }
                    if (nextLocation < N && !smallRock.contains(nextLocation) && !check[nextLocation].contains(x)) {
                        check[nextLocation].add(x);
                        queue.offer(new int[]{nextLocation, x, n + 1});
                    }
                }
            }
        }
        return -1;
    }
}
