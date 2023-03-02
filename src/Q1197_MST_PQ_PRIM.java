import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1197_MST_PQ_PRIM {

    static int V, E;

    static class Edge implements Comparable<Edge>{
        int v;
        int w;
        public Edge(int v,int w) {
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
    static long min;
    static boolean [] checked;

    static List<Edge>[] adj;
    static PriorityQueue<Edge> points;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        adj=new ArrayList[V+1];   //-----adjcent List 만들기!!
        for (int i=1; i <= V;i++){
            adj[i]=new ArrayList<>();  // 생성필수
        }
        //-----adjcent List 만들기!!
        for (int i = 0; i < E; i++) {
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            adj[s].add(new Edge(e, w));
            adj[e].add(new Edge(s, w));
        }

        points=new PriorityQueue<>();
        checked=new boolean[V+1];
        points.offer(new Edge(1, 0));
        int cnt=0;
        while(!points.isEmpty()) {
            Edge edge=points.poll();
            if(checked[edge.v])continue;
            min+=edge.w;
            checked[edge.v]=true;
            if(++cnt==V) break;
            for (int i = 0; i < adj[edge.v].size(); i++) {
                Edge next=adj[edge.v].get(i);
                if(checked[next.v])continue;
                points.offer(next);
            }
        }
        System.out.println(min);
    }

}