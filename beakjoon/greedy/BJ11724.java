import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ11724 {
    private static boolean[] visited;
    private static ArrayList<Integer>[] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N+1];
        for (int i = 0; i < N; i++) {
            lists[i+1] = new ArrayList<>();
        }
        while(M-- > 0){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }
        visited = new boolean[N+1];
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if(visited[i]) continue;
            DFS(i);
            answer++;
        }
        System.out.println(answer);
    }

    private static void DFS(int node) {
        visited[node] = true;
        for(int i=0; i<lists[node].size(); i++){
            int nextNode = lists[node].get(i);
            if(visited[nextNode]) continue;
            DFS(nextNode);
        }
    }
}
