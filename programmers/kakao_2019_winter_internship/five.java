class Solution {
    public int solution(int[] stones, int k) {
        int right = 10;
        for(int stone : stones) if(right<stone) right=stone;
        int left = 1;
        while(right>left){
            int mid = (right+left)/2;
            int cnt = 1;
            int max = 0;
            for(int stone : stones){
                if(stone-mid<0) cnt += 1;
                else cnt = 1;
                if(cnt>max) max = cnt;
            }
            if(max<=k) left = mid+1;
            else right = mid;
        }
        return right-1;
    }
}