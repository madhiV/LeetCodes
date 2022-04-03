import java.util.*;
class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        int max=nums[nums.length-1];
        while(i>=0){
            if(nums[i]>max){
                max=nums[i];
            }
            else if(nums[i]<max){
                int maxIndex=findMinMax(nums,i);
                swap(nums,i,maxIndex);
                sort(nums,i+1,nums.length-1);
                break;
            }
            i--;
        }
        if(i==-1){
            sort(nums,0,nums.length-1);
        }
    }
    public int findMinMax(int[] nums,int index){
        int min=Integer.MAX_VALUE;
        int minIndex=-1;
        int element=nums[index];
        while(index<nums.length){
            if(element<nums[index] && min>=nums[index]){
                minIndex=index;
                min=nums[index];
            }
            index++;
        }
        return minIndex;
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void sort(int[] nums,int i,int j){
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
}
