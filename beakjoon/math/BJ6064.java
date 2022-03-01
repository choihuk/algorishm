import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ6064{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        while(A-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int result = 0;
            int a = 0;
            int b = 0;
            while(M*b+x < M*N){
                if(a < y-x){
                    a += M; b++;
                }else if(a > y-x){
                    a -= N;
                }else{
                    break;
                }
            }
            if(a!=y-x) result = -1;
            else result = M*b+x;
            System.out.println(result);
        }
    }
}