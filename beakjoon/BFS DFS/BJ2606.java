import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2606{
    private static List<Queue<Integer>> list;
    private static boolean[] isTravel;
    private static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int bi = Integer.parseInt(br.readLine());
        isTravel = new boolean[N+1];
        list = new ArrayList<>();
        for(int i=0; i<=N; i++){
            list.add(new LinkedList<>());
        }
        for(int i=0; i<bi; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
        }
        count = 0;
        DFS(1);
        System.out.println(count);
    }
    private static void DFS(int v){
        isTravel[v] = true;
        Queue<Integer> queue = list.get(v);
        while(queue.peek()!=null){
            int a = queue.poll();
            if(!isTravel[a]) {DFS(a);count++;}
        }
    }
}