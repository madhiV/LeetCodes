import java.util.TreeMap;
class Solution {
    public boolean find132pattern(int[] nums) {
        int[] smallestPrefix=new int[nums.length];
        fillSmallestPrefix(smallestPrefix,nums);
        return has132Pattern(smallestPrefix,nums);
    }
    public void fillSmallestPrefix(int[] smallestPrefix,int[] nums){
        int minimumElement=nums[0];
        for(int index=1;index<nums.length;index++){
            smallestPrefix[index]=minimumElement;
            minimumElement=Math.min(minimumElement,nums[index]);
        }
    }
    public boolean has132Pattern(int[] smallestPrefix,int[] nums){
        TreeMap<Integer,Integer> elementToCount=new TreeMap<>();
        //Fill tree map
        fillTreeMap(elementToCount,nums);
        
        for(int index=1;index<nums.length;index++){
            //Reducing occurence of nums[index] by 1
            int count=elementToCount.get(nums[index]);
            if(count==1){
                elementToCount.remove(nums[index]);
            }
            else{
                elementToCount.put(nums[index],count-1);
            }
            //Checking for lesser element in left and greater element on right
            if(smallestPrefix[index]<nums[index]){
                Integer greaterElement=elementToCount.higherKey(smallestPrefix[index]);
                if(greaterElement!=null && greaterElement<nums[index]){
                    return true;
                }
            }
        }
        return false;
    }
    public void fillTreeMap(TreeMap<Integer,Integer> elementToCount,int[] nums){
        for(int index=1;index<nums.length;index++){
            int count=elementToCount.getOrDefault(nums[index],0);
            elementToCount.put(nums[index],count+1);
        }
    }
}
