import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10819{
    private static int N;
    private static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[8];
        
        for(int i=0; i<N; i++) arr[i] = i+1;
        
        int sum = 0;
        
        
        for(int i=0; i<N; i++) sb.append(arr[i]).append(" ");
        sb.append("\n");
        while(next()) {
            for(int i=0; i<N; i++) sb.append(arr[i]).append(" ");
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
        br.close();
    }
    private static boolean next(){
        int i = N-1;
        while(i>0 && arr[i-1]>arr[i]) i--;
        if(i<=0) return false;
        
        int j = N-1;
        while(arr[i-1]>arr[j]) j--;
        
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