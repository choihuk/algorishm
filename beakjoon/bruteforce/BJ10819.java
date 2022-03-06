import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ10819{
    private static int N;
    private static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) list.add(Integer.parseInt(st.nextToken()));
        Collections.sort(list);
        arr = new int[8];
        for(int i=0; i<N; i++) arr[i] = list.get(i);
        
        int result = 0;
        int sum = 0;
        do{
            sum = 0;
            for(int i=0; i<N-1; i++) sum+=Math.abs(arr[i]-arr[i+1]);
            if(result<sum) result = sum;
        }while(next());
        
        System.out.println(result);
        br.close();
    }
    
    private static boolean next(){
        int i = N-1;
        while(i>0 && arr[i-1]>=arr[i]) i--;
        if(i<=0) return false;
        
        int j = N-1;
        while(arr[i-1]>=arr[j]) j--;
        
        int temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;
        
        j = N-1;
        while(i<j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
        return true;
    }
}