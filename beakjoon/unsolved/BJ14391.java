//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Map;
//import java.util.StringTokenizer;
//
//public class BJ14391 {
//    private static int N;
//    private static int M;
//    private static int[][] arr;
//    private static int answer;
//    private static boolean[][] visited;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        arr = new int[N][M];
//        visited = new boolean[N][M];
//        answer = 0;
//        for (int i = 0; i < N; i++) {
//            char[] token = br.readLine().toCharArray();
//            for (int j = 0; j < M; j++) {
//                arr[i][j] = token[j]-'0';
//            }
//        }
//
//        DFS(0);
//        System.out.println(answer);
//    }
//    private static void DFS(int sum) {
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if(visited[i][j]) continue;
//                int add = 0;
//                for (int k = j; k <M && !visited[i][k]; k++) {
//                    visited[i][k] = true;
//                    add = add*10 + arr[i][k];
//                    DFS(sum+add);
//                }
//                for (int k = M - 1; k > j; k--) visited[i][k] = false;
//
//                add = arr[i][j];
//                for (int k = i+1; k < N && !visited[k][j]; k++) {
//                    visited[k][j] = true;
//                    add = add*10 + arr[k][j];
//                    DFS(sum+add);
//                }
//                for (int k = N-1; k >= i ; k--) visited[k][j] = false;
//            }
//        }
//        answer = Math.max(answer,sum);
//    }
//}
