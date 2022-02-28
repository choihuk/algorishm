import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 그래프를 만드는 방법은 list에 미리 정의된 배열을 넣거나 내가 정의한 Node를 넣을 수 있다.
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
            list.get(b).add(a);
        }
        count = 0;
        DFS(1);
        System.out.println(count-1);
    }
    
    private static void DFS(int v){
        count++;
        isTravel[v] = true;
        Queue<Integer> queue = list.get(v);
        while(queue.peek()!=null){
            int a = queue.poll();
            if(!isTravel[a]) {DFS(a);}
        }
    }
}