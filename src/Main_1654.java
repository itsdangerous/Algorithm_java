import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int K = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);


        ArrayList<Long> arr = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            long line = Long.parseLong(br.readLine());
            arr.add(line);
        }

        Collections.sort(arr, Collections.reverseOrder());
        long max = arr.get(0);
        long start = 1;

        while(start <= max) {
            long mid = (start + max) / 2;
            long hap = 0;
            for (int i = 0; i < K; i++) {
                hap += arr.get(i) / mid;
            }
            if (hap >= N) {
                start = mid + 1;
            }
            else {
                max = mid -1;
            }
        }
        System.out.println(max);
    }
}

