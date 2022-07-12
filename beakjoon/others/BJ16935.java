import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16935 {
    private static int N;
    private static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        while(R --> 0) queue.add(Integer.parseInt(st.nextToken()));

        switch (queue.poll()) {
            case 1 : cal1(matrix); break;
            case 2 : cal2(matrix); break;
            case 3 : cal3(matrix); break;
            case 4 : cal4(matrix); break;
            case 5 : cal5(matrix); break;
            case 6 : cal6(matrix); break;
        }
    }

    private static void cal6(int[][] matrix) {

    }

    private static void cal5(int[][] matrix) {

    }

    private static void cal4(int[][] matrix) {

    }

    private static void cal3(int[][] matrix) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M / 2; i++) {
//            int x =
        }
    }

    private static void cal2(int[][] matrix) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][M - j];
                matrix[i][M - j] = temp;
            }
        }
    }

    private static void cal1(int[][] matrix) {
        for (int i = 0; i < N / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[N - i];
            matrix[N - 1] = temp;
        }
    }

}
