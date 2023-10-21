package semester1;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class form_prim_MST {
    static int V, E;

    static class Edge implements Comparable<Edge> {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static long min;
    static int[] distance;
    static boolean[] checked;
    static int MM = Integer.MAX_VALUE / 1000;
    static List<Edge>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[s].add(new Edge(e, w));
            adj[e].add(new Edge(s, w));
        }

        distance = new int[V + 1];
        checked = new boolean[V + 1];
        Arrays.fill(distance, MM);

        //간적쿠 간만프

        distance[1] = 0;
        for (int i = 1; i < V + 1; i++) {
            int w = -1;
            int minV = MM;
            for (int j = 1; j < V + 1; j++) {
                if (!checked[j] && minV > distance[j]) {
                    minV = distance[j];
                    w = j;
                }
            }
            checked[w] = true;
            min += minV;
            for (int v = 0; v < adj[w].size(); v++) {
                Edge edge = adj[w].get(v);

                if (!checked[edge.v] && edge.w < distance[edge.v]) {
                    distance[edge.v] = edge.w;
                }
            }
        }
        System.out.println(min);

    }
}
