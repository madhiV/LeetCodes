class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int l=0,r=cardPoints.length-k;
        int currentSum=sumRange(cardPoints,r);
        int maxSum=currentSum;
        while(l<cardPoints.length){
            maxSum=Math.max(currentSum,maxSum);
            if(r==cardPoints.length){
                break;
            }
            currentSum-=cardPoints[r];
            currentSum+=cardPoints[l];
            l++;
            r++;
        }
        return maxSum;
    }
    private int sumRange(int[] cardPoints,int start){
        int sum=0;
        while(start<cardPoints.length){
            sum+=cardPoints[start];
            start++;
        }
        return sum;
    }
}
