class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1,l2;
        l1=text1.length();
        l2=text2.length();
        int[][] table=new int[l1+1][l2+1];
        for(int i=1;i<l1+1;i++){
            for(int j=1;j<l2+1;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    table[i][j]=table[i-1][j-1]+1;
                }
                else{
                    table[i][j]=Math.max(table[i-1][j],table[i][j-1]);
                }
            }
        }
        return table[l1][l2];
    }
}
