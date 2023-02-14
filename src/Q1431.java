import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1431 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        // 람다식 사용하여 sort
        Arrays.sort(arr, (e1, e2) -> {
            if (e1.length() != e2.length()) { // 1. 두 문자의 길이가 같니~?
                return e1.length() - e2.length();
            } else { // 다르니~?
                int hap_a = 0; // 숫자 카운팅 변수들
                int hap_b = 0;
                for (int i = 0; i < e1.length(); i++) {
                    if (Character.getNumericValue(e1.charAt(i)) == e1.charAt(i) - '0') { // 숫자라면~
                        hap_a += e1.charAt(i) - '0'; //숫자++!!
                    }
                }
                for (int i = 0; i < e2.length(); i++) {
                    if (Character.getNumericValue(e2.charAt(i)) == e2.charAt(i) - '0') {
                        hap_b += e2.charAt(i) - '0';
                    }
                }
                if (hap_a != hap_b) { // 숫자로 비교 할 수 있니~?
                    return hap_a - hap_b;
                }
                return e1.compareTo(e2); // 안되면 사전순으로 비교하자. Stirng.compareTo() 메소드는 두 문자열을 사전순으로 비교함.

            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }


    }
}