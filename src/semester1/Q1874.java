package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(i + 1);
        }

        ArrayList<Integer> stack = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();
        boolean check = true;
        for (int i = 0; i < n; i++) {

            int tmp = Integer.parseInt(br.readLine());
            if (arr.contains(tmp)) {
                while(true) {
                    int t = arr.get(0);
                    arr.remove(0);
                    stack.add(t);
                    answer.add("+");
                    if (t == tmp) {
                        break;
                    }
                }
                stack.remove(stack.size()-1);
                answer.add("-");
            } else{
                if(stack.size() == 0) {
                    check = false;
                    System.out.println("No");
                    break;
                }
                if (stack.get(stack.size() - 1) == tmp) {
                    stack.remove(stack.size()-1);
                    answer.add("-");
                }
                else {
                    check = false;
                    System.out.println("NO");
                    break;
                }
            }
        }
        if(check) {
            for (String s : answer) {
                System.out.println(s);
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