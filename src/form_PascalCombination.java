public class form_PascalCombination {
    public static void main(String[] args) {
        for (int i = 0; i < 21; i++) {
            System.out.printf("20C%d=%d\n", i, nCr(20, i));
        }
        System.out.println("-----------------------");
        for (int i = 0; i < 21; i++) {
            System.out.printf("20C%d=%d\n", i, nCrf(20, i));
        }
    }

    public static int nCr(int n, int r) {
        if (n == r) {
            return 1;
        } else if (r == 0) {
            return 1;
        } else return nCr(n - 1, r - 1) + nCr(n - 1, r);
    }

    public static int nCrf(int n, int r) {
        if (n == r) {
            return 1;
        } else if (r == 0) {
            return 1;
        } else return (n - r + 1) * nCrf(n, r - 1) / r;
    }
}