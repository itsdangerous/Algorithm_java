import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1260 {

    static int N, M;
    static ArrayList<Integer>[] nodes;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        int V = Integer.parseInt(str[2]);
        visited = new boolean[N + 1];

        // 노드를 저장할 배열 생성 및 초기화
        nodes = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        // M(간선)에 대하여 연결 리스트 생성
        for (int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            int from = Integer.parseInt(str[0]);
            int to = Integer.parseInt(str[1]);

            nodes[from].add(to);
            nodes[to].add(from);
        }


        for (int i = 1; i < nodes.length; i++) {
            Collections.sort(nodes[i]); // 노드에 연결된 노드 순서를 오름차순으로 정렬
        }

        dfs(V);

        Arrays.fill(visited, false); // 주현이형한테 배운 fill을 통해 dfs 이후의 visited를 초기화
        System.out.println();

        bfs(V);

    }

    static void dfs(int start) { // 입력된 v를 start로 하는 bfs탐색
        if (visited[start]) return;

        System.out.print(start + " ");
        visited[start] = true;

        // 방문한 노드에 연결된 노드만큼 bfs로탐색
        for (int i = 0; i < nodes[start].size(); i++) {

            // 노드에 연결된 노드를 정렬하면 아래 로직 필요없음
            /*int least = Integer.MAX_VALUE;

            for (int j = 0; j < nodes[start].size(); j++) { // 이 for문은 방문한 노드에 존재하는 가장 작은 번호의 node를 찾음
                int index = nodes[start].get(j);
                if(!visited[index]) least = Math.min(least, index);

            }
            if(least==Integer.MAX_VALUE) break; // 해당 노드에 연결된게 없으면 탐색 종료
            dfs(least);
            */

            Object t = nodes[start].get(i);
            if (t == null) break; // 해당 노드에 연결된게 없으면 탐색 종료
            dfs((int) t);
        }
    }

    static void bfs(int start) {
        Deque<Integer> deque = new LinkedList<>(); // dfs와 달리 bfs는 queue를 이용한다. 난 deque를 써서 앞뒤로 넣고 뺄래

        deque.add(start); //먼저, 제일 먼저 탐색할 노드 번호를 큐에 넣어준다.
        visited[start] = true; // 방문 했니~?

        while (!deque.isEmpty()) { // 큐에 노드가 없다면 방문할 곳이 없단 뜻이다.  그럼 그냥 끝난거다.
            int node = deque.poll(); // 큐에 노드가 있다면 여기부터 수행하는데, 제일먼저 큐에 들어간 노드를 빼서 그 번호의 노드를 탐색했다고 프린트 해준다.
            System.out.print(node + " ");

            for (int i = 0; i < nodes[node].size(); i++) { // 빼낸 놈을 인접리스트 관점에서 보자. 탐색했던 노드에 연결된 노드가 있다면 for문을 수행한다.


                Object t = nodes[node].get(i); // 노드에 첫 번째로 연결된(정렬되었으니 크기가 가장 작은 노드겠지)노드를 t로 잡아주고

                if (t == null) break; // 만약 탐색했던 노드에 다른 노드가 연결되어 있지 않다면 그 노드에 대해서 탐색 종료.
                if (!visited[(int) t]) { // 방문 했니~?
                    deque.add((int) t); // 탐색 안했으면 큐에 넣고
                    visited[(int) t] = true; // 그 노드를 탐색햇다고 표시해줌. 그 뒤로는 다시 while문을 돌면서 큐에 들어간거 빼고 그 노드에 연결된거 탐색.

                }
            }
        }

    }
}
/*
* 인접리스트로 구현한 결과dfs와 bfs의 다른점은
* dfs는 해당 노드에 연결된 노드가 있으면 바로 탐색하며, 끝까지 간다.
* bfs는 해당 노드에 연결된 노드가 있다면 그 노드에 연결된것을 전체 탐색하고 다음으로 넘어간다.
* bfs는 먼저 queue에 넣어주고 빼주면서(FIFO) 먼저 탐색한 것에 대해 가지치기로 찾을 수있었다.
*
* */

