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
            alpha = makeArr(planText);

            int[] filter = new int[26];
            for (int k = 0; k < size; k++) {
                filter[encryptText.charAt(k)-'0'-49]++;
            }
            if (check(filter, alpha)) {
                System.out.println("YES");
                continue;
            }
            boolean isOk = false;
            for (int j = 1; j < encryptText.length() - size + 1; j++) {
                filter[encryptText.charAt(j-1)-'0'-49]--;
                filter[encryptText.charAt(j+size-1)-'0'-49]++;
                if(check(filter, alpha)) {
                    isOk = true;
                    break;
                }
            }
            if(isOk) System.out.println("YES");
            else System.out.println("NO");

        }

    }

    private static boolean check(int[] filter, int[] alpha) {
        for (int i = 0; i < 26; i++) {
            if (filter[i] != alpha[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] makeArr(String planeText) {
        int[] arr = new int[26];
        for (int i = 0; i < planeText.length(); i++) {
            char c = planeText.charAt(i);
            int index = c-'0'-49;
            arr[index]++;
        }
        return arr;
    }
}
