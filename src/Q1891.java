import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1891 {
    static int len;
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        len = Integer.parseInt(st.nextToken());
        str = st.nextToken();
        double size = Math.pow(2,len);

        st = new StringTokenizer(br.readLine());
        double dc = Double.parseDouble(st.nextToken());
        double dr = Double.parseDouble(st.nextToken());

        double[] t = strToPoint(str, 0, 0, 0, size);
        double r = t[0];
        double c = t[1];
        if(!check(r-dr, c+dc, size)) {
            System.out.println(-1);
            return;
        }
        String newStr = pointToStr(0, 0, r-dr, c+dc, size); //answer

        System.out.println(newStr);
    }

    // String -> (r,c)
    public static double[] strToPoint(String str, int index, double r, double c, double size) {
        if (size == 1) {
            return new double[]{r, c};
        }

        if (str.charAt(index) == '1') {
            return strToPoint(str, index + 1, r, c + size / 2, size / 2);
        }
        if (str.charAt(index) == '2') {
            return strToPoint(str, index + 1, r, c, size / 2);
        }
        if (str.charAt(index) == '3') {
            return strToPoint(str, index + 1, r + size / 2, c, size / 2);
        }
        if (str.charAt(index) == '4') {
            return strToPoint(str, index + 1, r + size / 2, c + size / 2, size / 2);
        }

        return new double[]{0, 0};
    }

    // (r,c) -> String
    public static String pointToStr(double nr, double nc, double r, double c, double size) {
        if (size == 1) {
            return "";
        }

        if (r < nr + size / 2 && c >= nc + size / 2) {
            return "1" + pointToStr(nr, nc + size / 2, r, c, size / 2);
        }
        if (r < nr + size / 2 && c < nc + size / 2) {
            return "2" + pointToStr(nr, nc, r, c, size / 2);
        }
        if (r >= nr + size / 2 && c < nc + size / 2) {
            return "3" + pointToStr(nr + size / 2, nc, r, c, size / 2);
        }
        if (r >= nr + size / 2 && c >= nc + size / 2) {
            return "4" + pointToStr(nr + size / 2, nc + size / 2, r, c, size / 2);
        }

        return "";
    }

    public static boolean check(double r, double c,double size) {
        return 0 <= r && r < size && 0 <= c && c < size;
    }
}
