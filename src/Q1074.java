import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1074 {
    static int[][] map;
    static int count = 0;
    static int rr;
    static int cc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        rr = Integer.parseInt(s[1]);
        cc = Integer.parseInt(s[2]);

        z(0, 0, 1<<n);
        System.out.println(count);

    }
    static void z(int r, int c, int width) {
        if (rr == r && cc == c) {
            System.out.println(count);
            return;
        }

        if (r >= rr && r < rr + width && c >= cc && c < cc + width) {
            int w = width/2;
            z(rr, cc, w);
            z(rr, cc + w, w);
            z(rr + w, cc, w);
            z(rr + w, cc + w, w);
        } else {
            count += cc * width + r;
        }

    }

}
