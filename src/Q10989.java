import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Q10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> arr = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr.merge(num, 1, Integer::sum);// 같은 key일 경우 value를 덮어 쓰는 API
//            if (arr.get(num) != null) {
//                arr.put(num, arr.get(num) + 1);
//            }
//            else {
//                arr.put(num, 1);
//            }
        }

        for (int i = 0; i < 10001; i++) {
            if (arr.get(i) != null) {
                sb.append((i + "\n").repeat(Math.max(0, arr.get(i)))); // repeat메서드를 이용하여 0부터 arr.get(i)만큼 돌며 sb에 출력할 내용 추가

//            for (int j = 0; j < arr.get(i); j++) {
//                sb.append(i + "\n");
//            }
            }
        }
        System.out.print(sb);
    }
}
