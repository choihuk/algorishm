import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1927{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        for(int i=0; i<N; i++){
            if(list.get(i)==0){
                if(pq.peek()==null) result.add(0);
                else result.add(pq.poll());
            }else{
                pq.add(list.get(i));
            }
        }
        for(int r : result){
            System.out.println(r);
        }
        br.close();
    }
}