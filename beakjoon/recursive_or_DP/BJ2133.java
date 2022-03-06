import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2133{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N%2==1){
            System.out.println("0");
        }else{
            N = N/2;
            int[] tile = new int[20];
            tile[0] = 1; tile[1] = 3;
            for(int i=2; i<=N; i++){
                for(int j=i-1; j>=0; j--){
                    if(j==i-1){
                        tile[i] += tile[j]*3;
                    }else{
                        tile[i] += tile[j]*2;
                    }
                }
            }
            System.out.println(tile[N]);
        }
        br.close();
    }
}