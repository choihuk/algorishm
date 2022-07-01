import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ13913 {
    private static Map<Integer,Integer> map;
    private static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        queue = new LinkedList<>();
        queue.add(N);
        map.put(N,-1);
        while(!queue.isEmpty()){
            int location = queue.poll();
            if(location==K){
                StringBuilder sb = new StringBuilder();
                sb.append(location).append(" ");
                int pre = map.get(location);
                int count = 0;
                while(pre != -1){
                    sb.insert(0,pre+" ");
                    pre = map.get(pre);
                    count++;
                }
                System.out.println(count);
                System.out.println(sb.toString());
                System.exit(0);
            }
            if(!map.containsKey(location-1)&&location>0){next(location,location-1);}
            if(!map.containsKey(location+1)&&location<100000){next(location,location+1);}
            if(!map.containsKey(location*2)&&location*2<=100000){next(location,location*2);}
        }
        System.out.println("error");
    }
    private static void next(int location, int next){
        queue.add(next);
        map.put(next,location);
    }
}
