import java.util.*;
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        int temp;
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            temp=map.getOrDefault(nums1[i],0);
            map.put(nums1[i],temp+1);
        }
        for(int i=0;i<nums2.length;i++){
            temp=map.getOrDefault(nums2[i],0);
            if(temp>0){
                temp--;
                map.put(nums2[i],temp);
                al.add(nums2[i]);
            }
        }
        int[] arr=new int[al.size()];
        temp=0;
        for(int k:al){
            arr[temp]=al.get(temp);
            temp++;
        }
        return arr;
    }
}
