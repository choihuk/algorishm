import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1248{
    private static int N;
    private static char[][] input;
    private static int[] out;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new char[11][11];
        String a = br.readLine();
        int add = 0;
        for(int i=1; i<=N; i++){
            for(int j=i; j<=N; j++){
                input[i][j] = a.charAt(add++);
            }
        }
        out = new int[11];
        DFS(1);
    }
    
    private static void DFS(int cnt){
        if(cnt==N+1){
            for(int i=1; i<=N; i++){
                System.out.print(out[i]+" ");
            }
            System.exit(0);
            return;
        }
        for(int i=-10; i<=10; i++){
            out[cnt] = i;
            if(check(cnt)) DFS(cnt+1);
        }
    }
    
    private static boolean check(int index){
        for(int i=1; i<=index; i++){
            int sum = 0;
            for(int j=i; j>0; j--){
                sum+=out[j];
                if(input[j][i] != (sum==0 ? '0' : (sum>0 ? '+' : '-'))){
                    return false;
                }
            }
        }
        return true;
    }
}