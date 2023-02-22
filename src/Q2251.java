import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2251 {

    static HashSet<String> visited = new HashSet<>();
    static Bottle[] bottles;
    static Queue<Bottle[]> que;
    static ArrayList<Integer> answer = new ArrayList<>();

    static class Bottle {
        int value;
        int capacity;

        public Bottle() {
            this.value = 0;
            this.capacity =0;
        }

        public Bottle(int value, int capacity) {
            this.value = value;
            this.capacity = capacity;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Bottle A = new Bottle(0, a);
        Bottle B = new Bottle(0, b);
        Bottle C = new Bottle(c, c);

        bottles = makeBottles(A, B, C);

        // 처음 무조건 들어감
        visited.add(toStr(bottles));
        answer.add(bottles[2].value);

        bfs();

    }

    static void bfs() {
        que = new LinkedList<>();
        que.add(bottles);
        while (!que.isEmpty()) {
            bottles = que.poll();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(i==j) continue;
                    printBottles(bottles);



                    fillFromTo(bottles[i], bottles[j]);
                    String tmp = toStr(bottles);
                    if(visited.contains(tmp)) continue;
                    visited.add(toStr(bottles));
                    que.add(bottles);
                    if(bottles[0].value ==0) answer.add(bottles[2].value);
                }
            }

        }
        Collections.sort(answer);
        for (Integer integer : answer) {
            System.out.print(integer + " ");
        }
        System.out.println();

    }

    static String toStr(Bottle[] b) {
        String str = "";
        for (int i = 0; i < 3; i++) {
            str += Integer.toString(b[i].value);
        }

        return str;
    }

    static void fillFromTo(Bottle from, Bottle to) {
        // 주는 쪽이 먼저 빌 경우
        
        if (to.capacity - to.value >= from.value) {
            to.setValue(to.value + from.value);
            from.setValue(0);
        }

        // 받는 쪽이 먼저 꽉차는 경우
        if (to.capacity - to.value < from.value) {
            from.setValue(from.value - (to.capacity + to.value));
            to.setValue(to.capacity);
        }
    }

    static Bottle[] makeBottles(Bottle a, Bottle b, Bottle c) {
        Bottle[] tmp = new Bottle[3];
        tmp[0] = a;
        tmp[1] = b;
        tmp[2] = c;

        return tmp;
    }

    static void printBottles(Bottle[] bottles) {
        for (Bottle bottle : bottles) {
            System.out.print(bottle.value + " ");
        }
        System.out.println();
    }

}
