import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(i + 1);
        }
        System.out.println(arr.contains(5));
        ArrayList<Integer> stack = new ArrayList<>();

        System.out.println(stack.size());

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());

            if (stack.size() == 0) {

            }

        }
    }
}

//
//arr = [1 2 3 4 5 6 7 8]
//
//        input 4
//        arr = [5 6 7 8]
//        stack = [1 2 3 4]
//        return 4
//        stack [1 2 3]
//
//
//        input 3
//        return 3
//        stack [1 2]
//
//        input 6
//        arr = [7 8]
//        stack = [1 2 5 6]
//        return 6
//        stack = [1 2 5]
//
//        input 8
//        arr = []
//        stack = [1 2 5 7 8]
//        return 8
//        stack = [1 2 5 7]
//
//        input 7
//        stack = [1 2 5]
//
//        input 5 ....
//
//
