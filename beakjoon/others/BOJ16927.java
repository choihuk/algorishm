import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16927 {

    private static int[] dirx = {1, 0, -1, 0};
    private static int[] diry = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        String[][] matrix = new String[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = st.nextToken();
            }
        }

        int x = 0, y = 0;
        int os = Math.min(N, M)/2;

        for (int i = 0; i < os; i++) {
            int r = R % ((N - i * 2) * 2 + (M - i * 2) * 2 - 4);
            while (r-- > 0) {
                int around = 0;
                String temp = matrix[y][x];
                while (around < 4) {
                    int nx = x + dirx[around];
                    int ny = y + diry[around];
                    if (nx >= 0 + i && nx < M - i && ny >= 0 + i && ny < N - i) {
                        matrix[y][x] = matrix[ny][nx];
                        x = nx;
                        y = ny;
                    }else{
                        around++;
                    }
                }
                matrix[y + 1][x] = temp;
            }
            x++; y++;
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
}
