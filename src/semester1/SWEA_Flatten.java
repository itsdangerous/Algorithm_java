package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_Flatten {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 10; i++) {
            int cnt =  Integer.parseInt(br.readLine());
            int[] boxes = new int[100];
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < 100; j++) {
                boxes[j] = Integer.parseInt(str[j]);
            }
            Arrays.sort(boxes);
            int point_left = 0;
            int point_right = 100-1;
            while (cnt > 0) {
                boxes[point_right]--;
                boxes[point_left]++;
                Arrays.sort(boxes);
                cnt--;
            }
            System.out.printf("#%d %d\n", i, (boxes[99] - boxes[0]));
        }
    }
}
