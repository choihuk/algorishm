import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 맨 처음은 DP로 접근하려 했으나 DP는 DFS의 성격을 지니고 있기에 이 문제와는 맞지 않았다...
// BFS로 풀 경우 중복 호출이 일어나 메모리 초과가 발생했다. set을 통해 한 번 호출했었던 
// 값일 경우 queue에 추가하지 않았다.

public class BJ1697{
    private static int K;
    private static HashSet<Integer> set;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());
        set = new HashSet<>();
        
        System.out.print(cal(N));
    }
    private static int cal(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n); set.add(n);
        boolean isSearch = false;
        int count = 0;
        for(int i=0; !isSearch ;i++){
            Queue<Integer> q = new LinkedList<>();
            while(queue.peek()!=null){
                int a = queue.poll();
                if(a==K) return i;
                if(!set.contains(a-1)&&a>0) {q.add(a-1); set.add(a-1);}
                if(!set.contains(a+1)&&a<K) {q.add(a+1); set.add(a+1);}
                if(!set.contains(a*2)&&a<K) {q.add(a*2); set.add(a*2);}
            }
            queue.addAll(q);
        }
        return 0;
    }
}