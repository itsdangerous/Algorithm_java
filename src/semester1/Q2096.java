package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2096 {
    static int N;
    static int[] curMaxArr, curMinArr;
    static int[] prevMaxArr;
    static int[] prevMinArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        // 현재 상태의 min, max 배열
        curMaxArr = new int[3];
        curMinArr = new int[3];
        // 이전 상태의 min, max 배열
        prevMaxArr = new int[3];
        prevMinArr = new int[3];

        // 가장 처음 상태에 대해 최소, 최대 찾아줌
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            curMaxArr[i] = tmp;
            curMinArr[i] = tmp;
        }
        // N이 2 이상일 경우에 대해 수행
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                // 이전 배열에 현재배열을 복사한 후
                prevMaxArr[j] = curMaxArr[j];
                prevMinArr[j] = curMinArr[j];
                int tmp = Integer.parseInt(st.nextToken());
                // 현재 배열을 새롭게 입력 받음
                curMaxArr[j] = tmp;
                curMinArr[j] = tmp;
            }
            // 이전 상태 배열에 대해 현재 배열 갱신
            updateMaxArr(prevMaxArr);
            updateMinArr(prevMinArr);
        }

        int max = get3Max(curMaxArr[0], curMaxArr[1], curMaxArr[2]);
        int min = get3Min(curMinArr[0], curMinArr[1], curMinArr[2]);
        System.out.println(max+" "+min);
    }

    //  현재 배열의  0번 인덱스는 이전 배열의 0, 1번 요소를
    //              1번 인덱스는 이전 배열의 0,1,2번 요소를
    //              2번 인덱스는 이전 배열의 1, 2번 요소를
    //  비교하여 각각 최소, 최대에 대해 갱신
    private static void updateMaxArr(int[] prevArr) {
        curMaxArr[0] += Math.max(prevArr[0], prevArr[1]);
        curMaxArr[1] += get3Max(prevArr[0], prevArr[1], prevArr[2]);
        curMaxArr[2] += Math.max(prevArr[1], prevArr[2]);
    }
    private static void updateMinArr(int[] prevArr) {
        curMinArr[0] += Math.min(prevArr[0], prevArr[1]);
        curMinArr[1] += get3Min(prevArr[0], prevArr[1], prevArr[2]);
        curMinArr[2] += Math.min(prevArr[1], prevArr[2]);
    }

    private static int get3Max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private static int get3Min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

}