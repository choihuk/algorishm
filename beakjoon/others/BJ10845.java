import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while(N --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push": queue.add(Integer.parseInt(st.nextToken())); break;
                case "pop": sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n"); break;
                case "size": sb.append(queue.size()).append("\n"); break;
                case "empty": sb.append(queue.isEmpty() ? 1 : 0).append("\n"); break;
                case "front": sb.append(queue.isEmpty()? -1 : queue.peekFirst()).append("\n"); break;
                case "back": sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n"); break;
            }
        }
        System.out.println(sb.toString());
    }
}
