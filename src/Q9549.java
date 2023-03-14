import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9549 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String encryptText = br.readLine();
            String planText = br.readLine();
            int size = planText.length();
            int[] alpha = new int[26]; // 0번째 인덱스부터 a,b,c,...z
            for (int j = 0; j < size; j++) {
                char key = planText.charAt(j);
                alpha[key-'0'-49]++;
            }
            boolean isOK = false;
            for (int j = 0; j <= encryptText.length() - size; j++) {
                int[] filter = new int[26];
                System.arraycopy(alpha, 0, filter, 0, alpha.length);
                String lookStr = encryptText.substring(j, j + size);

                if (Search(lookStr, filter)) {
                    isOK = true;
                    break;
                }
            }

            if (isOK) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }

        }

    }

    public static boolean Search(String str, int[] filter) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = c-'0'-49;
            if(filter[index] == 0) return false;
            if(filter)
        }
        return true;
    }
}
