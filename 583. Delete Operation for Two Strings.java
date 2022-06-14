class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dpTable=new int[word1.length()+1][word2.length()+1];
        for(int ind1=1;ind1<=word1.length();ind1++){
            for(int ind2=1;ind2<=word2.length();ind2++){
                dpTable[ind1][ind2]=Math.max(dpTable[ind1-1][ind2],dpTable[ind1][ind2-1]);
                if(word1.charAt(ind1-1)==word2.charAt(ind2-1)){
                    dpTable[ind1][ind2]=Math.max(dpTable[ind1][ind2],dpTable[ind1-1][ind2-1]+1);
                }
            }
        }
        int ans=word1.length()+word2.length();
        ans-=dpTable[word1.length()][word2.length()]*2;
        return ans;
    }
}
