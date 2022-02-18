import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main{
    private static Map<Integer,int[]> map;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        map.put(0,new int[] {1,0});
        map.put(1,new int[] {0,1});
        for(int i=0; i<length; i++){
            int input = Integer.parseInt(br.readLine());
            for(int j=2;j<=input;j++) count(j);
            System.out.println(map.get(input)[0]+" "+map.get(input)[1]);
        }
    }
    private static void count(int input){
        if(!map.containsKey(input)){
            int zero = map.get(input-1)[0]+map.get(input-2)[0];
            int one = map.get(input-1)[1]+map.get(input-2)[1];
            map.put(input,new int[]{zero,one});
        }
    }
}
