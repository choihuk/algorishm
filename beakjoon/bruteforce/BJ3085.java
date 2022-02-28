import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ3085{
    private static int N;
    private static String[][] box;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        box = new String[N][N];
        for(int i=0; i<N; i++){
            String a = br.readLine();
            for(int j=0; j<N; j++){
                box[i][j] = a.substring(j,j+1);
            }
        }
        int result = max();
        for(int i=0; i<N; i++){
            for(int j=0; j<N-1; j++){
                String temp = box[i][j];
                box[i][j] = box[i][j+1];
                box[i][j+1] = temp;
                int max = max();
                if(result < max) result = max;
                box[i][j+1] = box[i][j];
                box[i][j] = temp;
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N-1; j++){
                String temp = box[j][i];
                box[j][i] = box[j+1][i];
                box[j+1][i] = temp;
                int max = max();
                if(result < max) result = max;
                box[j+1][i] = box[j][i];
                box[j][i] = temp;
            }
        }
        System.out.println(result);
    }
    
    private static int max(){
        int result = 0;
        for(int i=0; i<N; i++){
            int a = 1;
            for(int j=0; j<N-1; j++){
                if(box[i][j].equals(box[i][j+1])) a++;
                else {
                    if(a>result) result=a;
                    a = 1;
                }
                if(a>result) result=a;
            }
        }
        for(int i=0; i<N; i++){
            int a = 1;
            for(int j=0; j<N-1; j++){
                if(box[j][i].equals(box[j+1][i])) a++;
                else {
                    if(a>result) result=a;
                    a = 1;
                }
                if(a>result) result=a;
            }
        }
        return result;
    }
}