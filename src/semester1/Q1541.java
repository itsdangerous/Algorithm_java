package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Q1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("-");
        int result = 0;
        for (int i = 0; i < str.length; i++) {
            String[] ss = str[i].split("\\+");
            if (i == 0) for (String s : ss) result += Integer.parseInt(s);
            else for (String s : ss) result -= Integer.parseInt(s);
            }
        System.out.println(result);
    }
}
