import java.util.Arrays;

public class PowerSet {

    static int [] p= {1,2,3,4,5};
    static int N=p.length;
    static int R;
    static int[] nums;
    static boolean [] visited;
    static int count;

    public static void main(String[] args) {
        R=3;
        nums=new int[R];
        visited=new boolean [N];
        count=0;
        perm(0);
        System.out.println(count);
    }

    static void perm(int cnt) {
        if(cnt==R) {
            System.out.println(Arrays.toString(nums));
            count++;
            return ;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i]=true;
            nums[cnt]=p[i];
            perm(cnt+1);
            nums[cnt]=0;
            visited[i]=false;
        }
    }

}