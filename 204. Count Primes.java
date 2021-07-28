class Solution {
    public int countPrimes(int n) {
        int count=0;
        int[] arr=new int[n];
        for(int i=2;i<n;i++){
            if(arr[i]!=-1){
                count++;
                for(int j=i;j<n;j+=i){
                    arr[j]=-1;
                }
            }
        }
        return count;
    }
}
