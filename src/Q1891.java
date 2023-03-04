import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1891 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        String str = st.nextToken();


        System.out.println(Arrays.toString(findPoint(str)));

    }
    public static int[] findPoint(String str) {
        int len = str.length();
        int r = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) - '0' == 1 || str.charAt(i) - '0' == 2) {
                r += Math.pow(2, len - i) / 2 - 1;
            }
            if (str.charAt(i) - '0' == 3 || str.charAt(i) - '0' == 4) {
                r += Math.pow(2, len - i) / 2;
            }
        }

        int c = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) - '0' == 2 || str.charAt(i) - '0' == 3) {
                c += Math.pow(2, len - i) / 2 - 1;
            }
            if (str.charAt(i) - '0' == 1 || str.charAt(i) - '0' == 4) {
                c += Math.pow(2, len - i) / 2;
            }
        }
        return new int[]{r, c};
    }
}
