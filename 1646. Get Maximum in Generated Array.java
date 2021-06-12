class Solution {
    public int getMaximumGenerated(int n) {
        int[] arr=new int[n+1];
        arr[0]=0;
        if(n==0){
            return 0;
        }
        arr[1]=1;
        for(int i=0;i<=n;i++){
            if(2*i > n){
                break;
            }
            arr[2*i]=arr[i];
            if(i*2+1>n){
                break;
            }
            arr[2*i+1]=arr[i]+arr[i+1];
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<=n;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }
}
