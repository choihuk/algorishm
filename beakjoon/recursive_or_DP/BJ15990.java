import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ15990{
    private static int n;
    private static int[][] memo;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        memo = new int[100001][4];
        for(int i=0; i<100001; i++){
            Arrays.fill(memo[i], -1);
        }
        while(T-- > 0){
            n = Integer.parseInt(br.readLine());
            int result = 0;
            result = DFS(n,0);
            System.out.println(result);
        }
    }
    private static int DFS(int i, int a){
        if(i<0) return 0;
        if(i==0) return 1;
        if(memo[i][a] != -1) return memo[i][a];

        int ret=0;
        if(a!=1) ret = (ret+DFS(i-1, 1))%1000000009;
        if(a!=2) ret = (ret+DFS(i-2, 2))%1000000009;
        if(a!=3) ret = (ret+DFS(i-3, 3))%1000000009;

        memo[i][a]=ret;
        return memo[i][a];
    }
}