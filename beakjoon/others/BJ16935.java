import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16935 {
    private static int N;
    private static int M;
    private static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        while(R --> 0) queue.add(Integer.parseInt(st.nextToken()));

        while (!queue.isEmpty()) {
            switch (queue.poll()) {
                case 1 : cal1(); break;
                case 2 : cal2(); break;
                case 3 : cal3(); break;
                case 4 : cal4(); break;
                case 5 : cal5(); break;
                case 6 : cal6(); break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void cal6() {
        int[][] n = new int[N][M];
        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                n[i][j] = matrix[i][M / 2 + j];
                n[i][M / 2 + j] = matrix[N / 2 + i][M / 2 + j];
                n[N / 2 + i][M / 2 + j] = matrix[N / 2 + i][j];
                n[N / 2 + i][j] = matrix[i][j];
            }
        }
        matrix = n;
    }

    private static void cal5() {
        int[][] n = new int[N][M];
        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                n[i][j] = matrix[N / 2 + i][j];
                n[i][M / 2 + j] = matrix[i][j];
                n[N / 2 + i][M / 2 + j] = matrix[i][M / 2 + j];
                n[N / 2 + i][j] = matrix[N / 2 + i][M / 2 + j];
            }
        }
        matrix = n;
    }

    private static void cal4() {
        int[][] n = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                n[i][j] = matrix[j][M-i-1];
            }
        }
        int temp = M;
        M = N;
        N = temp;
        matrix = n;
    }

    private static void cal3() {
        int[][] n = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                n[i][j] = matrix[N-j-1][i];
            }
        }
        int temp = M;
        M = N;
        N = temp;
        matrix = n;
    }

    private static void cal2() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][M - j - 1];
                matrix[i][M - j - 1] = temp;
            }
        }
    }

    private static void cal1() {
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[N - i - 1][j];
                matrix[N - i - 1][j] = temp;
            }
        }
    }

}
