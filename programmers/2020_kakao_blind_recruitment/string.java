import java.util.*;
class Solution {
    private class In{
        public String str;
        public int count;
        In(String str){this.str = str; count = 1;}
    }
    public int solution(String s) {
        char[] input = s.toCharArray();
        int answer = Integer.MAX_VALUE;
        int length = s.length()/2>0 ? s.length()/2 : 1;
        for(int i=1; i<=length; i++){
            Stack<In> stack = new Stack<>();
            StringBuilder temp = new StringBuilder();
            for(int j=0; j<i; j++) temp.append(input[j]);
            stack.push(new In(temp.toString()));
            for(int j=i; j<s.length(); j+=i){
                StringBuilder a = new StringBuilder();
                for(int k=j; k<j+i&&k<s.length(); k++) a.append(input[k]);
                if(stack.peek().str.equals(a.toString())) stack.peek().count++;
                else stack.push(new In(a.toString()));
            }
            StringBuilder result = new StringBuilder();
            while(!stack.isEmpty()){
                In in = stack.pop();
                if(in.count==1) result.append(in.str);
                else result.append((int)Math.log10(in.count)+1).append(in.str);
            }
            int num = result.toString().length();
            if(answer>num) answer = num;
        }
        return answer;
    }
}