package semester1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_COOK_nextcombi {

    static int T,N;
    static int min;
    static int [][] taste;
    static int []   p;

    public static void main(String[] args)  throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=null;
        T=Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            taste=new int[N][N];      // 음식의 맛
            p=new int[N];   // 선택되면 A
            for (int i = N/2; i < N; i++) {
                p[i]=1;
            }
            for (int i = 0; i < N; i++) {
                st=new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    taste[i][j]=Integer.parseInt(st.nextToken().trim());
                }
            } // 읽기 end
            min=Integer.MAX_VALUE/1000;  // 충분히 큰 수
            //로직 시작
            do {
                min=Math.min(min, calcultasted(p));
            } while (np(N-1));
            System.out.printf("#%d %d\n",t,min);
        }
    }// main

    static boolean np(int size) {
        int i=size;
        while(i>0 && p[i-1]>=p[i]) i--;
        if(i==0) return false;
        int j=size;
        while(p[i-1]>=p[j]) j--;
        int temp=p[i-1];
        p[i-1]=p[j];
        p[j]=temp;
        int k=size;
        while(i<k) {
            temp=p[i];
            p[i]=p[k];
            p[k]=temp;
            i++;
            k--;
        }
        return true;
    }

    // 선택 A, 비선택 B
    static int calcultasted(int[] select) {
        int A=0;
        int B=0;
        //Aij+Aji
        for (int i = 0; i <N; i++) {
            for (int j = i+1; j < N; j++) {
                if(select[i]!=select[j])  continue;
                else if(select[i]==1)  A+=taste[i][j]+taste[j][i];
                else if(select[i]!=1)  B+=taste[i][j]+taste[j][i];
            }
        }
        return Math.abs(A-B);
    }

}