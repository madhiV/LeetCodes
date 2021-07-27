class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] arr=new int[26];
        int val=0;
        for(int i=0;i<s.length();i++){
            val=arr[s.charAt(i)-97]+=1;
        }
        for(int i=0;i<26;i++){
            if(arr[i]!=0 && arr[i]!=val){
                return false;
            }
        }
        return true;
    }
}
