//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Objects;
//import java.util.StringTokenizer;
//
//public class Q2644_2 {
//    static int N, M, a, b;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        N = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        a = Integer.parseInt(st.nextToken());
//        b = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(br.readLine());
//
//
//        int[] arr = new int[N + 1];
//
//        for (int i = 1; i <= M; i++) {
//            st = new StringTokenizer(br.readLine());
//            int parent = Integer.parseInt(st.nextToken());
//            int child = Integer.parseInt(st.nextToken());
//            arr[child] = parent;
//        }
//
//
//        solve(arr);
//
//    }
//
//    static void solve(int[] arr) {
//
//
//        //a 부모 리스트
//        int index = a;
//        while (arr[index] != 0) {
//            index = arr[index];
//        }
//
//        //b 부모 리스트
//        index = b;
//        while (arr[index] != 0) {
//            tmp[index]++;
//            index = arr[index];
//        }
//
//        System.out.println(calc(list_A, list_B));
//
//    }
//
//    //
//    static int calc(ArrayList<Integer> a, ArrayList<Integer> b) {
//        for (int i = 0; i < a.size(); i++) {
//            for (int j = 0; j < b.size(); j++) {
//                if (Objects.equals(a.get(i), b.get(j))) {
//                    return i+j;
//                }
//            }
//        }
//        return -1;
//    }
//
//
//
//}
