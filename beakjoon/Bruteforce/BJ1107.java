import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ1107{
    public static void main(String[] args) throws IOException{
        // 맨 처음은 정답인 버튼을 하나씩 찾아가는 방식으로 접근 -> 맨 앞 버튼의 값을 알기 위해 다음 값을 알 필요가 발생 + 고려해야 할 대상이 너무 많음
        // channel을 기준으로 오른쪽과 왼쪽 중 검색 가능한 버튼 중 channel과 가장 가까운 값 + channel.length 반환 -> 가까운 값 + length값 의 최솟값
        // 을 찾는 것이 아닌 가까운 값의 최솟값을 찾았기에 에러 발생
        // 결국 channel과 버튼으로 입력가능한 가장 가까운 값+length를 비교할 수 있는 방법인 0~999999까지를 다 조사해보는 방법밖엔 없었음.
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String channel = br.readLine();
        int ch = Integer.parseInt(channel);
        int btLength = Integer.parseInt(br.readLine());
        HashSet<String> bt = new HashSet<>();
        if(btLength!=0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<btLength; i++) bt.add(st.nextToken());
        }
        
        int result = Integer.MAX_VALUE;
        for(int i=0;i<=999999;i++){
            boolean isSearch = true;
            int len = Integer.toString(i).length();
            for(int k=0;k<len;k++){
                String num = Integer.toString(i).substring(k,k+1);
                if(bt.contains(num)) isSearch = false;
            }
            if(!isSearch) continue;
            else 
                if(result>Math.abs(ch-i)+len) result=Math.abs(ch-i)+len;
        }
        result = Math.min(Math.abs(result),Math.abs(ch-100));
        System.out.println(result);
        br.close();
    }
}