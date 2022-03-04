import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10972{
    private static int N;
    private static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[10000];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        if(!next()) System.out.println("-1");
        else{
            for(int i=0; i<N; i++) sb.append(arr[i]).append(" ");
            System.out.println(sb.toString());
        }
        br.close();
    }
    private static boolean next(){
        int i = N-1;
        while(i>0 && arr[i-1] > arr[i]) i--; // 순열의 마지막 수를 포함하는 가장 긴 감소 수열 찾기
        if(i<=0) return false;  // 만약 없으면 해당 순열은 내림차순임
        
        int j = N-1;
        while(arr[i-1] > arr[j]) j--; // j>=i 이면서 A[j]>A[i-1]을 만족하는 가장 큰 j 찾기
        
        int temp = arr[j];         // A[i-1]과 A[j]를 swap한다.
        arr[j] =arr[i-1];
        arr[i-1] = temp;   
        
        j = N-1;
        while(i<j){    //A[i]부터 순열을 뒤집는다.
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}