package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q10845 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().split(" ");

            if (s[0].equals("push")) {
                arr.add(Integer.parseInt(s[1]));
            } else if (s[0].equals("front")) {
                if (arr.size() == 0) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(arr.get(0));
                }
            } else if (s[0].equals("back")) {
                if (arr.size() == 0) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(arr.get(arr.size() - 1));
                }
            } else if (s[0].equals("pop")) {
                if (arr.size() == 0) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(arr.get(0));
                    arr.remove(0);
                }
            } else if (s[0].equals("size")) {
                System.out.println(arr.size());
            } else if (s[0].equals("empty")) {
                if (arr.size() == 0) {
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }
            }

        }
    }
}
