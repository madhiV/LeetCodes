class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int curr,max;
        max=1;
        curr=1;
        
        //Finding out the comparison value between ith index and i+1th index element and storing it in ith index
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                arr[i]=1;
            }
            else if(arr[i]==arr[i+1]){
                arr[i]=0;
            }
            else{
                arr[i]=-1;
            }
        }
        if(arr[0]==0 || arr.length==1){
            curr=0;
        }
        for(int i=1;i<arr.length-1;i++){
            if(arr[i]==0){
                curr=0;
            }
            else if(arr[i]==arr[i-1]){
                curr=1;
            }
            else{
                curr++;
            }
            max=Math.max(curr+1,max);
        }
        max=Math.max(curr+1,max);
        return max;
    }
}
