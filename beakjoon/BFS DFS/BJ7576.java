import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7576 {
    private static int M;
    private static int N;
    private static int[] dirx = {0, 1, 0, -1};
    private static int[] diry = {1, 0, -1, 0};

    private static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(matrix[i][j]==1) queue.add(new int[]{j, i});
            }
        }
        int count = -1;
        Queue<int[]> tempQ = new LinkedList<>();
        while (true) {
            if(queue.isEmpty()){
                count++;
                if(tempQ.isEmpty()) break;
                queue.addAll(tempQ);
                tempQ.clear();
            }
            int[] node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node[0] + dirx[i];
                int ny = node[1] + diry[i];
                if(outOfArray(ny,nx) && matrix[ny][nx]==0){
                    tempQ.add(new int[]{nx, ny});
                    matrix[ny][nx] = 1;
                }
            }
        }
        boolean isRipe = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(matrix[i][j]==0) isRipe = false;
            }
        }
        System.out.println(isRipe ? count : -1);
    }

    private static boolean outOfArray(int y, int x) {
        return x>=0 && x<M && y>=0 && y<N;
    }
}
