import java.util.*;
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer,Integer> map=new HashMap<>();
        int temp,count=0,zeroCount=0;
        for(int i=0;i<time.length;i++){
            time[i]=time[i]%60;
        }
        for(int i=0;i<time.length;i++){
            if(time[i]==0){
                temp=map.getOrDefault(0,0);
                count+=temp;
                map.put(0,temp+1);
                continue;
            }
            temp=map.getOrDefault(60-time[i],0);
            count+=temp;
            temp=map.getOrDefault(time[i],0);
            map.put(time[i],temp+1);
        }
        return count;
    }
}
