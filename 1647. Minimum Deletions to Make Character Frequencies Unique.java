import java.util.Map;
import java.util.HashMap;
class Solution {
    public int minDeletions(String s) {
        Map<Character,Integer> charToFrequency=new HashMap<>();
        //Store charToCount into map
        storeCharToCount(s,charToFrequency);
        PriorityQueue<Integer> frequencies=new PriorityQueue<>(Collections.reverseOrder());
        frequencies.addAll(charToFrequency.values());
        int prevFrequency=frequencies.poll();
        int deletionCount=0;
        while(prevFrequency!=1 && !frequencies.isEmpty()){
            int polledFrequency=frequencies.poll();
            if(polledFrequency>=prevFrequency){
                int charsToDel=polledFrequency-prevFrequency+1;
                polledFrequency-=charsToDel;
                deletionCount+=charsToDel;
            }
            prevFrequency=polledFrequency;
        }
        //Add remaining frequencies
        while(!frequencies.isEmpty()){
            deletionCount+=frequencies.poll();
        }
        return deletionCount;
    }
    private void storeCharToCount(String s,Map<Character,Integer> charToFrequency){
        for(int ind=0;ind<s.length();ind++){
            int frequency=charToFrequency.getOrDefault(s.charAt(ind),0);
            frequency++;
            charToFrequency.put(s.charAt(ind),frequency);
        }
    }
}
