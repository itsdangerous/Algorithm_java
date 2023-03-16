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
            // 만약 첫 번째 슬라이싱에서 check가 통과한다면 YES 리턴
            if (check(filter, alpha)) {
                System.out.println("YES");
                continue;
            }
            // 두 번째 슬라이싱부터 수행
            boolean isOk = false;
            for (int j = 1; j < encryptText.length() - size + 1; j++) {
                // 슬라이싱하며 가장 왼쪽의 알파벳 개수를 1 제거하고
                // 새롭게 추가되는 알파벳 개수를 1 늘려줌
                filter[encryptText.charAt(j-1)-'0'-49]--;
                filter[encryptText.charAt(j+size-1)-'0'-49]++;

                // check 통과하면 boolean을 통해 통과했다고 알려준 후 빠져나오고 YES 리턴
                if(check(filter, alpha)) {
                    isOk = true;
                    break;
                }
            }
            if(isOk) System.out.println("YES");
            else System.out.println("NO");

        }

    }

    private static boolean check(int[] filter, int[] alpha) { // 2개의 알파벳 배열에 대해 각 알파벳의 개수가 일치하는지 확인하는 함수
        for (int i = 0; i < 26; i++) {
            if (filter[i] != alpha[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] makeArr(String planeText) { // 입력된 평문에 대해 알파벳 배열에 카운팅하는 함수
        int[] arr = new int[26];
        for (int i = 0; i < planeText.length(); i++) {
            char c = planeText.charAt(i);
            int index = c-'0'-49;
            arr[index]++;
        }
        return arr;
    }
}
