import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1541{
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