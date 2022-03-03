import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2529{
    private static int k;
    private static char[] arr;
    private static int[] input;
    private static boolean[] visited;
    private static long max;
    private static long min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr = new char[9];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            arr[i] = st.nextToken().charAt(0);
        }
        input = new int[10];
        visited = new boolean[10];
        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;
        
        DFS(0);
        String minValue = Long.toString(min);
        for(int i=2; i<=k; i++){
            if(minValue.length()<=i) minValue = "0"+ minValue;
        }
        System.out.println(max + "\n" + minValue);
    }
    private static void DFS(int cnt){
        if(cnt==k+1){
            boolean isMached = true;
            for(int i=0; i<k; i++){
                if(arr[i]=='<'){
                    if(input[i]>input[i+1]) isMached = false;
                }else{
                    if(input[i]<input[i+1]) isMached = false;
                }
            }
            if(isMached){
                long a = 0L;
                for(int i=0; i<=k; i++) a += (Math.pow(10,k-i)*input[i]);
                if(a>max) max = a;
                if(a<min) min = a;
            }
            return;
        }
        for(int i=0; i<=9; i++){
            if(visited[i]) continue;
            visited[i] = true;
            input[cnt] = i;
            DFS(cnt+1);
            visited[i] = false;
        }
    }
}