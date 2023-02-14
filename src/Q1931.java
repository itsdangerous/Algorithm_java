import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] rooms = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rooms[i][0] = Integer.parseInt(st.nextToken());
            rooms[i][1] = Integer.parseInt(st.nextToken());
        }

//        Arrays.sort(rooms, (e1, e2) -> {
//            if (e1[0] == e2[0]) {
//                return e1[1] - e2[1];
//            }
//            return e1[0] - e2[0];
//        });

        Arrays.sort(rooms, Comparator.comparingInt(e -> e[0]));

        Arrays.sort(rooms, Comparator.comparingInt(e -> e[1]));


        int cnt = 1;
        int end = rooms[0][1];
        for (int i = 1; i < N; i++) {
            if (rooms[i][0] >= end) {
                cnt++;
                end = rooms[i][1];
            }
        }
        System.out.println(cnt);


    }


}