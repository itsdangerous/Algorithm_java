import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q14915 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" "); // 입력받은 문자열을 공백 기준으로 스트링 배열에 저장

        int n = Integer.parseInt(str[1]);
        int m = Integer.parseInt(str[0]);

        converse(n, m);

    }

    public static void converse(int n, int m) { // 10진수 m을 n진수로 변환
        List<Integer> nums = new ArrayList<>();

        int tar = m;
        while (true) {
            if (tar < n) {
                nums.add(tar); // 만약 나눌 값이 n보다 작다면 더이상 나눌 수 없으니 배열의 꼬리에 저장하고 반복문 종료
                break;
            }
            else {
                nums.add(tar % n); // 10진수 m을 n으로 계속 나눈 나머지를 배열의 꼬리에 계속 저장 후, 몫 값으로 순회
                tar /= n;
                if (tar < n) {
                    nums.add(tar); // 만약 나눌 값이 n보다 작다면 더이상 나눌 수 없으니 배열의 고리에 저장하고 반복문 종료
                    break;
                }
            }
        }
        for (int i = nums.size() - 1; i >= 0; i--) { // print format으로 16진수 출력
            System.out.printf("%X", nums.get(i));
        }
    }
}
