import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1780{
    private static int[][] matrix;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) matrix[i][j] = Integer.parseInt(st.nextToken());
        }
        
        int[] result = cut(0,N-1,0,N-1);
        for(int r : result) System.out.print(r+" ");
    }
    private static int[] cut(int cs, int ce, int rs, int re){
        int[] result = new int[3];
        boolean[] isCut = new boolean[3];
        for(int i=cs; i<=ce; i++){
            for(int j=rs; j<=re; j++){
                if(matrix[i][j] != -1) isCut[0] = true;
                if(matrix[i][j] != 0) isCut[1] = true;
                if(matrix[i][j] != 1) isCut[2] = true;
            }
        }
        if(isCut[0]&&isCut[1]&&isCut[2]){
            int num = (ce-cs+1)/3;
            for(int i=cs; i<=ce; i+=num){
                for(int j=rs; j<=re; j+=num){
                    int[] temp = cut(i,i+num-1,j,j+num-1);
                    for(int k=0; k<=2; k++) result[k]+=temp[k];
                }
            }
        }else{
            if(!isCut[0]) result[0]++;
            else if(!isCut[1]) result[1]++;
            else if(!isCut[2]) result[2]++;
            return result;
        }
        return result;
    }
}