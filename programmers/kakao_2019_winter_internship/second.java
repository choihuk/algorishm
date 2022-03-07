import java.util.*;

class second {
    public int[] solution(String s) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        
        String input = s.substring(2,s.length()-2);
        String[] arr = input.split("\\},\\{");
        Arrays.sort(arr,(a,b) -> a.length() - b.length());
        for(String a : arr){
            String[] temp = a.split(",");
            for(String t : temp){
                int i = Integer.parseInt(t);
                if(set.add(i)){
                    list.add(i);
                }
            }
        }
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}