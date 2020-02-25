package permutation;

class Solution {
    public int[] solution(int[][] v) {
        int[] answer = {0,0};
        int[] a = {v[0][0],v[1][0],v[2][0]};
        int[] b = {v[0][1],v[1][1],v[2][1]};
        if(a[0]==a[1]) {
        	answer[0]=a[2];
        }else if(a[0]==a[2]) {
        	answer[0]=a[1];
        }else if(a[1]==a[2]) {
        	answer[0]=a[0];
        }
        if(b[0]==b[1]) {
        	answer[1]=b[2];
        }else if(b[0]==b[2]) {
        	answer[1]=b[1];
        }else if(b[1]==b[2]) {
        	answer[1]=b[0];
        }
        
        return answer;
    }
}