import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1244 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            answer[i] = Integer.parseInt(st.nextToken());

        int s = Integer.parseInt(br.readLine());
        ArrayList<int[]> S = new ArrayList<>();

        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());

            S.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        for (int i = 0; i < s; i++) {
            int human = S.get(i)[0]; // 학생의 성별
            int number = S.get(i)[1]; // 학생의 번호

            if(human == 1) { // 남자
                for (int j = number-1; j < N; j+=number) { // 스위치 번호가 배수인 경우 바꾸기
                    if(answer[j] == 1)
                        answer[j] = 0;
                    else
                        answer[j] = 1;
                }
            } else { // 여자
                for (int j = 0; j < N/2+1; j++) { // 좌우 대칭 범위
                    if(number-1-j < 0 || number-1+j >= N) // 배열 범위를 벗어난 경우 종료
                        break;

                    if(answer[number-1-j] != answer[number-1+j]) // 대칭이 아닌 경우 종료
                        break;

                    if(answer[number-1-j] == 1) { // 대칭인 경우 바꾸기
                        answer[number-1-j] = 0;
                        answer[number-1+j] = 0;
                    }
                    else {
                        answer[number-1-j] = 1;
                        answer[number-1+j] = 1;
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            System.out.print(answer[i] + " ");
            cnt++;

            if(cnt == 20) {
                cnt = 0;
                System.out.println();
            }
        }
    }

}