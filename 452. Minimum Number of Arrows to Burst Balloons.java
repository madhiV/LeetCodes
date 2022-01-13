import java.util.*;
class Solution {
    public int findMinArrowShots(int[][] points) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            new Comparator<int[]>(){
                @Override
                public int compare(int[] a,int[] b){
                    if(a[0]>b[0]){
                        return 1;
                    }
                    return -1;
                }
            }
        );
        int l,r,count=0;
        int[] p;
        for(int i=0;i<points.length;i++){
            pq.add(new int[]{points[i][0],points[i][1]});
        }
        while(!pq.isEmpty()){
            p=pq.poll();
            l=p[0];
            r=p[1];
            while(true){
                if(pq.isEmpty()){
                    break;
                }
                p=pq.peek();
                if(p[0]>r || p[1]<l){
                    break;
                }
                pq.remove();
                l=Math.max(l,p[0]);
                r=Math.min(r,p[1]);
            }
            count++;
        }
        return count;
    }
}
