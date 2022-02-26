import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 배열에 x와 y를 넣을 땐 matrix[y][x] 로 넣는걸 잊지말자.. 계속 헷갈리네
public class BJ2178{
    private static int[][] matrix;
    private static boolean[][] isSearch;
    private static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        matrix = new int[H][W];
        isSearch = new boolean[H][W];
        for(int i=0; i<H; i++){
            String num = br.readLine();
            for(int j=0; j<W; j++){
                matrix[i][j] = num.charAt(j)-'0';
            }
        }
        
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0,1)); isSearch[0][0] = true;
        while(!(queue.peek().x==W-1 && queue.peek().y==H-1)){
            Point p = queue.poll();
            for(int i=0; i<4; i++){
                Point newP = new Point(p.y+dir[i][1],p.x+dir[i][0],p.d+1);
                if(newP.x>=0 && newP.x<W && newP.y>=0 && newP.y<H){
                    if(matrix[newP.y][newP.x]==1&&!isSearch[newP.y][newP.x]) {
                        queue.add(newP); isSearch[newP.y][newP.x]=true;
                    }
                }
            }
        }
        System.out.println(queue.poll().d);
    }
    static class Point{
        public int y;
        public int x;
        public int d;
        Point(int y, int x, int d){
            this.y=y;
            this.x=x;
            this.d=d;
        }
    }
}