import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1931{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        List<Conference> list = new ArrayList<>();
        while(number-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Conference(s,e));
        }
        Collections.sort(list);
        
        int count = 0;
        int endTime = 0;
        for(Conference c : list){
            if(endTime<=c.startT) {count++; endTime = c.endT;}
        }
        System.out.println(count);
    }
    
    static class Conference implements Comparable<Conference>{
        public int startT;
        public int endT;
        Conference(int s, int e){
            this.startT = s;
            this.endT = e;
        }
        @Override
        public int compareTo(Conference c){
            if(this.endT>c.endT) return 1;
            else if(this.endT==c.endT) {
                if(this.startT > c.startT) return 1;
            }
            return -1;
        }
    }
}