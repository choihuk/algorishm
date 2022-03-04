import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1248{
    private static int N;
    private static int length;
    private static char[][] input;
    private static int[] out;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        length = N*(N+1)/2;
        input = new char[11][11];
        String a = br.readLine();
        for(int i=1; i<=N; i++){
            for(int j=i; j<=N; j++){
                input[i][j] = a.charAt((i-1)*N+j);
            }
        }
        out = new int[10];
        DFS(length, N-1);
    }
    
    private static void DFS(int a, int cnt){
        if(cnt==-1){
            boolean isFind = true;
            int index = 1;
            for(int k=4; k>0; k--){
                for(int i=0; i<k; i++){
                    int sum = 0;
                    for(int j=0; j<=i; j++) sum+=out[j+4-k];
                    if(!((input[index]=='-'&&sum<0)||
                        (input[index]=='0'&&sum==0)||
                        (input[index]=='+'&&sum>0))) isFind = false;
                    index++;
                }
            }
            if(isFind){
                for(int i=0; i<N; i++){
                    System.out.print(out[i]+" ");
                }
                System.out.println();
                System.exit(0);
            }
            return;
        }
        for(int i=N; i>=cnt; i--){
            int left = -10;
            int right = 10;
            for(int j=i; j<=i; j++){
                if(input[i][j]=='+'){
                    if(cnt==j) left = 1;
                    else{
                        if(out[j]<0) left-=out[j];
                    }
                }else if(input[i][j]=='0'){
                    if(cnt==j) out[cnt] = 0;
                }else{
                    if(cnt==j) right = -1;
                    else{
                        if(out[j]>0) right-=out[j];
                    }
                }
                
            }
        }
//        if(input[a]=='+'){
//            for(int i=1; i<=10; i++){
                out[cnt] = i;
                DFS(a-(N-cnt)-1, cnt-1);
//            }
//        }else if(input[a]=='0'){
//            out[cnt] = 0;
//            DFS(a-(N-cnt)-1, cnt-1);
//        }else{
//            for(int i=-10; i<0; i++){
//                out[cnt] = i;
//                DFS(a-(N-cnt)-1, cnt-1);
//            }
//        }
        
    }
}