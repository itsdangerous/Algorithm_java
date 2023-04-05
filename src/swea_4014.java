import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

/*swea_4014 활주로 건설*/
public class swea_4014 {
    static int N, X;
    static int[][] map;
    static int answer;
    public static void setInput(String path, String fileName) throws IOException {
        String projectPath = System.getProperty("user.dir");
        System.setIn(Files.newInputStream(Paths.get(projectPath + path + fileName)));
    }
    public static void print(Object... args) {
        StringBuilder sb = new StringBuilder();

        for (Object arg : args) {
            sb.append(arg).append(" ");
        }

        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {
        String path = "//src//tc//";
        String file = "swea_4014.txt";
        setInput(path, file);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int TC = 1; TC <= T; TC++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            answer = 0;
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
//            printArr(map);
            solve();
            System.out.printf("#%d %d\n", TC, answer);
        }
    }
    static void solve() {

        for (int i = 0; i < N; i++) {
            answer += testRow(i);
            answer += testCol(i);
        }
    }

    static int testRow(int index) {
        int i = 0;
        while (i < N) {
            int cnt = 1;
            while (i + 1 < N && map[index][i] == map[index][i + 1]) {
                cnt++;
                i++;
            }
            if (i + 1 < N && map[index][i] + 1 == map[index][i + 1]) {
                if (cnt < X) return 0;
                i++;
            }
            else if (i + 1 < N && map[index][i] - 1 == map[index][i + 1]) {
                cnt = 1;
                i++;
                while (i + 1 < N && map[index][i] == map[index][i + 1] && cnt < X) {
                    cnt++;
                    i++;
                }
                if (cnt < X) return 0;

                // 국신이가 알려준 추가할 코드
                i++;
                if (i == N - 1) {
                    if (map[index][i - 1] == map[index][i]) {
                        return 1;
                    }

                    return 0;
                }

                if (i < N && map[index][i - 1]  < map[index][i]) {
                    //System.out.println("row " + index);

                    return 0;
                }

                if (i < N && map[index][i - 1]  > map[index][i]) {
                    i--;
                }
                // -------------------- //


            } else if (i+1 < N && Math.abs(map[index][i] - map[index][i+1]) > 1) {
                return 0;
            }
            else {
                //System.out.println("row " + index);
                return 1;
            }
        }
//        System.out.println("row " + index);

        return 1;
    }
    static int testCol(int index) {
        int i = 0;
        while (i < N) {
            int cnt = 1;
            while (i + 1 < N && map[i][index] == map[i+1][index]) {
                cnt++;
                i++;
            }
            if (i + 1 < N && map[i][index] + 1 == map[i+1][index]) {
                if (cnt < X) return 0;
                i++;
            } else if (i + 1 < N && map[i][index] - 1 == map[i+1][index]) {
                cnt = 1;
                i++;
                while (i + 1 < N && map[i][index] == map[i+1][index] && cnt < X) {
                    cnt++;
                    i++;
                }
                if (cnt < X) return 0;

                i++;

                if (i == N - 1) {
                    if (map[i  - 1][index] == map[i][index]) {
                        return 1;
                    }

                    return 0;
                }


                if (i < N && map[i - 1][index]  < map[i][index]) {
                   // System.out.println("col " + index);

                    return 0;
                }

                if (i < N && map[i - 1][index]  > map[i][index]) {
                    i--;
                }
            } else if (i+1 < N && Math.abs(map[i][index] - map[i+1][index]) > 1) {
                return 0;
            }
            else {
                //System.out.println("col " +index);

                return 1;
            }
        }
        //System.out.println("col " +index);
        return 1;
    }

    static void printArr(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
