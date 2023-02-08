import java.util.Arrays;

// nPr 서로다른 n 개에서 서로다른 r개를 선택후 나열
// 5p3 = 5*4*3

public class Combination {
    static int [] p= {1,2,3,4,5};
    static int N=p.length;
    static int R;
    static boolean [] visited;
    static int[] nums;
    static int count;

    public static void main(String[] args) {
        R=3;
        visited=new boolean[N];
        nums=new int[R];
        count=0;
        //-----------------
        combi(0, 0);  // 재귀 -> 자신이 자신호출 ->while -> dfs -> 끝나는 조건 필요
        System.out.println(count);
    }
    // 123 124 125 ...
    static void combi(int depth, int start) {
        if(depth==R) {
            System.out.println(Arrays.toString(nums));
            count++;
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    System.out.println(p[i]+" ");
                }
            }
            return;
        }
        for (int i = start; i < N; i++) {
            if(visited[i]) continue;
            // 방문한적 없다. 12 3 12 4 12 5
            visited[i]=true;
            nums[depth]=p[i];
            combi(depth+1, i+1);
//            nums[depth]=0; // 날려도 됨
            visited[i]=false;
        }
    }

}