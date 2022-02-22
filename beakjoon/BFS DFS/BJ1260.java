import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ1260{
    // DFS는 재귀를 이용하여, BFS는 큐를 이용하여 풂.
    // DFS, BFS에서 한 노드에서 갈 수 있는 노드 중 가장 작은 노드부터 방문한다는 조건이 있었기에
    // 매트릭스에서 순서대로 뽑아서 큐에 넣을 수 있었음. 좀 더 까다로운 조건이 주어진다면 조건 추가해서 큐에 넣어야 할 듯.
    
    // DFS, BFS의 핵심은 이 노드가 방문을 한 노드인지 확인하는 방법을 구현하는 것인데 
    // 만약 방문을 했다면 resultQueue에 들어갔기에 resultQueue를 확인하는 방식으로 구현함.
    // 원래라면 각 노드들이 자신이 방문되었는지 상태를 가지고 있어야 할 듯..?
    
    // 효율면에서 매트릭스를 이차원 배열로 구현하는 것이 아닌 node array를 만들고 array 안에 노드들이 갈 수 있는 다른 노드들의 포인터가 담긴 arraylist를 갖고 있는 형태로 구현하는 것이 이득임.
    private static int[][] matrix;
    private static Queue<Integer> resultD;
    private static Queue<Integer> resultB;
    private static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        matrix = new int[N+1][N+1];
        for(int i=0; i<M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            matrix[a][b] = 1; matrix[b][a] = 1;
        }
        
        resultD = new LinkedList<Integer>();
        DFS(V);
        while(resultD.peek()!=null) System.out.print(resultD.poll()+" ");
        System.out.print("\n");
        
        resultB = new LinkedList<Integer>();
        BFS(V);
        while(resultB.peek()!=null) System.out.print(resultB.poll()+" ");
    }
    private static void DFS(int v){
        resultD.add(v);
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<N+1; i++){if(matrix[v][i]==1) queue.add(i);}
        while(queue.peek()!=null){
            int nextV = queue.poll();
            if(!resultD.contains(nextV)) DFS(nextV);
        }
    }
    private static void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while(queue.peek()!=null){
            int nextV = queue.poll();
            if(!resultB.contains(nextV)) resultB.add(nextV);
            for(int i=1; i<N+1; i++){if(matrix[nextV][i]==1&&!resultB.contains(i)) queue.add(i);}
        }
        
    }
}