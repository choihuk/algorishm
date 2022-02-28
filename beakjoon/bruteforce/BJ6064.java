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
            int result = -1;
            int gcd = getGCD(M,N);
            gcd = (M*N)/gcd;
            int a = 0;
            for(int i=0; a<=gcd; i++){
                a = M*i + x;
                if(y == a%N){
                    result = a;
                    break;
                }
            }
            System.out.println(result);
        }
    }
     public static int getGCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return getGCD(b, a%b);
    }
}