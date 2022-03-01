import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1748{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long result = 0;
        boolean stop = false;
        for(int i=1; !stop; i++){
            int a = N/pow(i);
            if(a!=0){
                result += (pow(i)-pow(i-1))*i;
            }else{
                result += (N-pow(i-1))*i+i;
                stop = true;
            }
        }
        System.out.println(result);
    }
    private static int pow(int i){
        return (int)Math.pow(10,i);
    }
}