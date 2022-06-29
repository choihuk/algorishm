import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ13023 {
    private static boolean visited[];
    private static ArrayList<Integer>[] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            lists[i] = new ArrayList<>();
        }
        visited = new boolean[N];
        while(M --> 0){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited,false);
            DFS(i,0);
        }
        System.out.println(0);
    }
    private static void DFS(int node, int count) {
        if(count==4){
            System.out.println(1);
            System.exit(0);
        }
        visited[node] = true;
        for (int i = 0; i < lists[node].size(); i++) {
            int nextNode = lists[node].get(i);
            if(visited[nextNode]) continue;
            DFS(nextNode,count+1);
        }
        visited[node] = false;
    }
}
