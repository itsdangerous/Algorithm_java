import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// nPr 서로다른 n 개에서 서로다른 r개를 선택후 나열
// 5p3 = 5*4*3

public class Q1759 {
    static int [] p;
    static int N;
    static int R;
    static boolean [] visited;
    static int[] nums;
    static int count;
    static char[] alpha;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        R = Integer.parseInt(str[0]);
        N = Integer.parseInt(str[1]);
        p = new int[N];
        alpha = new char[N];
        visited=new boolean[N];
        nums=new int[R];

        for (int i = 0; i < N; i++) {
            p[i] = i;
        }
        str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            alpha[i] = str[i].charAt(0);
        }
        Arrays.sort(alpha);


        //-----------------
        combi(0, 0);  // 재귀 -> 자신이 자신호출 ->while -> dfs -> 끝나는 조건 필요
    }

    static void combi(int depth, int start) {
        if(depth==R) {

            char[] answer = new char[R];
            for (int i = 0; i < nums.length; i++) {
                answer[i] = alpha[nums[i]];
            }
            int moum = 0;
            int jaum = 0;
            for (char c : answer) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    moum++;
                }
                else {
                    jaum++;
                }
            }

            if (moum >= 1 && jaum >= 2) {
                for (char c : answer) {
                    System.out.print(c);
                }
                System.out.println();
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