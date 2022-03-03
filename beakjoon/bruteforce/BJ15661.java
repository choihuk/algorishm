import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15661{
    private static int[][] map;
    private static int min;
    private static boolean[] select;
    private static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[21][21];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Integer.MAX_VALUE;
        select = new boolean[21];
        
        DFS(0,0);
        System.out.println(min);
        br.close();
    }
    private static void DFS(int a, int cnt){
        if(cnt>=1){
            int start = 0;
            int link = 0;
            for(int i=1; i<=N; i++){
                if(select[i]){
                    for(int j=i+1; j<=N; j++){
                        if(select[j]) start += map[i][j] + map[j][i];
                    }
                }else{
                    for(int j=i+1; j<=N; j++){
                        if(!select[j]) link += map[i][j] + map[j][i];
                    }
                }
            }
            if(min>Math.abs(start-link)) min = Math.abs(start-link);
        }
        
        for(int i=a+1; i<=N; i++){
            select[i] = true;
            DFS(i,cnt+1);
            select[i] = false;
        }
    }
}