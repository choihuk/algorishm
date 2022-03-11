import java.util.*;
class Solution {
    private char[] children = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private boolean[] visited;
    private List<Character> input;
    private int answer;
    public int solution(int n, String[] data) {
        answer = 0;
        visited = new boolean[8];
        input = new ArrayList<>();
        DFS(0, data);
        return answer;
    }
    private void DFS(int cnt, String[] data){
        if(cnt==8){
            boolean isRight = true;
            for(String d :data){
                int a = input.indexOf(d.charAt(0));
                int b = input.indexOf(d.charAt(2));
                char sign = d.charAt(3);
                int num = d.charAt(4)-'0';
                if(sign=='='){
                    if(Math.abs(a-b)!=num+1) {isRight = false; break;}
                }else if(sign=='<'){
                    if(!(Math.abs(a-b)<num+1)) {isRight = false; break;}
                }else{
                    if(!(Math.abs(a-b)>num+1)) {isRight = false; break;}
                }
            }
            if(isRight) answer++;
            return;
        }
        for(int i=0; i<8; i++){
            if(visited[i]) continue;
            visited[i] = true;
            if(input.size()<=cnt) input.add(children[i]);
            else input.set(cnt,children[i]);
            DFS(cnt+1,data);
            visited[i] = false;
        }
    }
}