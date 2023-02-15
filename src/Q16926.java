import java.util.Scanner;
public class Q16926 {
    static int N,M,R;
    static int[][] map;
    static int[] dr= {0,1,0,-1};
    static int[] dc= {1,0,-1,0};
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);
        N=scann.nextInt();
        M=scann.nextInt();
        R=scann.nextInt();
        map=new int[N][M];
        //input
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j]=scann.nextInt();
            }
        }
        // 로직
        int K=Math.min(N, M)/2; // 겹
        for (int cnt = 0; cnt < K; cnt++) {  // cnt겹
            for (int rot = 0; rot< R; rot++) { // 회전
                int temp=map[cnt][cnt];
                int r=cnt;
                int c=cnt;
                int d=0;
                while(d<4) {  // 한바쿼
                    int nr=r+dr[d];
                    int nc=c+dc[d];
                    if(nr>=cnt && nr<N-cnt &&
                            nc>=cnt && nc<M-cnt) {
                        map[r][c]=map[nr][nc];
                        r=nr;
                        c=nc;
                    }else {
                        d++;  //방향전환
                    }
                }
                map[cnt+1][cnt]=temp;
            }
        }
        //정답출력
        print();
    }
    static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}