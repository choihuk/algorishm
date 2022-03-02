import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ14501{
    private static int N;
    private static int[] day;
    private static int[] money;
    private static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        day = new int[20];
        money = new int[20];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            money[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(DFS(1));
        br.close();
    }
    private static int DFS(int d){
        if(d>N) return 0;
        if(d+day[d]-1>N) return DFS(d+1);
        return Math.max(DFS(d+1),DFS(d+day[d])+money[d]);
    }
}