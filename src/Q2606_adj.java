//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Q2606_adj {
//    static int N, M;
//    static List<Integer>[] Lists;
//    static boolean[] visited;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int M = Integer.parseInt(br.readLine());
//        Lists = new ArrayList[N];
//        visited = new boolean[N];
//        for (int i = 0; i < N; i++) {
//            Lists[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < M; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int s = Integer.parseInt(st.nextToken()) -1;
//            int e = Integer.parseInt(st.nextToken()) -1;
//            Lists[s].add(e);
//            Lists[e].add(s);
//        }
//        bfs(0);
//        result();
//    }
//
//    static void result() {
//        int cnt = 0;
//        for (int i = 0; i < N; i++) {
//            if (visited[i]) cnt++;
//        }
//        System.out.println(cnt - 1);
//    }
//
//    static void bfs(int s) {
//        Queue<Integer> que = new LinkedList<>();
//        que.offer(s);
//        visited[s] = true;
//        while (!que.isEmpty()) {
//            int start = que.poll();
//            for (int e : Lists[start]) {
//                if(visited[e]) continue;
//                que.offer(e);
//                visited[e]= true;
//            }
//        }
//    }
//}
