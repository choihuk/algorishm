public class five{
    public static void main(String[] args){
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        System.out.println(solution(stones,3));
    }
    public static int solution(int[] stones, int k) {
        int right = 5;
        int left = 1;
        while(right>left){
            int mid = (right+left)/2;
            int cnt = 1;
            int max = 0;
            for(int stone : stones){
                if(stone-mid>=0) cnt = 1;
                else cnt+=1;
                if(cnt>max) max = cnt;
            }
            if(max<k) left = mid;
            else right = mid+1;
        }
        return right;
    }
}