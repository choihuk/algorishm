import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2309{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] n = new int[9];
        for(int i=0; i<9; i++){
            n[i] = Integer.parseInt(br.readLine());
        }
        List<Integer> list = cal(n);
        Collections.sort(list);
        for(int l : list) System.out.println(l);
    }
    
    private static List<Integer> cal(int[] n){
        List<Integer> list;
        for(int i=0; i<9; i++){
            for(int j=i+1; j<9; j++){
                list = new ArrayList<>();
                for(int k=0; k<9; k++){
                    if(k!=i&&k!=j) list.add(n[k]);
                }
                int result = 0;
                for(int l : list) result+=l;
                if(result==100) return list;
            }
        }
        return null;
    }
}