public class Pivonacci_recursion {
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.printf("pivo(%d) = %d\n", i, pivo(i));
        }

    }
    public static int pivo(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        else {
            return pivo(n-1) +pivo(n-2);
        }
    }
}
