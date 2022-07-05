import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1707 {
    private static List<Integer>[] lists;
    private static int[] visited;
    private static boolean[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        result = new boolean[K];
        Arrays.fill(result,true);

        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            lists = new ArrayList[V + 1];
            for (int i = 0; i < V; i++) {
                lists[i + 1] = new ArrayList<>();
            }
            for (int i = 0; i < E; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());
                lists[a].add(b);
                lists[b].add(a);
            }
            visited = new int[V + 1];
            Arrays.fill(visited, -1);

            for (int i = 0; i < V; i++) {
                if(visited[i+1]==-1) DFS(i+1, true, k);
            }
        }
        for (boolean b : result) {
            System.out.println(b ? "YES" : "NO");
        }
    }

    private static void DFS(int node, boolean b, int K) {
        visited[node] = b ? 0 : 1;
        for (int i = 0; i < lists[node].size(); i++) {
            int nextNode = lists[node].get(i);
            if(visited[nextNode]==-1) DFS(nextNode,!b,K);
            else {
                if((b&&visited[nextNode]==0)||(!b&&visited[nextNode]==1)) result[K] = false;
            }
        }
    }
}
