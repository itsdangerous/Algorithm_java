import java.io.*;
import java.util.Arrays;

public class Test {
    static int T;
    static char [] enc;
    static char [] passwd;
    static int [] count;
    static int[] alpha;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String str = br.readLine();
            enc = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                enc[i]= str.charAt(i);
            }
            alpha = new int[26];
            str = br.readLine();
            passwd = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                passwd[i]= str.charAt(i);
                alpha[passwd[i]-'a']++;
            }
            count = new int[26];
            int size = passwd.length;
            int len = enc.length;
            for (int i = 0; i < size; i++) {
                count[enc[i]-'a']+=1;
            }
            if(check(count, alpha)) {
                System.out.println("YES");
                continue ;
            }

            boolean flag = false;
            for (int i = size; i < len; i++) {
                count[enc[i-size]-'a']-=1;
                count[enc[i]-'a']+=1;
                if(check(count, alpha)) {
                    flag= true;
                    break;
                }
            }
            if(flag) {
                System.out.println("YES");
                continue;
            }

            System.out.println("NO");
        }


    }
    /*
     * Anagram
     * 윈도우의 크기 -> 비밀번호의 길이
     * 암호화된 비밀번호를 1씩 이동해가며 윈도우의 크기만큼 확인한다.
     * 확인해야 할 것은 윈도우 크기만큼에 해당하는 구간의 사용한 알파벳의 개수이다.
     * a ~ z까지를 인덱스로 하는 int형 배열을 만들자
     * 그리고 윈도우를 하나씩 이동할때에는 이동전 0번째 알파벳의 사용횟수를 -1해주고
     * 이동 후 가장 마지막 알파벳의 사용횟수를 +1 해주는 식으로 하여
     * 이전 결과를 써먹을 수 있도록 접근하자.
     */


    //비밀번호에 있는 알파벳이 모두 count 되었는지 확인하는 함수
    static boolean check(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}
