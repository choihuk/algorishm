import java.util.*;

class third {
    private String[] user;
    private String[] banned;
    private boolean[] check;
    private List<List<Integer>> list;
    private int answer;
    public int solution(String[] user_id, String[] banned_id) {
        user = user_id;
        banned = banned_id;
        answer = 0;
        check = new boolean[user.length];
        list = new ArrayList<>();
        
        DFS(0);
        return answer;
    }
    private void DFS(int cnt){
        if(cnt==banned.length){
            List<Integer> a = new ArrayList<>();
            for(int i=0; i<user.length; i++){
                if(check[i]) a.add(i);
            }
            boolean is = false;
            for(int i=0; i<list.size(); i++){
                for(int j=0; j<cnt; j++){
                    if(!a.contains(list.get(i).get(j))) is = true;
                }
            }
            if(is||list.size()==0){
                list.add(a);
                answer++;
            }
            return;
        }
        for(int i=0; i<user.length; i++){
            if(check[i]) continue;
            char[] ban = banned[cnt].toCharArray();
            char[] u = user[i].toCharArray();
            boolean isSame = true;
            if(ban.length==u.length){
                for(int j=0; j<u.length; j++){
                    if(!(ban[j]==u[j]||ban[j]=='*')) isSame = false;
                }
            }else isSame = false;
            if(isSame){
                check[i] = true;
                DFS(cnt+1);
                check[i] = false;
            }
        }
    }
}