import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ15650{
    private static int[] out;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        out = new int[M];
        DFS(N,M,0,new boolean[N+1]);
        System.out.println(sb.toString());
        br.close();
    }
    
    private static void DFS(int n, int m, int cnt, boolean[] visited){
        if(cnt == m){
            for(int i=0; i<m; i++){
                sb.append(out[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=n; i++){
            if(visited[i]) continue;
            boolean isAscend = true;
            for(int j=i+1; j<=n; j++) if(visited[j]) isAscend = false;
            if(isAscend){
                visited[i] = true;
                out[cnt] = i;
                DFS(n,m,cnt+1,visited);
                visited[i] = false;
            }
        }
    }
}