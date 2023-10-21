package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10773 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        int index = -1;
        int hap = 0;
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                arr[++index] = num;
                hap += num;
            }
            else {
                hap -= arr[index];
                arr[index] = 0;
                index--;
            }
        }
//        System.out.println(Arrays.toString(arr));
        System.out.println(hap);
    }

}
