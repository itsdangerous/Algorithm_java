// nPr 서로다른 n 개에서 서로다른 r개를 선택후 나열
// 5p3 = 5*4*3

public class PowerSet {
    static int [] p= {1,2,3};
    static int N=p.length;
    static boolean [] visited;
    static int count;

    public static void main(String[] args) {
        visited = new boolean[N];
        count=0;
        //-----------------
        power(0);  // 재귀 -> 자신이 자신호출 ->while -> dfs -> 끝나는 조건 필요
        System.out.println(count);
    }

    // 집합 set 부분집합 멱집합{1,2,3}
    // {}
    // {1} {2} {3}
    // {1,2} {1,3} {2,3}
    // {1,2,3}
    // 2^3 = 3C0+3C1+3C2+3C3

    static void power(int cnt) {
        if(cnt==N) {
            count++;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    System.out.printf("%d ", p[i]);
                }
            }
            return;
        }
        visited[cnt] = true; //선택한게 뭔지 알고 싶을때는 visited 이용.
        power(cnt+1);
        visited[cnt] = false;
        power(cnt+1);
    }
}