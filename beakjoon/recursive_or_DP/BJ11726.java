import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11726{
    // 맨 마지막에 타일을 세로로 놓는 경우와 가로로 놓는 경우를 합하면 모든 타일을 
    // 놓을 수 있는 경우의 수가 된다. 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] memo = new int[1001];
        
        memo[1] = 1;
        memo[2] = 2;
        for(int i=3; i<=n; i++){
            memo[i] = (memo[i-1] + memo[i-2])%10007;
        }
        System.out.println(memo[n]);
    }
}