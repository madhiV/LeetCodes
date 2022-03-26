import java.util.*;
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int minCost=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            new Comparator<int[]>(){
                @Override
                public int compare(int[] a,int[] b){
                    if(a[1]<b[1]){
                        return 1;
                    }
                    return -1;
                }
            }
        );
        for(int i=0;i<costs.length;i++){
            pq.add(new int[]{i,Math.abs(costs[i][0]-costs[i][1])});
        }
        int n=costs.length/2;
        int city1Count=0;
        int city2Count=0;
        while(!pq.isEmpty()){
            int[] p=pq.poll();
            int city1Cost=costs[p[0]][0];
            int city2Cost=costs[p[0]][1];
            if(city1Cost<city2Cost){
                if(city1Count<n){
                    city1Count++;
                    minCost+=city1Cost;
                }
                else{
                    minCost+=city2Cost;
                }
            }
            else{
                if(city2Count<n){
                    city2Count++;
                    minCost+=city2Cost;
                }
                else{
                    minCost+=city1Cost;
                }
            }
        }
        return minCost;
    }
}
