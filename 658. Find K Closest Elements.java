import java.util.*;
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> al=new ArrayList<>();
        int count=0,l,r,index=-1;
        //finding start index
        if(arr[0]>x){
            
        }
        else{
        for(int i=0;i<arr.length;i++){
            index=i;
            if(arr[i]>=x){
                break;
            }
        }
        }
        l=index-1;
        r=index+1;
        if(index==-1){
            
        }
        else if(l<0 || Math.abs(arr[index]-x)<Math.abs(arr[l]-x)){
            al.add(arr[index]);
            count++;
        }
        else{
            r=index;
        }
        while(count!=k && l>=0 && r<arr.length){
            if(Math.abs(arr[l]-x)<=Math.abs(arr[r]-x)){
                al.add(0,arr[l]);
                l--;
            }
            else{
                al.add(al.size(),arr[r]);
                r++;
            }
            count++;
        }
        while(count!=k && l>=0){
            al.add(0,arr[l]);
            count++;
            l--;
        }
        while(count!=k && r<arr.length){
            al.add(al.size(),arr[r]);
            r++;
            count++;
        }
        return al;
    }
}
