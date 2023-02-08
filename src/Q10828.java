import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q10828 {
    static int size = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            String s = br.readLine();

            if (s.charAt(1) == 'u') {

                String[] tmp = s.split(" ");

                if (arr.size() <= size) {
                    arr.add(Integer.parseInt(tmp[1]));
                }
                else {
                    arr.set(size - 1, Integer.parseInt(tmp[1]));
                }
                size++;


            }
            else if (s.equals("pop")) {
                if (size == 0) {
                    System.out.println(-1);
                }
                else{
                    System.out.println(arr.get(size-1));
                    arr.set(size-1, null);
                    size--;
                }

            } else if (s.equals("size")) {
                System.out.println(size);
            } else if (s.equals("empty")) {
                if (size == 0) {
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }
            } else if (s.equals("top")) {
                if (size == 0) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(arr.get(size-1));
                }

            }
        }

    }
}
