import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(i + 1);
        }

        int size = N;
        int index = 0;
        System.out.print("<");
        while (size > 1) {
            index = (index + K - 1) % size;
            System.out.print(arr.get(index) + ", ");
            arr.remove(index);
            size--;
        }
        System.out.println(arr.get(0)+">");
    }
}