import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BJ2667 {
    private static int[] dirx = {0, 1, 0, -1};
    private static int[] diry = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] matrix = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            char[] ca = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                matrix[i][j] = (ca[j]-'0')==1;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(matrix[i][j]){
                    int count = 0;
                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(i,j));
                    while (!queue.isEmpty()) {
                        count++;
                        Point p = queue.poll();
                        matrix[p.y][p.x] = false;
                        for (int k = 0; k < 4; k++) {
                            int nx = p.x + dirx[k];
                            int ny = p.y + diry[k];
                            if(outOfArray(ny,nx,N)&&matrix[ny][nx]) {
                                queue.add(new Point(ny, nx));
                                matrix[ny][nx] = false;
                            }
                        }
                    }
                    result.add(count);
                }
            }
        }
        System.out.println(result.size());
        result.stream().sorted().forEach(System.out::println);
    }

    private static boolean outOfArray(int y, int x, int N) {
        return y>=0 && y<N && x>=0 && x<N;
    }
    private static class Point{
        public int x;
        public int y;

        Point(int y, int x) {
            this.x = x; this.y = y;
        }
    }
}
