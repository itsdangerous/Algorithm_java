import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class SWEA_COOK {
    static boolean[] visited;
    static int N;
    static int R;
    static int[] nums;
    static int[][] map;
    static int[] p;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            R = N/2;
            visited=new boolean[N];
            nums=new int[R];
            p = new int[N];
            min = 20000;
            for (int j = 0; j < N; j++) {
                String[] str = br.readLine().split(" ");
                for (int k = 0; k < N; k++) {
                    map[j][k] = Integer.parseInt(str[k]);
                }

            }
            for (int j = 0; j < N; j++) {
                p[j] += j + 1;
            }

            combi(0, 0);
            System.out.print("#"+i+ " "+min);

        }
    }
    static void combi(int depth, int start) {

        if(depth==R) {

            int hap_A = 0;
            int hap_B = 0;

//            System.out.println(Arrays.toString(nums)); // 뽑은거

            ArrayList<Integer> b_nums = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
//                    System.out.println(p[i]+" ");
                    b_nums.add(p[i]);
                }
            }

            for (int i = 0; i < nums.length; i++) { // 뽑은걸로 만들기
                for (int j = 0; j < nums.length; j++) {
                    if (i != j) {
                        hap_A += map[nums[i]-1][nums[j]-1];
                    }
                }
            }

            for (int i = 0; i < b_nums.size(); i++) { // 안뽑은걸로 만들기
                for (int j = 0; j < b_nums.size(); j++) {
                    if (i != j) {
                        hap_B += map[b_nums.get(i)-1][b_nums.get(j)-1];
                    }
                }
            }

            if (min > Math.abs(hap_A - hap_B)) {
                min = Math.abs(hap_A - hap_B);
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
