package semester1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2251 {
    static int[] values;
    static int[] capacities;
    static ArrayList<Integer> answer;
    static HashSet<String> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        visited = new HashSet<>();
        answer = new ArrayList<>();


        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        values = new int[]{0, 0, C};
        capacities = new int[]{A, B, C};

        bfs();

    }

    static void bfs() {
        Queue<String> que = new LinkedList<>();
        que.add(toStr(values));
        visited.add(toStr(values));
        answer.add(values[2]);

        while (!que.isEmpty()) {
            StringTokenizer st = new StringTokenizer(que.poll());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int[] tmp = new int[]{a, b, c}; // 배열 복사
                    if(i==j) continue;
                    //주는 쪽이 먼저 0이 될 경우
                    if (capacities[j] - tmp[j] >= tmp[i]) {
                        while (tmp[i] > 0) {
                            tmp[i] = tmp[i] - 1;
                            tmp[j] = tmp[j] + 1;
                        }
                    }
                    //받는 쪽이 먼저 꽉 찰 경우
                    if(capacities[j] - tmp[j] < tmp[i]) {
                        while (tmp[j] < capacities[j]) {
                            tmp[i] = tmp[i] - 1;
                            tmp[j] = tmp[j] + 1;
                        }
                    }

                    String str = toStr(tmp);
                    if(visited.contains(str)) continue;
                    visited.add(str);
                    if (tmp[0] == 0) answer.add(tmp[2]);
                    que.add(str);
                }
            }
        }
        Collections.sort(answer);
        for (Integer integer : answer) {
            System.out.print(integer + " ");
        }

    }

    static String toStr(int[] arr) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            str.append(arr[i]);
            str.append(" ");
        }
        str.append(arr[2]);
        return str.toString();
    }
}