package 박희범.week11;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1010_hb {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int[][] mul = new int[30][30];
        for(int i = 0; i < 30; i++){
            mul[i][i] = 1;
        }
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            bw.write( recur(n, k, mul)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static int recur(int n, int k, int[][] mul){
        if(mul[n][k] != 0)
            return mul[n][k];
        if(n - k == 0)
            return 1;
        if(k == 0)
            return 1;
        return mul[n][k] = recur(n - 1, k, mul) * n / recur(n, k - 1, mul) * k;
    }
}
