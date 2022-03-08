import java.util.*;

class four {
    public long[] solution(long k, long[] room_number) {
        List<Long> list = new ArrayList<>();
        List<Clustor> store = new ArrayList<>();
        for(int i=0; i<room_number.length; i++){
            long room = room_number[i];
            long index = 0;
            int a = 0;
            for(int j=0; j<store.size(); j++){
                Clustor cl = store.get(j);
                long first = cl.first;
                long last = cl.last;
                if(first<=room&&room<=last){
                    index = last+1;
                    list.add(index);
                    cl.last = index;
                    a = j;
                    break;
                }
            }
            if(index==0){
                list.add(room);
                Clustor cl = new Clustor(room);
                if(store.size()==0) store.add(cl);
                else{
                    int index2 = 0;
                    for(int j=0; j<store.size(); j++){
                        if(store.get(j).last<room) index2++;
                    }
                    a = index2;
                    store.add(index2,cl);
                }
            }
            int as = 0;
             for(int j=a; j<store.size()-1&&as<=1; j++){
                if(store.get(j).last==store.get(j+1).first-1){
                    store.get(j).last = store.get(j+1).last;
                    store.remove(j+1);
                    j-=1;
                    as++;
                }
            }
        }
        long[] answer = new long[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    class Clustor{
        public long first;
        public long last;
        Clustor(long num){this.first = num; this.last = num;}
    }
}