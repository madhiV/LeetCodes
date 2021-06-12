import java.util.*;
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> q=new PriorityQueue<Integer>(Collections.reverseOrder());
        int count=0,sum=startFuel,i=0;
        if(sum>=target){
            return 0;
        }
        while(i!=stations.length){
            if(stations[i][0]>startFuel){
                break;
            }
            q.add(stations[i][1]);
            i++;
        }
        while(!q.isEmpty()){
            count++;
            sum+=q.peek();
            q.remove();
            if(sum>=target){
                return count;
            }
            while(i!=stations.length){
                if(stations[i][0]>sum){
                    break;
                }
                q.add(stations[i][1]);
                i++;
            }
        }
        return -1;
    }
}
