import java.util.*;
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> q=new PriorityQueue<>(
            new Comparator<int[]>(){
                @Override
                public int compare(int[] a,int[] b){
                    if(a[1]>b[1]){
                        return 1;
                    }
                    return -1;
                }
            }
        );
        int[] p1,p2;
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            new Comparator<int[]>(){
                @Override
                public int compare(int[] a,int[] b){
                    if(a[1]>b[1] || (a[1]==b[1] && a[2]>b[2])){
                        return 1;
                    }
                    return -1;
                }
            }
        );
        for(int i=0;i<trips.length;i++){
            pq.add(new int[]{trips[i][0],trips[i][1],trips[i][2]});
        }
        while(!pq.isEmpty()){
            p1=pq.poll();
            while(!q.isEmpty() && q.peek()[1]<=p1[1]){
                p2=q.poll();
                capacity+=p2[0];
            }
            capacity-=p1[0];
            if(capacity<0){
                return false;
            }
            q.add(new int[]{p1[0],p1[2]});
        }
        return true;
    }
}
