import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DisjointSetTest {
    static int[] p;
    static int[] rank;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 5;
        makeSet();
        print();

    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if(rank[px] > rank[py]) {
            p[py] = px;
        }else{
            p[px] = py;
            if(rank[px] == rank[py]) {
                rank[py]++;
            }
        }
    }

    private static int find(int x) {
        if(x==p[x]) return x; // return p[x]
        return p[x] = find(p[x]); // 중요. x에 부모를 넣어서 최종 부모를 찾는다.
    }

    static void print() {
        System.out.println(Arrays.toString(p));
        System.out.println(Arrays.toString(rank));
    }
    static void makeSet() {
        p = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;
            rank[i] = 1;
        }
    }

}
