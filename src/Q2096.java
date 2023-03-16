<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2096 {
    static int N;
    static int[] maxArr, minArr, prevMaxArr, prevMinArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        maxArr = new int[3];
        minArr = new int[3];
        prevMaxArr = new int[3];
        prevMinArr = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < 3; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            maxArr[i] = tmp;
            minArr[i] = tmp;
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                prevMaxArr[j] = maxArr[j];
                prevMinArr[j] = minArr[j];
                int tmp = Integer.parseInt(st.nextToken());
                maxArr[j] = tmp;
                minArr[j] = tmp;
            }
            updateMaxArr(prevMaxArr);
            updateMinArr(prevMinArr);
        }

        int max = get3Max(maxArr[0], maxArr[1], maxArr[2]);
        int min = get3Min(minArr[0], minArr[1], minArr[2]);
        System.out.println(max+" "+min);
    }

    private static void updateMaxArr(int[] arr) {
        maxArr[0] += Math.max(arr[0], arr[1]);
        maxArr[1] += get3Max(arr[0], arr[1], arr[2]);
        maxArr[2] += Math.max(arr[1], arr[2]);
    }
    private static void updateMinArr(int[] arr) {
        minArr[0] += Math.min(arr[0], arr[1]);
        minArr[1] += get3Min(arr[0], arr[1], arr[2]);
        minArr[2] += Math.min(arr[1], arr[2]);
    }

    private static int get3Max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private static int get3Min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

}
=======
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2096 {
    static int N;
    static int[] maxArr, minArr;
    static int[] prevMaxArr;
    static int[] prevMinArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        maxArr = new int[3];
        minArr = new int[3];
        prevMaxArr = new int[3];
        prevMinArr = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            maxArr[i] = tmp;
            minArr[i] = tmp;
        }

        if (N == 1) {
            int max = get3Max(maxArr[0], maxArr[1], maxArr[2]);
            int min = get3Min(minArr[0], minArr[1], minArr[2]);
            System.out.println(max + " " + min);
            return;
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                prevMaxArr[j] = maxArr[j];
                prevMinArr[j] = minArr[j];
                int tmp = Integer.parseInt(st.nextToken());
                maxArr[j] = tmp;
                minArr[j] = tmp;
            }
            updateMaxArr(prevMaxArr);
            updateMinArr(prevMinArr);
        }

        int max = get3Max(maxArr[0], maxArr[1], maxArr[2]);
        int min = get3Min(minArr[0], minArr[1], minArr[2]);
        System.out.println(max+" "+min);
    }

    private static void updateMaxArr(int[] arr) {
        maxArr[0] += Math.max(arr[0], arr[1]);
        maxArr[1] += get3Max(arr[0], arr[1], arr[2]);
        maxArr[2] += Math.max(arr[1], arr[2]);
    }
    private static void updateMinArr(int[] arr) {
        minArr[0] += Math.min(arr[0], arr[1]);
        minArr[1] += get3Min(arr[0], arr[1], arr[2]);
        minArr[2] += Math.min(arr[1], arr[2]);
    }

    private static int get3Max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private static int get3Min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

}
>>>>>>> ee18cbd (12)
