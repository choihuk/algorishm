import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ10974{
    private static int N;
    private static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) list.add(Integer.parseInt(st.nextToken()));
        Collections.sort(list);
        arr = new int[8];
        for(int i=0; i<N; i++) arr[i] = list.get(i);
        
        int result = 0;
        Deque<Integer> queue = new LinkedList<>();
        boolean di = true;
        for(int i=0; i<N/2; i++){
            if(di){
                queue.addFirst(arr[i]);
                queue.addLast(arr[N-1-i]);
                di = false;
            }else{
                queue.addFirst(arr[N-1-i]);
                queue.addLast(arr[i]);
                di = true;
            }
        }
        // 홀수일 때
        for(int i=0; i<N; i++) System.out.print(queue.poll()+" ");
        // System.out.println(result);
        br.close();
    }
    
}