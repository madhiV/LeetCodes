class Solution {
    public int numTrees(int n) {
        int[] arr=new int[n+1];
        arr[0]=arr[1]=1;
        for(int i=2;i<=n;i++){
            computeCount(arr,i);
        }
        return arr[n];
    }
    public void computeCount(int[] arr,int n){
        for(int i=1;i<=n;i++){
            arr[n]+=arr[i-1]*arr[n-i];
        }
    }
}
