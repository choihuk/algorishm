import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16926 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int a = Math.min(N, M)/2;
        while (--a >= 0) {
            int r = R % ((N - a * 2) * 2 + (M - a * 2) * 2 - 4);
            while (r-- > 0) {
                int temp = arr[a][a];
                for(int i=a; i<M-a-1; i++) arr[a][i] = arr[a][i+1];
                for(int i=a; i<N-a-1; i++) arr[i][M-a-1] = arr[i+1][M-a-1];
                for(int i=M-a-1; i>a; i--) arr[N-a-1][i] = arr[N-a-1][i-1];
                for(int i=N-a-1; i>a; i--) arr[i][a] = arr[i-1][a];
                arr[a + 1][a] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
