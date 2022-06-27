import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
// HashSet에 int array를 넣으려 했으나 set.remove시 equals 메소드를 통해
// 같은 배열인지 확인하는 작업이 불가능했기에 List<Integer>를 사용하여 
// List의 Override된 equals를 활용하여 구현함. 
public class BJ1012 {
    private static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int insertCount = Integer.parseInt(br.readLine());
        for(int i=0; i<insertCount; i++){
            HashSet<List<Integer>> set = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            for(int j=0; j<k; j++){
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());
                List list = new ArrayList<Integer>();
                list.add(a); list.add(b);
                set.add(list);
            }
            int count = 0;
             while(!set.isEmpty()){
                Queue<List<Integer>> queue = new LinkedList<>();
                Iterator<List<Integer>> it = set.iterator();
                queue.add(it.next());
                set.remove(queue.peek());
                while(queue.peek()!=null){
                    List<Integer> a = queue.poll();
                    for(int l=0;l<4;l++){
                        List list = new ArrayList<Integer>();
                        list.add(a.get(0)+dir[l][0]);
                        list.add(a.get(1)+dir[l][1]);
                        if(set.remove(list)){queue.add(list);}
                    }
                }
                count++;
            }
            System.out.println(count);
        }
    }
}
