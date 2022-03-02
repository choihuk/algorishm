import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18290{
    private static int[][] map;
    private static int col;
    private static int row;
    private static int K;
    private static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    private static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[20][20];
        for(int i=0; i<row; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0; j<col; j++){
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        result = Integer.MIN_VALUE;
        DFS(0,0,new boolean[20][20]);
        System.out.println(result);
    }
    private static void DFS(int cnt, int sum, boolean[][] v){
        if(cnt==K){
            if(result < sum) result = sum;
            return;
        }
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(v[i][j]) continue;
                v[i][j] = true;
                boolean isGo = true;
                for(int k=0; k<4; k++){
                    if(check(i+dir[k][1],j+dir[k][0])){
                        if(v[i+dir[k][1]][j+dir[k][0]]) isGo = false;
                    }
                }
                if(isGo) DFS(cnt+1,sum+map[i][j],v);
                v[i][j] = false;
            }
        }
    }
    private static boolean check(int y, int x){
        if(x>=0 && x<col && y>=0 && y<row) return true;
        return false;
    }
}
