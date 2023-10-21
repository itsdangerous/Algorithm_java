package semester1;

public class SubsetTest {

    static int [] p= {1,2,3,4,5};
    static int N=p.length;
    static int R;
    static boolean [] visited;
    static int count;

    public static void main(String[] args) {
        R=3;
        visited=new boolean [N];
        count=0;
        perm(0, 0, 1);
        System.out.println(count);
    }

    static void perm(int cnt, int tot, int mul) {
        if(cnt==N) {
            count++;
            for (int i = 0; i < N; i++) {
                System.out.print(visited[i]+" ");
            }
            System.out.println();
            return ;
        }
        visited[cnt]=true;
        perm(cnt+1, tot+p[cnt], mul*p[cnt]);
        visited[cnt]=false;
        perm(cnt+1, tot, mul);
    }

}