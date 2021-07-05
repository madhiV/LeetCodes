import java.util.*;
class Solution {
    public String sortString(String s) {
        char[] arr=s.toCharArray();
        quickSort(arr,0,arr.length);
        Set<Integer> set=new HashSet<Integer>();
        String ans="";
        char prev;
        while(ans.length()<s.length()){
            //Left to right
            prev='.';
            for(int i=0;i<s.length();i++){
                if(!set.contains(i) && arr[i]!=prev){
                    set.add(i);
                    ans+=arr[i];
                    prev=arr[i];
                }
            }
            prev='.';
            //Right to left
            for(int i=s.length()-1;i>=0;i--){
                if(!set.contains(i) && arr[i]!=prev){
                    set.add(i);
                    ans+=arr[i];
                    prev=arr[i];
                }
            }
        }
        return ans;
    }
    void quickSort(char[] arr,int l,int r){
        if(l<r){
            int j=partition(arr,l,r);
            quickSort(arr,l,j);
            quickSort(arr,j+1,r);
        }
    }
    int partition(char[] arr,int l,int r){
        int j=r,i=l,pivot=(l+r)/2;
        char e,temp;
        e=arr[pivot];
        temp=arr[pivot];
        arr[pivot]=arr[l];
        arr[l]=temp;
        while(i<j){
            do{
                i++;
            }while(i<j && arr[i]<=e);
            do{
                j--;
            }while(j>0 && arr[j]>e);
            if(i<j){
                temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        arr[l]=arr[j];
        arr[j]=e;
        return j;
    }
}
