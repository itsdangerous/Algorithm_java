import java.util.Arrays;
public class NextCombination {
    static int[] p = {0,0,0,1,1,1}; // 6C2;
    static int[] n = {1,2,3,4,5,6}; // 65 4/6;
    static int count;
    static int N= p.length;

    public static void main(String[] args) {

        do {
            count++;
            for (int i = 0; i < N; i++) {
                if (p[i] ==1) System.out.println(n[i]+" ");
            }
            System.out.println();
            System.out.println(Arrays.toString(p));
//            System.out.println(Arrays.toString(p)); // copy by reference;
        } while (np(N - 1));
        System.out.println(count);

    }

    static boolean np(int size) {
        int i = size;
        while(i > 0 && p[i-1] >= p[i]) i--;
        if (i==0) return false; // 5 4 3 2 1
        int j = size;
        while(p[i-1] >= p[j]) j--; // 오른쪽부터 찾아서 첫 번째 찾은 수랑 바꿔
        int temp = p[i-1];
        p[i-1] = p[j];
        p[j] = temp;
        int k = size;
        while (i < k) {
            temp = p[i];
            p[i] = p[k];
            p[k] = temp;
            i++;
            k--;
        }
        return true;
    }
}
