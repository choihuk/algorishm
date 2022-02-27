import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 문제의 특성을 이용해서 x2, y2를 잡는게 아니라 size만 인자로 넣어 구현하는게
// 더 깔끔했을듯. 2차원 배열 값 넣고 빼는거 신경 잘쓰자..
public class BJ1992{
    private static int[][] matrix;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        for(int i=0; i<N; i++){
            String a =br.readLine();
            for(int j=0; j<N; j++){
                matrix[i][j] = a.charAt(j)-'0';
            }
        }
        System.out.println(cal(0,0,N-1,N-1));
    }
    
    private static String cal(int x1, int y1, int x2, int y2){
        StringBuilder a = new StringBuilder();
        int xm = (x1+x2)/2; int ym = (y1+y2)/2;
        if(x1==x2&&y1==y2) a.append(fill(x1, y1, x2, y2));
        else{
            String one = fill(x1,y1,xm,ym);
            String two = fill(xm+1,y1,x2,ym);
            String three = fill(x1,ym+1,xm,y2);
            String four = fill(xm+1,ym+1,x2,y2);
            if(one.equals(two)&&two.equals(three)&&three.equals(four)&&!four.equals("-1")){
                a.append(one);                
            }else{
                a.append("(");
                if(one.equals("-1")) a.append(cal(x1,y1,xm,ym)); else a.append(one);
                if(two.equals("-1")) a.append(cal(xm+1,y1,x2,ym)); else a.append(two);
                if(three.equals("-1")) a.append(cal(x1,ym+1,xm,y2)); else a.append(three);
                if(four.equals("-1")) a.append(cal(xm+1,ym+1,x2,y2)); else a.append(four);
                a.append(")");
            }
        }
        return a.toString();
    }
    
    private static String fill(int x1, int y1, int x2, int y2){
        boolean isZero = false;
        boolean isOne = false;
        for(int i=y1; i<=y2; i++){
            for(int j=x1; j<=x2; j++){
                if(matrix[i][j]==0) isZero = true;
                else if(matrix[i][j]==1) isOne = true;
            }
        }
        if(isZero&&isOne) return "-1";
        else if(!isZero) return "1";
        else return "0";
    }
}