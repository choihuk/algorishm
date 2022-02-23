import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1676{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int result = 0;
        for(int i=1; i<=N; i++){
            int a = i;
            while(a%5==0){result++; a=a/5;}
        }
        System.out.println(result);
        br.close();
    }
}