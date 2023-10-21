package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int size = str.length();

        // 입력된 문자열에서 a의 개수를 센 후
        // 그 크기를 슬라이싱 크기로 지정
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            if (str.charAt(i) == 'a') {
                cnt++;
            }
        }

        // 입력된 문자열을 슬라이싱
        int min = size;
        for (int i = 0; i < size; i++) {
            int cntB = 0;
            //슬라이싱해서 나온 b의 개수를 저장하고 min값을 찾아냄
            for (int j = i; j < i+cnt; j++) {
                if(str.charAt(j%size) == 'b') cntB++;
            }

            min = Math.min(min, cntB);
        }

        System.out.println(min);

    }
}