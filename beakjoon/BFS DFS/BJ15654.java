import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ15654{
    private static StringBuilder sb;
    private static List<Integer> list;
    private static int[] out;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        list.add(-1);
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st2.nextToken()));
        }
        Collections.sort(list);
        out = new int[M];
        
        DFS(N,M,0,new boolean[N+1]);
        System.out.println(sb.toString());
        br.close();
    }
    private static void DFS(int n, int m, int cnt, boolean[] visited){
        if(cnt==m){
            for(int i=0; i<m; i++){
                sb.append(out[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            out[cnt] = list.get(i);
            DFS(n,m,cnt+1,visited);
            visited[i] = false;
        }
    }
}