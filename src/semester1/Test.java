package semester1;

import java.util.*;
import java.io.*;

public class Test {
    static PriorityQueue<Integer> pq;
    static Queue<String> q;

    static List<Integer> list1;
    static List<Integer> list2;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[]{1,56,2,4,12,312,4,213,4,13};
        pq = new PriorityQueue<>((o1, o2) -> {
            // 홀수와 짝수로 구분
            if (o1 % 2 == 1 && o2 % 2 == 0) return -1;
            if (o1 % 2 == 0 && o2 % 2 == 1) return 1;

            // 동일한 홀수나 짝수 내에서는 숫자의 크기에 따라 오름차순 정렬
            return Integer.compare(o1, o2);
        });

        for (int num : array) {
            pq.offer(num);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    }




}