import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ15652{
    private static int[] out;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        out = new int[M];
        DFS(N,M,0);
        System.out.println(sb.toString());
        br.close();
    }
    
    private static void DFS(int n, int m, int cnt){
        if(cnt == m){
            for(int i=0; i<m; i++){
                sb.append(out[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=n; i++){
            out[cnt] = i;
            boolean isAscending = true;
            if(cnt>0){
                if(out[cnt-1]>out[cnt]) isAscending = false;
            }
            if(isAscending){
                DFS(n,m,cnt+1);
            }
        }
    }
}