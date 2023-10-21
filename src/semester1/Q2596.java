package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2596 {

    static final String A = "000000";
    static final String B = "001111";
    static final String C = "010011";
    static final String D = "011100";
    static final String E = "100110";
    static final String F = "101001";
    static final String G = "110101";
    static final String H = "111010";
    static String[] alpha = {A, B, C, D, E, F, G, H};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int size = T * 6;
        int result = 0;
        String msg = br.readLine();
        String tmp = "";
        StringBuilder answer = new StringBuilder();
        boolean t = true;
        for (int i = 0; i < T; i++) {
            tmp = msg.substring(i * 6, i * 6 + 6);
            int cnt = 0;
            boolean check = false;
            for (int j = 0; j < alpha.length; j++) {
                if (alpha[j].equals(tmp)) {
                    answer.append((char) (65 + j));
                    cnt++;
                    check = true;
                }
            }
            if(!check){
                boolean cc = false;
                for (int j = 0; j < alpha.length; j++) {
                    if (compare(alpha[j], tmp) == 1) {
                        answer.append((char) (65 + j));
                        cc = true;
                        break;
                    }
                }
                if (!cc) {
                    result = i+1;
                    t = false;
                    break;
                }
            }

        }
        if(t) {
            System.out.println(answer);
        }
        else {
            System.out.println(result);
        }
    }

    public static int compare(String a, String b) {
        int res = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                res++;
            }
        }
        return res;
    }
}