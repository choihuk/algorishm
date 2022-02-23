import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1697{
    private static int time;
    private static int K;
    private static int[] memo;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());
        time = 0;
        memo = new int[K*2];
        cal(N);
    }
    private static int cal(int n){
        int minus = Integer.MAX_VALUE;
        int plus = Integer.MAX_VALUE;
        int mul = Integer.MAX_VALUE;
        if(n>1) {
            if(memo[n-1]==0) minus = cal(n-1); memo[n-1]=minus;
            else minus = memo[n-1];
        }
        if(n<K)
        if(n<K) {
            if(memo[n*2]==0) minus = cal(n*2); memo[n*2]=minus;
            else minus = memo[n*2];
        }
        return Math.min(minus,mul);
    }
}