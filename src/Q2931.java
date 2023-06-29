import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q2931 {
    static int N;
    static int M;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new char[N][M];
        Pair start = null;

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = str.charAt(j);

                if(map[i][j]=='M') {
                    start = new Pair(i, j, -1);
                    map[i][j]='.';
                }

                if(map[i][j]=='Z')
                    map[i][j]='.';
            }
        }

        for(int i=0; i<4; i++) {
            int nx = start.x+dx[i];
            int ny = start.y+dy[i];

            if(nx<0 || nx>=N || ny<0 || ny>=M) continue;

            if(map[nx][ny]!='.') {
                bfs(start.x, start.y, i);
                break;
            }
        }
    }

    public static void bfs(int x, int y, int idx) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y, idx));

        loop:while(!queue.isEmpty()) {
            Pair temp = queue.poll();
            int nx = temp.x+dx[temp.idx];
            int ny = temp.y+dy[temp.idx];

            switch(map[nx][ny]) {
                case '|':
                    queue.add(new Pair(nx, ny, temp.idx));

                    break;

                case '-':
                    queue.add(new Pair(nx, ny, temp.idx));

                    break;

                case '+':
                    queue.add(new Pair(nx, ny, temp.idx));

                    break;

                case '1': {
                    if(temp.idx==2) {
                        queue.add(new Pair(nx, ny, 1));
                    }

                    else {
                        queue.add(new Pair(nx, ny, 3));
                    }
                }
                break;

                case '2': {
                    if(temp.idx==1) {
                        queue.add(new Pair(nx, ny, 3));
                    }

                    else {
                        queue.add(new Pair(nx, ny, 0));
                    }
                }
                break;

                case '3': {
                    if(temp.idx==1) {
                        queue.add(new Pair(nx, ny, 2));
                    }

                    else {
                        queue.add(new Pair(nx, ny, 0));
                    }
                }
                break;

                case '4': {
                    if(temp.idx==3) {
                        queue.add(new Pair(nx, ny, 1));
                    }

                    else {
                        queue.add(new Pair(nx, ny, 2));
                    }
                }
                break;

                case '.': {
                    if(temp.idx==0) {
                        char ans = ' ';
                        int cnt = 0;

                        if(nx>=1 && map[nx-1][ny]!='.' && map[nx-1][ny]!='-' && map[nx-1][ny]!='2' && map[nx-1][ny]!='3') {
                            ans = '|';
                            cnt++;
                        }

                        if(ny>=1 && map[nx][ny-1]!='.' && map[nx][ny-1]!='|' && map[nx][ny-1]!='3' && map[nx][ny-1]!='4') {
                            ans = '4';
                            cnt++;
                        }

                        if(ny<M-1 && map[nx][ny+1]!='.' && map[nx][ny+1]!='|' && map[nx][ny+1]!='1' && map[nx][ny+1]!='2') {
                            ans = '1';
                            cnt++;
                        }

                        if(cnt==3)
                            System.out.println((nx+1)+" "+(ny+1)+" +");
                        else
                            System.out.println((nx+1)+" "+(ny+1)+" "+ans);

                        break loop;
                    }

                    else if(temp.idx==1) {
                        char ans = ' ';
                        int cnt = 0;

                        if(nx<N-1 && map[nx+1][ny]!='.' && map[nx+1][ny]!='-' && map[nx+1][ny]!='1' && map[nx+1][ny]!='4') {
                            ans = '|';
                            cnt++;
                        }

                        if(ny>=1 && map[nx][ny-1]!='.' && map[nx][ny-1]!='|' && map[nx][ny-1]!='3' && map[nx][ny-1]!='4') {
                            ans = '3';
                            cnt++;
                        }

                        if(ny<M-1 && map[nx][ny+1]!='.' && map[nx][ny+1]!='|' && map[nx][ny+1]!='1' && map[nx][ny+1]!='2') {
                            ans = '2';
                            cnt++;
                        }

                        if(cnt==3)
                            System.out.println((nx+1)+" "+(ny+1)+" +");
                        else
                            System.out.println((nx+1)+" "+(ny+1)+" "+ans);

                        break loop;
                    }

                    else if(temp.idx==2) {
                        char ans = ' ';
                        int cnt = 0;

                        if(ny>=1 && map[nx][ny-1]!='.' && map[nx][ny-1]!='|' && map[nx][ny-1]!='3' && map[nx][ny-1]!='4') {
                            ans = '-';
                            cnt++;
                        }

                        if(nx>=1 && map[nx-1][ny]!='.' && map[nx-1][ny]!='-' && map[nx-1][ny]!='2' && map[nx-1][ny]!='3') {
                            ans = '2';
                            cnt++;
                        }

                        if(nx<N-1 && map[nx+1][ny]!='.' && map[nx+1][ny]!='-' && map[nx+1][ny]!='1' && map[nx+1][ny]!='4') {
                            ans = '1';
                            cnt++;
                        }

                        if(cnt==3)
                            System.out.println((nx+1)+" "+(ny+1)+" +");
                        else
                            System.out.println((nx+1)+" "+(ny+1)+" "+ans);

                        break loop;
                    }

                    else {
                        char ans = ' ';
                        int cnt = 0;

                        if(ny<M-1 && map[nx][ny+1]!='.' && map[nx][ny+1]!='|' && map[nx][ny+1]!='1' && map[nx][ny+1]!='2') {
                            ans = '-';
                            cnt++;
                        }

                        if(nx>=1 && map[nx-1][ny]!='.' && map[nx-1][ny]!='-' && map[nx-1][ny]!='2' && map[nx-1][ny]!='3') {
                            ans = '3';
                            cnt++;
                        }

                        if(nx<N-1 && map[nx+1][ny]!='.' && map[nx+1][ny]!='-' && map[nx+1][ny]!='1' && map[nx+1][ny]!='4') {
                            ans = '4';
                            cnt++;
                        }

                        if(cnt==3)
                            System.out.println((nx+1)+" "+(ny+1)+" +");
                        else
                            System.out.println((nx+1)+" "+(ny+1)+" "+ans);

                        break loop;
                    }
                }
            }
        }
    }

    public static class Pair {
        int x;
        int y;
        int idx;

        public Pair(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
}