import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1463{
    private static int[] memo;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        memo = new int[N];
        int result = cal(N);
        System.out.print(result);        
    }
    public static int cal(int n){
        if(n==1) return 0;
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;
        if(n%3==0) {
            if(memo[n/3]==0) {a = cal(n/3); memo[n/3] = a;}
            else a = memo[n/3];
        }
        if(n%2==0) {
            if(memo[n/2]==0) {b = cal(n/2); memo[n/2] = b;}
            else b = memo[n/2];
        }
        if(memo[n-1]==0) {c = cal(n-1); memo[n-1] = c;}
        else c = memo[n-1];
        return Math.min(a,Math.min(b,c))+1;
    }
}