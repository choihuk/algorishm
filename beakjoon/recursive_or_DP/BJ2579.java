import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 나는 top down 방식으로 재귀를 활용하여 풀었다. 근데 bottom up 방식으로도 풀 수 있었다.
        //bottom up 방식ㄱ
        // dp[1] = stair[1];
        // if(N>=2){dp[2] = stair[1] + stair[2];
        // for(int i=3;i<=N;i++){
        //     dp[i] = Math.max(dp[i-2],dp[i-3] + stair[i-1]) + stair[i];
        // }

// 근데 굳이 재귀로 구현하지 말고 처음부터 bottom up으로 생각해서 푸는 것도 방법이 될 듯? - 이게 맞을듯

public class BJ2579{
    private static List<Integer> list;
    private static int[][] memo;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        memo = new int[N-1][2];
        list = new ArrayList<>();
        for(int i=0; i<N; i++){list.add(Integer.parseInt(br.readLine()));}
        
        System.out.println(up(N-1,true));
    }
    private static int up(int n, boolean avail){
        if(n<0) return 0;
        else if(n==0){
            return list.get(0);
        }else if(n==1){
            if(avail) return list.get(0)+list.get(1);
            else return list.get(1);
        }
        
        int a = 0;
        int b = 0;
        if(memo[n-1][0]==0) {a = up(n-1,false); memo[n-1][0] = a;}
        else a = memo[n-1][0];
        if(memo[n-2][1]==0) {b = up(n-2,true); memo[n-2][1] = b;}
        else b = memo[n-2][1];
        
        if(avail){
            return Math.max(a,b)+list.get(n);
        }
        return b+list.get(n);
    }
}