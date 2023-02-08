import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            arr.add(Integer.parseInt(s[i]));
        }

        int[] answer = new int[T];

        for (int i = 0; i < T; i++) {
            int k =0;
            int check = 0;
            while (k < T) {
                if (answer[k] == 0) {
                    if (arr.get(i) == check) {
                        answer[k] = i+1;
                        break;
                    }
                    check++;
                }
                k++;
            }
        }
        for (int a :
                answer) {
            System.out.print(a+" ");
        }
    }
}

