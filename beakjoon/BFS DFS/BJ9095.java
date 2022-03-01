import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9095{
    private static int n;
    private static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            n = Integer.parseInt(br.readLine());
            count = 0;
            DFS(1);
            DFS(2);
            DFS(3);
            System.out.println(count);
        }
    }
    private static void DFS(int i){
        if(i==n) count++;
        if(i+1<=n) DFS(i+1);
        if(i+2<=n) DFS(i+2);
        if(i+3<=n) DFS(i+3);
    }
}