import java.util.*;
class Solution {
    private int[] dirx = {1,0,-1,0};
    private int[] diry = {0,1,0,-1};
    private boolean[][] visited;
    private int m;
    private int n;
    private int numberOfArea;
    private int maxSizeOfOneArea;
    
    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        this.m=m; this.n=n;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j]!=0&&!visited[i][j]){
                    BFS(i,j,picture,picture[i][j]);
                    numberOfArea++;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    private void BFS(int y, int x, int[][] picture, int num){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y)); visited[y][x] = true;
        int count = 0;
        while(!queue.isEmpty()){
            count++;
            Point point = queue.poll();
            for(int i=0; i<4; i++){
                int newx = point.x+dirx[i], newy = point.y+diry[i];
                if(isOutOfArray(newy,newx)){
                    if(picture[newy][newx]==num&&!visited[newy][newx]){
                        queue.add(new Point(newx,newy));
                        visited[newy][newx] = true;
                    }
                }
            }
        }
        if(count>maxSizeOfOneArea) maxSizeOfOneArea = count;
    }
    private boolean isOutOfArray(int y, int x){
        if(y<0||y>=m||x<0||x>=n) return false;
        return true;
    }
    private class Point{
        public int x;
        public int y;
        Point(int x, int y){this.x=x; this.y=y;}
    }
}