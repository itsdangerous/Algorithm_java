import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_pool {
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {

            // 이용권 입력
            int[] price = new int[5];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 4; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            // 12개월 이용 계획
            int[] plan = new int[13];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            result = price[4];
            dfs(plan, 1, 0, price);

            System.out.printf("#%d %d\n",t, result);
        }
    }

    static void dfs(int[] arr, int month, int total, int[] price) {
        if (month > 12) {
            if (result > total) {
                result = total;
            }
            return;
        }

        dfs(arr, month + 1, total+arr[month]*price[1], price);
        dfs(arr, month + 1, total+price[2], price);
        dfs(arr, month + 3, total+price[3], price);
    }
}


