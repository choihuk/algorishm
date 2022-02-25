import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ9019{
    private static String B;
    private static HashSet<String> set;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            B = st.nextToken();
            A = addZ(A);
            B = addZ(B);
            set = new HashSet<>();
            
            String result = cal(A);
            System.out.println(result);
        }
        
    }
    
    static class Box{
        public String number;
        public String result;
        Box(String number, String result){
            this.number=number;
            this.result=result;
        }
    }
    
    private static String cal(String a){
        Queue<Box> queue = new LinkedList<>();
        queue.add(new Box(a,""));
        
        while(queue.peek()!=null){
            Box b = queue.poll();
            if(b.number.equals(B)) return b.result;
            String d = D(b.number); if(!set.contains(d)){queue.add(new Box(d,b.result+"D")); set.add(d);}
            String s = S(b.number); if(!set.contains(s)){queue.add(new Box(s,b.result+"S")); set.add(s);}
            String l = L(b.number); if(!set.contains(l)){queue.add(new Box(l,b.result+"L")); set.add(l);}
            String r = R(b.number); if(!set.contains(r)){queue.add(new Box(r,b.result+"R")); set.add(r);}
        }
        return null;
    }
    private static String D(String a){
        int num = Integer.parseInt(a)*2;
        if(num>9999) num = 100000%num;
        return addZ(Integer.toString(num));
    }
    private static String S(String a){
        int num = Integer.parseInt(a);
        if(num==0) num=9999;
        else num--;
        return addZ(Integer.toString(num));
    }
    private static String L(String a){
        String temp = a.substring(0,1);
        a = a.substring(1,4);
        a += temp;
        return a;
    }
    private static String R(String a){
        String temp = a.substring(3,4);
        a = a.substring(0,3);
        a = temp + a;
        return a;
    }
    private static String addZ(String a){
        while(a.length()<4){a = "0" + a;}
        return a;
    }
}