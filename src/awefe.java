import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class awefe {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] musics = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            musics[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            int[] firstPart = new int[i];
            for (int j = 0; j < firstPart.length; j++) {
                firstPart[j] = musics[j];
            }
            print(firstPart);
            System.out.print(" | ");
            for (int j = i; j < M; j++) {

            }
            int[] backPart = new int[N];
            for (int j = 0; j < N; j++) {
                backPart[j] = musics[j+i];
            }
            print(firstPart);
            System.out.print(" | ");
            print(backPart);
            System.out.println();
        }
    }
    static void print(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

}
