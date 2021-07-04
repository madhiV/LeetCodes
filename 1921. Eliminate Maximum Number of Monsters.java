import java.util.*;
class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int count=1,m=1;
        for(int i=0;i<dist.length;i++){
            if(dist[i]%speed[i]!=0){
                dist[i]=dist[i]/speed[i]+1;
            }
            else{
                dist[i]=dist[i]/speed[i];
            }
            pq.add(dist[i]);
        }
        pq.poll();
        while(!pq.isEmpty() && pq.peek()-m>0){
            m++;
            count++;
            pq.remove();
        }
        return count;
    }
}
