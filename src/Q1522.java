import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int size = str.length();

        int cnt = 0;
        for (int i = 0; i < size; i++) {
            if (str.charAt(i) == 'a') {
                cnt++;
            }
        }

        int min = size;
        for (int i = 0; i < size; i++) {
            int cntB = 0;
            for (int j = i; j < i+cnt; j++) {
                if(str.charAt(j%size) == 'b') cntB++;
            }

            min = Math.min(min, cntB);
        }

        System.out.println(min);

    }
}