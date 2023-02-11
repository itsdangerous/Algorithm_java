import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q10816_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> cards = new HashMap<>();

        int N = Integer.parseInt(br.readLine());



        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            try {
                cards.put(num, cards.get(num) + 1);
            } catch (Exception e) {
                cards.put(num, 1);
            }
        }

//        for (int i = 0; i < M; i++) {
//            System.out.print(cards.getOrDefault(str[i], 0) + " "); // 사전에 카드 없으면 0 찍게~
//        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (cards.get(num) == null) {
               sb.append(0 + " ");
            } else {
                sb.append(cards.get(num) + " ");
            }
        }
        System.out.println(sb);
    }
}