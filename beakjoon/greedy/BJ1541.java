import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1541{
    // 문자열을 숫자와 연산자로 나누는 과정이 힘들었음. (정규화를 몰라..)
    // 근데 굳이 나누지 않고 for(char c : input.toCharArray()) 로 c=='+'나 c=='-'
    // 에 따라 여태껏 쌓아둔 숫자를 더하거나 빼는 작업으로 문제를 풀어도 됐음...
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] num = input.split("[-.]|[+.]");
        String[] cal = input.split("[0-9]");
        Queue<Integer> numbers = new LinkedList<>();
        Queue<String> operator = new LinkedList<>();
        for(String n:num) numbers.add(Integer.parseInt(n));
        for(String c : cal) if(!c.equals("")) operator.add(c);
        
        int result = numbers.poll();
        while(operator.peek()!=null){
            String o = operator.poll();
            if(o.equals("-")){
                result-=numbers.poll();
                while(operator.peek()!=null){
                    if(operator.peek().equals("+")){
                        result-=numbers.poll();
                        operator.poll();
                    }else{
                        break;
                    }
                }
            }else{
                result+=numbers.poll();
            }
        }
        System.out.print(result);
    }
}