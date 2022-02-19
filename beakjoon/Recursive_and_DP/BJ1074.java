import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1074{
    // 재귀 문제인데 패턴 파악해서 걍 반복문으로 풂.
    // ㄴ 사분면으로 쪼개서 현재 위치를 기준으로 2의 n제곱과 비슷한 꼴로 더해가는 과정을 반복
    // 큰 문제의 해답이 작은 문제안에 있긴 해서 재귀로 풀 순 있지만 중복호출은 발생하지 않으니 DP는 아닌듯.
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int[] cycleR = new int[N];
        int[] cycleC = new int[N];
        for(int i=N-1; i>=0; i--){
            if(r-pow(2,i)>=0) {r -= pow(2,i);cycleR[i]=pow(2,2*i)*2;}
            if(c-pow(2,i)>=0) {c -= pow(2,i);cycleC[i]=pow(2,2*i);}
        }
        int result = 0;
        for(int i=N-1; i>=0; i--){
            result+=cycleR[i]; result+=cycleC[i];
        }
        System.out.println(result);
    }
    public static int pow(int a, int b){
        return (int)Math.pow(a,b);
    }
}