// nPr 서로다른 n 개에서 서로다른 r개를 선택후 나열
// 5p3 = 5*4*3

public class PowerSet2 {
    static int[] p = {1,1,1,1,11};
    static int N = p.length;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) {


        for (int i = 0; i < (1 << N); i++) {
            System.out.printf("%s %d=====>\t", Integer.toBinaryString(i), i);//도대체 i가 뭔데?!
            System.out.println();
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    System.out.println(p[j] + " ");
                }
            }
            System.out.println();
        }
    }
}