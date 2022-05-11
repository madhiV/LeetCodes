class Solution {
    private Integer[][] dpTable;
    public int countVowelStrings(int n) {
        dpTable=new Integer[5][n+1];
        return countVowelStrings(0,n);
    }
    private int countVowelStrings(int currentIndex,int reqCharCount){
        if(reqCharCount==0){
            return 1;
        }
        if(currentIndex==5){
            return 0;
        }
        if(dpTable[currentIndex][reqCharCount]!=null){
            return dpTable[currentIndex][reqCharCount];
        }
        int count=countVowelStrings(currentIndex+1,reqCharCount);
        while(reqCharCount>0){
            reqCharCount--;
            count+=countVowelStrings(currentIndex+1,reqCharCount);
        }
        dpTable[currentIndex][reqCharCount]=count;
        return count;
    }
}
