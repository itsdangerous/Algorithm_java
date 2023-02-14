import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1920 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long N = Integer.parseInt(br.readLine());
        String [] A = br.readLine().split(" ");
        Set<String> set = new HashSet<>(Arrays.asList(A));

        long M = Integer.parseInt(br.readLine());
        String [] B = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            if (set.contains(B[i])) {
                sb.append(1 + "\n");
            }
            else {
                sb.append(0 + "\n");
            }
        }
        System.out.print(sb);

    }
}