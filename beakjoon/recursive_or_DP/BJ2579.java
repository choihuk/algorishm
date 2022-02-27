import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2579{
    private static List<Integer> list;
    private static int[] memo;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        memo = new int[N+2]; memo[0] = -1; memo[1] = -1;
        list = new ArrayList<>();
        for(int i=0; i<N; i++){list.add(Integer.parseInt(br.readLine()));}
        System.out.println(up(N+1,true));
    }
    private static int up(int n, boolean avail){
        if(n<2) return 0;
        int a = 0;
        int b = 0;
        if(memo[n-1]==0) {a = up(n-1,false); memo[n-1] = a;}
        else a = memo[a-1];
        if(memo[n-2]==0) {b = up(n-2,true); memo[n-2] = b;}
        else b = memo[a-2];
        if(avail){
            return Math.max(a,b)+list.get(n-2);
        }
        return b+list.get(n-2);
    }
}