import java.util.*;
class Solution {
    //다익스트라 알고리즘은 그리디 알고리즘이자 DP 기법을 사용한 알고리즘이다.
    //다익스트라 알고리즘은 한 정점을 기준으로 인접한 노드들의 비용을 계산하고, 가장 적은 비용의 노드를 
    //선택하는 과정을 반복한다. 우선순위큐를 사용하면 시간복잡도를 줄일 수 있다. 
    //우선순위 큐는 기준 노드에서 현재 선택하지 않은 노드들 중 갈 수 있는 가장 적은 비용의
    //노드를 선택하기 위해 V번 탐색이 아닌 logV번 탐색하게 해준다.
    private int aDistance;
    private int bDistance;
    private List<Node>[] listArr;
    private boolean[] visited;
    private int[] distance;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        listArr = new ArrayList[n+1];
        for(int i=1; i<=n; i++) listArr[i] = new ArrayList<>();
        for(int i=0; i<fares.length; i++){
            listArr[fares[i][0]].add(new Node(fares[i][1],fares[i][2]));
            listArr[fares[i][1]].add(new Node(fares[i][0],fares[i][2]));
        }
        visited = new boolean[n+1];
        distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[s] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s,0));
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            if(distance[curNode.index] < curNode.distance) continue;//중복 방지
            for(Node next : listArr[curNode.index]){
                if(distance[next.index]>distance[curNode.index] + next.distance){
                    distance[next.index] = distance[curNode.index] + next.distance;
                    pq.offer(new Node(next.index, distance[next.index]));
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            int fee = distance[i];
            if(fee==Integer.MAX_VALUE) continue;
            aDistance = Integer.MAX_VALUE;
            bDistance = Integer.MAX_VALUE;
            Arrays.fill(visited,false); visited[i] = true; DFS(i,a,0,true);
            Arrays.fill(visited,false); visited[i] = true; DFS(i,b,0,false);
            fee += aDistance+bDistance;
            answer = Math.min(answer,fee);
        }
        
        return answer;
    }
    private void DFS(int index, int d, int sum, boolean isA){
        if(index==d){
            if(isA) aDistance = Math.min(sum,aDistance);
            else bDistance = Math.min(sum,bDistance);
            return;
        }
        for(Node n : listArr[index]){
            int current = n.index;
            if(visited[current]) continue;
            visited[current] = true;
            DFS(current,d,sum+n.distance,isA);
            visited[current] = false;
        }
    }
    private class Node implements Comparable<Node>{
        public int index;
        public int distance;
        Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node n){return Integer.compare(this.distance,n.distance);}
    }
}