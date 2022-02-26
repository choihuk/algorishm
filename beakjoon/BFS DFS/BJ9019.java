import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Integer.parseInt나 Integer.toString을 남발하면 계산속도가 기하급수적으로 커진다는 것을 몸소 체험한 문제... String형 말고 int형으로 사용해도 풀 수 있는 문제여따..
public class BJ9019{
    private static int B;
    private static HashSet<Integer> set;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            set = new HashSet<>();
            
            String result = cal(A);
            System.out.println(result);
        }
    }
    
    static class Box{
        public int number;
        public String result;
        Box(int number, String result){
            this.number=number;
            this.result=result;
        }
    }
    
    private static String cal(int a){
        Queue<Box> queue = new LinkedList<>();
        queue.add(new Box(a,""));
        
        while(queue.peek()!=null){
            Box b = queue.poll();
            if(b.number==B) return b.result;
            int d = D(b.number); if(!set.contains(d)){queue.add(new Box(d,b.result+"D")); set.add(d);}
            int s = S(b.number); if(!set.contains(s)){queue.add(new Box(s,b.result+"S")); set.add(s);}
            int l = L(b.number); if(!set.contains(l)){queue.add(new Box(l,b.result+"L")); set.add(l);}
            int r = R(b.number); if(!set.contains(r)){queue.add(new Box(r,b.result+"R")); set.add(r);}
        }
        return null;
    }
    private static int D(int a){
        return (a*2)%10000;
    }
    private static int S(int a){
        return a==0 ? 9999 : --a;
    }
    private static int L(int a){
        return a%1000*10 + a/1000;
    }
    private static int R(int a){
        return a%10*1000 + a/10;
    }
}