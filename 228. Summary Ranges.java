class Solution {
    public List<String> summaryRanges(int[] nums) {
        int i,start;
        List<String> l=new LinkedList<>();
        i=start=0;
        while(i<nums.length-1){
            if(nums[i+1]-nums[i] ==1){
                i++;
            }
            else{
                if(start!=i){
                    l.add(new String(nums[start]+"->"+nums[i]));
                }
                else{
                    l.add(new String(nums[i]+""));
                }
                i++;
                start=i;
            }
        }
        if(i<nums.length){
                if(start!=i){
                    l.add(new String(nums[start]+"->"+nums[i]));
                }
                else{
                    l.add(new String(nums[i]+""));
                }
        }
        return l;
    }
}
