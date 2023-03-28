import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class form_PascalTriangle_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 21;
        int[][] ncr = new int[n][n];
        for (int m = 1; m < n; m++) {
            ncr[m][0] = 1;
            ncr[m][m] = 1;
            for (int r = 1; r < m; r++) {
                ncr[m][r] = ncr[m - 1][r - 1] + ncr[m - 1][r];
            }
        }

        for (int m = 1; m < n; m++) {
            for (int r = 0; r < m + 1; r++) {
                System.out.print(ncr[m][r]+" ");
            }
            System.out.println();
        }

    }
}