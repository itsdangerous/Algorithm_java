import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class swea_goldboxpwd {
    static int N, K;
    static TreeSet<Integer> set;
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            set = new TreeSet<>();
            String input = br.readLine();
            int M = N / 4;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < 4; j++) {
                    StringBuilder tmp = new StringBuilder();
                    for (int k = (j + 1) * M; k < (j + 2) * M; k++) {
                        int w = (k - i) % N;
                        tmp.append(input.charAt(w));
                    }
                    int ii = Integer.parseInt(String.valueOf(tmp), 16);
                    set.add(ii);
                }
            }
            Iterator<Integer> it = set.iterator();
            int cnt = 0;
            while(it.hasNext()) {
                int answer = it.next();
                if(cnt == set.size()-K) {
                    System.out.printf("#%d %d\n", t, answer);/**/
                    break;
                }
                cnt++;
            }

        }
    }
}
