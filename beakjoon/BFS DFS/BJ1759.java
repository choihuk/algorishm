import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1759{
    private static List<String> list;
    private static String[] out;
    private static StringBuilder sb;
    private static int L;
    private static int C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        for(int i=0; i<C; i++){
            list.add(st2.nextToken());
        }
        Collections.sort(list);
        out = new String[15];
        
        DFS(0);
        System.out.println(sb.toString());
        br.close();
    }
    private static void DFS(int cnt){
        if(cnt==L){
            int a = 0;
            int b = 0;
            for(int i=0; i<L; i++){
                if(out[i].equals("a")||out[i].equals("e")||out[i].equals("i")
              ||out[i].equals("o")||out[i].equals("u")){
                    a++;
                }else{
                    b++;
                }
            }
            if(a>=1&&b>=2){
                for(int i=0; i<L; i++) sb.append(out[i]);
                sb.append("\n"); 
            }
            return;
        }
        for(int i=0; i<C; i++){
            if(cnt>0){
                if(list.indexOf(out[cnt-1])>=i) continue;
            }
            out[cnt] = list.get(i);
            DFS(cnt+1);
        }
    }
}