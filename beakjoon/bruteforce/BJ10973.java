import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10973{
    private static int[] arr;
    private static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[10000];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        if(solve()){
            for(int i=0; i<N; i++) sb.append(arr[i]).append(" ");
        }else sb.append("-1");
        System.out.println(sb.toString());
        br.close();
    }
    
    private static boolean solve(){
        int i = N-1;
        while(i>0 && arr[i]>arr[i-1]) i--;  // 마지막 값을 포함한 최대의 오름차순 배열 구하기
        if(i<=0) return false;
        
        int j = N-1; 
        while(arr[i-1]<arr[j]) j--; // arr[i-1]보다 작은 arr[j] 중 J의 최댓값 구하기
        
        int temp = arr[j];  // i-1과 j swap
        arr[j] = arr[i-1];
        arr[i-1] = temp;
        
        j = N-1;    //i 이상의 배열 reverse
        while(i<j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
        return true;
    }
}