import java.util.*;
class Solution {
    public String solution(String p) {
        return cal(p);
    }
    private String cal(String a){
        if(a.equals("")) return a;  //1

        char[] input = a.toCharArray();   //2
        int num = 0;
        int i=0;
        do{
            if(input[i++]=='(') num++;
            else num--;
        }while(num!=0);
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<i; j++) sb.append(input[j]);
        String u = sb.toString();

        sb = new StringBuilder();
        for(int j=i; j<input.length; j++) sb.append(input[j]);
        String v = sb.toString();

        boolean isRight = true;     //3
        int s = 0;
        for(int j=0; j<i&&isRight; j++){
            if(input[j]=='(') s++;
            else if(input[j]==')'){
                if(s<=0) isRight = false;
                else s--;
            }
        }
        if(isRight){
            return u + cal(v);      //3-1
        }else{                      //4
            String newStr = "("+cal(v)+")";
            char[] U = u.substring(1,u.length()-1).toCharArray();
            StringBuilder sb2 = new StringBuilder();
            for(char uu : U){
                if(uu=='(') sb2.append(')');
                else sb2.append('(');
            }
            return newStr + sb2.toString();
        }
    }
}