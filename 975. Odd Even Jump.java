import java.util.TreeMap;
import java.util.Map.Entry;
class Solution {
    public int oddEvenJumps(int[] arr) {
        TreeMap<Integer,Integer> elements=new TreeMap<>();
        boolean[] reachAtOddJump=new boolean[arr.length];
        boolean[] reachAtEvenJump=new boolean[arr.length];
        int lastIndex=arr.length-1;
        reachAtOddJump[lastIndex]=true;
        reachAtEvenJump[lastIndex]=true;
        elements.put(arr[lastIndex],lastIndex);
        
        for(int i=lastIndex-1;i>=0;i--){
            //Odd jump
            Entry<Integer,Integer> ceiledEntry=elements.ceilingEntry(arr[i]);
            if(ceiledEntry!=null){
                int index=ceiledEntry.getValue();
                if(reachAtEvenJump[index]==true){
                    reachAtOddJump[i]=true;
                }
            }
            
            //Even jump
            Entry<Integer,Integer> flooredEntry=elements.floorEntry(arr[i]);
            if(flooredEntry!=null){
                int index=flooredEntry.getValue();
                if(reachAtOddJump[index]==true){
                    reachAtEvenJump[i]=true;
                }
            }
            
            elements.put(arr[i],i);
        }
        return countGoodIndices(reachAtOddJump);
    }
    private int countGoodIndices(boolean[] arr1){
        int count=0;
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]){
                count++;
            }
        }
        return count;
    }
}
