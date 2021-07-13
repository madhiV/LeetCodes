class Solution {
    public int[] plusOne(int[] digits) {
        int temp;
        int carry=(digits[digits.length-1]+1)/10;
        digits[digits.length-1]=(digits[digits.length-1]+1)%10;
        for(int i=digits.length-2;i>=0;i--){
            temp=carry+digits[i];
            carry=(temp)/10;
            digits[i]=(temp)%10;
        }
        if(carry!=0){
            int[] ans=new int[digits.length+1];
            ans[0]=carry;
            for(int i=1;i<ans.length;i++){
                ans[i]=digits[i-1];
            }
            return ans;
        }
        return digits;
    }
}
