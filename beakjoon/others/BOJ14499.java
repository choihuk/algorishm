//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class BOJ14499 {
//
//    private static int dx,dy,nx,ny;
//    private static int[][] dice;
//    private static final int[] dirx = {1, -1, 0, 0};
//    private static final int[] diry = {0, 0, -1, 1};
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//        int x = Integer.parseInt(st.nextToken());
//        int y = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//
//        int[][] matrix = new int[N][M];
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < M; j++) {
//                matrix[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        dice = new int[4][3];
//        dx = 1; dy = 1;
//
//        st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
//
//        while (K-- > 0) {
//            int next = Integer.parseInt(st.nextToken()) - 1;
//            nx = x + dirx[next];
//            ny = y + diry[next];
//            if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
//            if (matrix[ny][nx] == 0) {
//                matrix[ny][nx] = push(next);
//            } else {
//                pop(matrix[ny][nx], next);
//                matrix[ny][nx] = 0;
//            }
//            x = nx; y = ny;
//            if (dx == 1) {
//                int ndy = (dy + 2) % 4;
//                sb.append(dice[ndy][dx]).append(" ");
//                System.out.println(dy + " "+ dx);
//            } else {
//                int ndx = dx==0 ? 2 : 0;
//                sb.append(dice[dy][ndx]).append(" ");
//                System.out.println(dy + " " + dx);
//            }
//        }
//        System.out.println(sb.toString());
//    }
//
//    private static void pop(int num, int next) {
//        int ndx = dx + dirx[next], ndy = dy + diry[next];
//        ndx = ndx < 0 ? 2 : ndx > 2 ? 0 : ndx;
//        ndy = ndy < 0 ? 3 : ndy > 3 ? 0 : ndy;
//        if(dx==ndx && ndx!=1) ndx = 1;
//        else if(dy==ndy && ndy!=1) ndy = 1;
//
//        dice[ndy][ndx] = num;
//        dx = ndx; dy = ndy;
//    }
//
//    private static int push(int next) {
//        int ndx = dx + dirx[next], ndy = dy + diry[next];
//        ndx = ndx < 0 ? 2 : ndx > 2 ? 0 : ndx;
//        ndy = ndy < 0 ? 3 : ndy > 3 ? 0 : ndy;
//        if(dx==ndx && ndy!=1) ndy = 1;
//        else if(dy==ndy && ndx!=1) ndx = 1;
//
//        dx = ndx; dy = ndy;
//        return dice[ndy][ndx];
//    }
//
//}
