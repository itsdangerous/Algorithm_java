import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_Ladder1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 10; i++) {
            int T = Integer.parseInt(br.readLine());
            int[][] map = new int[100][100];
            for (int j = 0; j < 100; j++) {
                String[] str = br.readLine().split(" ");
                for (int k = 0; k < 100; k++) {
                    map[j][k] = Integer.parseInt(str[k]);
                }
            }

            int goal_index = 0;
            for (int j = 0; j < 100; j++) {
                if (map[99][j] == 2) {
                    goal_index = j;
                }
            }
            int h = 99;

            while (true) {
                if (h == 0) {
                    System.out.printf("#%d %d\n", T, goal_index);
                    break;
                }

                if (goal_index == 99) {
                    while (map[h][goal_index - 1] == 1) {
                        goal_index--;
                        if (goal_index == 0) {
                            break;
                        }
                    }
                    h--;
                    continue;
                }

                if (goal_index == 0) {
                    while (map[h][goal_index + 1] == 1) {
                        goal_index++;
                        if (goal_index == 99) {
                            break;
                        }
                        continue;
                    }
                    h--;
                    continue;
                }

                if (map[h][goal_index - 1] == 1) {
                    while (map[h][goal_index - 1] == 1) {
                        goal_index--;
                        if (goal_index == 0) {

                            break;
                        }
                    }
                    h--;
                    continue;
                }

                if (map[h][goal_index + 1] == 1) {
                    while (map[h][goal_index + 1] == 1) {
                        goal_index++;
                        if (goal_index == 99) {
                            break;
                        }
                    }
                    h--;
                    continue;
                }
                h--;
            }

        }
    }
}
