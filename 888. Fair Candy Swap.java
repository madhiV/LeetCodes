class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aSum=0;
        int bSum=0;
        for(int i=0;i<aliceSizes.length;i++){
            aSum+=aliceSizes[i];
        }
        for(int i=0;i<bobSizes.length;i++){
            bSum+=bobSizes[i];
        }
        int[] ans=new int[2];
        for(int i=0;i<aliceSizes.length;i++){
            for(int j=0;j<bobSizes.length;j++){
                if(aSum-aliceSizes[i]+bobSizes[j]==bSum+aliceSizes[i]-bobSizes[j]){
                    ans[0]=aliceSizes[i];
                    ans[1]=bobSizes[j];
                    break;
                }
            }
        }
        return ans;
    }
}
