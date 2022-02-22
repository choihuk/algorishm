import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ1260{
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