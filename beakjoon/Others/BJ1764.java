import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1764{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> setN = new HashSet<>();
        HashSet<String> setM = new HashSet<>();
        List<String> result = new ArrayList<>();
        for(int i=0; i<N; i++) setN.add(br.readLine());
        for(int i=0; i<M; i++) setM.add(br.readLine());
        
        Iterator<String> it = setN.iterator();
        while(it.hasNext()){
            String a = it.next();
            if(setM.contains(a)) result.add(a);
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(String s : result){
            System.out.println(s);
        }
    }
}