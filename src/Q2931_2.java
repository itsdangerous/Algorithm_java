import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2931_2 {

    static int R, C;
    static char[][] map;
    static int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 하 우 상 좌

    static int[] curDirection;
    static int[] prevDirection;

    static int[] startPoint, endPoint;
    static int[] answerPoint;
    static int answerCurve = '*';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        startPoint = new int[2];
        endPoint = new int[2];
        answerPoint = new int[]{-1, -1};
        curDirection = new int[2];
        prevDirection = new int[2];

        // map 입력 받기
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'M') {
                    startPoint = new int[]{i, j};
                }
                if (map[i][j] == 'Z') {
                    endPoint = new int[]{i, j};
                }
            }
        }
        solve();
    }

    static void solve() {
        dfs(startPoint[0], startPoint[1]);
        System.out.print(answerPoint[0] + " " + answerPoint[1]+" ");
        System.out.printf("%c", answerCurve);
    }

    static void dfs(int r, int c) {
        if (map[r][c] == '.') {
            char t = getCurve(r,c);
            if (t != '0') {
                answerPoint = new int[]{r + 1, c + 1};
                answerCurve = t;
                System.out.print(answerPoint[0] + " " + answerPoint[1] + " ");
                System.out.printf("%c", answerCurve);
                System.exit(0);
            }
            return;
        }

        if (findCurve(map[r][c])) {
            changeDirection(map[r][c]);
            int nr = r + curDirection[0];
            int nc = c + curDirection[1];
            dfs(nr, nc);
        }

        if (map[r][c] == 'M') {
            for (int i = 0; i < 4; i++) {
                curDirection[0] = direction[i][0];
                curDirection[1] = direction[i][1];
                int nr = r + curDirection[0];
                int nc = c + curDirection[1];
                if (!check(nr, nc)) continue;
                if (!findCurve(map[nr][nc])) continue;
                dfs(nr, nc);

            }
        }

    }

    static boolean check(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    static boolean findCurve(char c) {
        return c == '1' || c == '2' || c == '3' || c == '4' || c == '|' || c == '-' || c == '+';
    }

    static void changeDirection(char c) {
        switch (c) {
            case '1':
                if (curDirection[0] == 0 && curDirection[1] == -1)  // <- 방향으로 들어왔다면
                {
                    curDirection = new int[]{1, 0};
                }
                if (curDirection[0] == -1 && curDirection[1] == 0) // ↑ 방향으로 들어왔다면
                    curDirection = new int[]{0, 1};
                break;

            case '2':

                if (curDirection[0] == 1 && curDirection[1] == 0) // ↓ 방향으로 들어왔다면
                    curDirection = new int[]{0, 1};
                if (curDirection[0] == 0 && curDirection[1] == -1) // <- 방향으로 들어왔다면
                    curDirection = new int[]{-1, 0};
                break;

            case '3':
                if (curDirection[0] == 1 && curDirection[1] == 0) // ↓ 방향으로 들어왔다면
                    curDirection = new int[]{0, -1};
                if (curDirection[0] == 0 && curDirection[1] == 1) // -> 방향으로 들어왔다면
                    curDirection = new int[]{-1, 0};
                break;

            case '4':
                if (curDirection[0] == 0 && curDirection[1] == 1) // -> 방향으로 들어왔다면
                    curDirection = new int[]{1, 0};

                if (curDirection[0] == -1 && curDirection[1] == 0) // ↑ 방향으로 들어왔다면
                    curDirection = new int[]{0, -1};
                break;

        }
    }

    static char getCurve(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + direction[i][0];
            int nc = c + direction[i][1];
            if (!check(nr, nc)) continue;
//            if(direction[i][0] == curDirection[0] && direction[i][1] == curDirection[1]) continue;
            char t = getLink(curDirection, direction[i], map[nr][nc]);
            if (t == '0') {
                continue;
            }
            else {
                return t;
            }
        }
        return '0';
    }

    static char getLink(int[] prevDirection, int[] direction, char c) {
        if (prevDirection[0] == 0 && prevDirection[1] == -1) { // <- 방향으로 들어왔다면
            if (direction[0] == 0 && direction[1] == -1) { // <- 방향을 잇는다면
                if (c == '|' || c == '3' || c == '4' || c == '.') return '0';
                else return '-';
            }
            if(direction[0] == -1 && direction[1] == 0) { //   ↑ 방향을 잇는다면
                if(c == '-' || c=='2' || c=='3' || c == '.') return '0';
                else return '2';
            }
            if(direction[0] == 0 && direction[1] == 1) { // -> 방향을 잇는다면
                return '0';
            }
            if(direction[0] == 1 && direction[1] == 0) { // ↓ 방향을 잇는다면
                if(c == '-' || c =='1' || c=='4' || c =='.') return '0';
                else return '1';
            }
        }
        if (prevDirection[0] == -1 && prevDirection[1] == 0) { // ↑ 방향으로 들어왔다면
            if (direction[0] == 0 && direction[1] == -1) { // <- 방향을 잇는다면
                if (c == '|' || c == '3' || c == '4' || c == '.') return '0';
                else return '4';
            }
            if(direction[0] == -1 && direction[1] == 0) { //   ↑ 방향을 잇는다면
                if(c == '-' || c=='2' || c=='3' || c == '.') return '0';
                else return '|';
            }
            if(direction[0] == 0 && direction[1] == 1) { // -> 방향을 잇는다면
                if( c=='|' || c=='1' || c=='2' || c=='.') return '0';
                else return '1';
            }
            if(direction[0] == 1 && direction[1] == 0) { // ↓ 방향을 잇는다면
                return '0';
            }

        }
        if (prevDirection[0] == 0 && prevDirection[1] == 1) { // -> 방향으로 들어왔다면
            if (direction[0] == 0 && direction[1] == -1) { // <- 방향을 잇는다면
                return '0';
            }
            if(direction[0] == -1 && direction[1] == 0) { //   ↑ 방향을 잇는다면
                if(c == '-' || c=='2' || c=='3' || c == '.') return '0';
                else return '3';
            }
            if(direction[0] == 0 && direction[1] == 1) { // -> 방향을 잇는다면
                if( c=='|' || c=='1' || c=='2' || c=='.') return '0';
                else return '-';
            }
            if(direction[0] == 1 && direction[1] == 0) { // ↓ 방향을 잇는다면
                if(c == '-' || c =='1' || c=='4' || c =='.') return '0';
                else return '4';
            }
        }

        if (prevDirection[0] == 1 && prevDirection[1] == 0) { // ↓ 방향으로 들어왔다면
            if (direction[0] == 0 && direction[1] == -1) { // <- 방향을 잇는다면
                if (c == '|' || c == '3' || c == '4' || c == '.') return '0';
                else return '3';
            }
            if(direction[0] == -1 && direction[1] == 0) { //   ↑ 방향을 잇는다면
                return '0';
            }
            if(direction[0] == 0 && direction[1] == 1) { // -> 방향을 잇는다면
                if( c=='|' || c=='1' || c=='2' || c=='.') return '0';
                else return '2';
            }
            if(direction[0] == 1 && direction[1] == 0) { // ↓ 방향을 잇는다면
                if(c == '-' || c =='1' || c=='4' || c =='.') return '0';
                else return '|';
            }

        }
        return '0';
    }
}
