import java.util.*;
class Solution {
    private class Input{
        public String message;
        public String userId;
        Input(String first, String userId){
            if(first.equals("Enter")){
                message = "님이 들어왔습니다.";
            }else{
                message = "님이 나갔습니다.";
            }
            this.userId = userId;
        }
    }
    public String[] solution(String[] record) {
        Queue<Input> queue = new LinkedList<>();
        HashMap<String,String> nickMap = new HashMap<>();
        for(String r : record){
            StringTokenizer st = new StringTokenizer(r);
            String first = st.nextToken();
            String userId= st.nextToken();
            if(first.equals("Leave")){
                queue.add(new Input(first,userId));
            }else{
                String nickname = st.nextToken();
                if(first.equals("Enter")){
                    queue.add(new Input(first,userId));
                }
                nickMap.put(userId,nickname);
            }
            
        }
        String[] answer = new String[queue.size()];
        int i=0;
        Iterator<Input> it = queue.iterator();
        while(it.hasNext()){
            Input input = it.next();
            answer[i++] = nickMap.get(input.userId)+input.message;
        }
        return answer;
    }
}