import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11286 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) {
                return a - b;
            }
            return Math.abs(a) - Math.abs(b);
        });



        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if (num != 0) {
                q.add(num);
            }
            else {
                if (q.isEmpty()) {
                    sb.append(0).append("\n");
                }
                else {
                    int t = q.poll();
                    sb.append(t).append("\n");
                }
            }

        }
        System.out.println(sb);
    }
}
