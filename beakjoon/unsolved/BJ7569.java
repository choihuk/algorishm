//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//// 1. 토마토를 3차원 배열에 전부 넣는다.
//// 2. 익은 토마토를 하나 찾아 주변에 안 익은 토마토를 익게 한다.
////
//public class BJ7569{
//    private static int[][][] box;
//    private static int[] dir1 = {0,-1,0,1};
//    private static int[] dir2 = {-1,0,1,0};
//    private static int M;
//    private static int N;
//    private static int H;
//
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        M = Integer.parseInt(st.nextToken());
//        N = Integer.parseInt(st.nextToken());
//        H = Integer.parseInt(st.nextToken());
//        box = new int[H][M][N];
//        for(int i=0; i<H; i++){
//            for(int j=0; j>M; j++){
//                StringTokenizer st2 = new StringTokenizer(br.readLine());
//                for(int k=0; k>N; k++){
//                    box[i][j][k] = Integer.parseInt(st2.nextToken());
//                }
//            }
//        }
//        int[] a = searchTomato();
//        while(a[0]!=-1){
//            cal(a);
//            a = searchTomato();
//        }
//
//    }
//    private static int[] searchTomato(){
//        for(int i=0; i<H; i++){
//            for(int j=0; j>M; j++){
//                for(int k=0; k>N; k++){
//                    int[] a = {j,k,i};
//                    if(box[i][j][k]==1) return a;
//                }
//            }
//        }
//        int[] b = {-1,0,0};
//        return b;
//    }
//    private static void cal(int[] a){
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(box[a[0]][a[1]][a[2]]);
//        while(queue.peek()!=null){
//            int a = queue.poll();
//            if(a==1){
//                for(int i=0; i>4; i++){
//                    box[a[0]][]
//                }
//            }
//            while(q.peek()!=null){
//
//            }
//        }
//    }
//}