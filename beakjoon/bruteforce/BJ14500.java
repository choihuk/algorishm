import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ14500{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] paper = new int[N][M];
        for(int i=0; i<N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                paper[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        
        int result = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M-3; j++){
                int sum = paper[i][j]+paper[i][j+1]+paper[i][j+2]+paper[i][j+3];
                if(sum>result) result = sum;
            }
        }
        for(int i=0; i<N-3; i++){
            for(int j=0; j<M; j++){
                int sum = paper[i][j]+paper[i+1][j]+paper[i+2][j]+paper[i+3][j];
                if(sum>result) result = sum;
            }
        }
        for(int i=0; i<N-1; i++){
            for(int j=0; j<M-2; j++){
                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                pq.add(paper[i][j]+paper[i][j+1]+paper[i][j+2]+paper[i+1][j]);
                pq.add(paper[i][j]+paper[i][j+1]+paper[i][j+2]+paper[i+1][j+1]);
                pq.add(paper[i][j]+paper[i][j+1]+paper[i][j+2]+paper[i+1][j+2]);
                pq.add(paper[i][j]+paper[i][j+1]+paper[i+1][j+1]+paper[i+1][j+2]);
                pq.add(paper[i][j+1]+paper[i][j+2]+paper[i+1][j]+paper[i+1][j+1]);
                pq.add(paper[i][j]+paper[i+1][j]+paper[i+1][j+1]+paper[i+1][j+2]);
                pq.add(paper[i][j+1]+paper[i+1][j]+paper[i+1][j+1]+paper[i+1][j+2]);
                pq.add(paper[i][j+2]+paper[i+1][j]+paper[i+1][j+1]+paper[i+1][j+2]);
                pq.add(paper[i][j]+paper[i][j+1]+paper[i+1][j]+paper[i+1][j+1]);
                pq.add(paper[i][j+1]+paper[i][j+2]+paper[i+1][j+1]+paper[i+1][j+2]);
                int sum = pq.poll();
                if(sum>result) result = sum;
            }
        }
        for(int i=0; i<N-2; i++){
            for(int j=0; j<M-1; j++){
                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                pq.add(paper[i][j]+paper[i+1][j]+paper[i+2][j]+paper[i][j+1]);
                pq.add(paper[i][j]+paper[i+1][j]+paper[i+2][j]+paper[i+1][j+1]);
                pq.add(paper[i][j]+paper[i+1][j]+paper[i+2][j]+paper[i+2][j+1]);
                pq.add(paper[i][j]+paper[i+1][j]+paper[i+1][j+1]+paper[i+2][j+1]);
                pq.add(paper[i+1][j]+paper[i+2][j]+paper[i][j+1]+paper[i+1][j+1]);
                pq.add(paper[i][j+1]+paper[i+1][j+1]+paper[i+2][j+1]+paper[i][j]);
                pq.add(paper[i][j+1]+paper[i+1][j+1]+paper[i+2][j+1]+paper[i+1][j]);
                pq.add(paper[i][j+1]+paper[i+1][j+1]+paper[i+2][j+1]+paper[i+2][j]);
                int sum = pq.poll();
                if(sum>result) result = sum;
            }
        }
        System.out.println(result);        
    }
}