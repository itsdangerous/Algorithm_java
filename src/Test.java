import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[][] arr = new int[3][3];

        for (int i = 0; i < 3; i++) {
            arr[i] = new int[]{-1, -1};
        }

        arr[1][0] = 1;

    }
}